package com.hugo.atm.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hugo.atm.objects.responses.BaseResponse;

@Service
public class AccountService {
	
	@Value("${user.balance}")
    private String userbalance;
	
	public double GetBalance(){
		return Double.parseDouble(userbalance);
	}
	
	public BaseResponse DecreaseBalance(String account,double amount){
		BaseResponse response = new BaseResponse();
		try {
			
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("atm.properties").getFile());
			FileInputStream in = new FileInputStream(file);
			Properties props = new Properties();
			props.load(in);
			in.close();
			FileOutputStream out = new FileOutputStream(file);
			props.setProperty("user.balance", String.valueOf((Double.parseDouble(userbalance)-amount)));
			props.store(out, null);
			out.close();
			response.setAcknowledgment(true);
			response.setMessage("Success");
			return response;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			response.setAcknowledgment(false);
			response.setMessage(e.getMessage());
			return response;
		} catch (IOException e) { 
			e.printStackTrace();
			response.setAcknowledgment(false);
			response.setMessage(e.getMessage());
			return response;
		}
		
	}
	
}
