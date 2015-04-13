package com.hugo.atm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hugo.atm.objects.responses.WithdrawResponse;


@Service
public class WithdrawService {
	
	@Value("${user.account}")
    private String userAccount;
	
	@Autowired
	AccountService accountService;

	public WithdrawResponse GetMoney(double amount)
	{
		WithdrawResponse response = new WithdrawResponse();
		try {
			if(amount <= accountService.GetBalance()){
				if(accountService.DecreaseBalance(userAccount,amount).isAcknowledgment()){
					List<String> denominationsNotes = GetDenominationNotes(amount);
					if(denominationsNotes.size() > 0)
					{
						response.setDenominationNotes(denominationsNotes);
						response.setAcknowledgment(true);
						response.setMessage("success");
					}				
					
				}else{
					response.setAcknowledgment(false);
					response.setMessage("Unable to decrease funds. Try Later");
				}
				
			}else{
				response.setAcknowledgment(false);
				response.setMessage("Not enough funds!");
				
			}
		} catch (Exception e) {
			response.setAcknowledgment(false);
			response.setMessage(e.getMessage());
		
		}
		return response;
	}
	
	
	public List<String> GetDenominationNotes(double amount){
		
		List<String> response = new ArrayList<String>();
		try {
			double[] notes = {20000,10000,5000,2000};
			for (double note : notes) {
				double operationResult = amount / note;
				int howMany = new Double(operationResult).intValue() ;
				if(howMany >= 1)
				{
					response.add(howMany+ ((howMany > 1)?" bills of ":" bill of ") + note +" Colones");
				}
				amount = amount % note;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return response;
	}
	
}
