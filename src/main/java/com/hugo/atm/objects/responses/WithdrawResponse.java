package com.hugo.atm.objects.responses;

import java.util.List;

public class WithdrawResponse extends BaseResponse {
	
	private List<String> DenominationNotes;
	

	public WithdrawResponse() {
		super();
	}

	public WithdrawResponse(List<String> denominationNotes) {
		super();
		DenominationNotes = denominationNotes;
	}

	public List<String> getDenominationNotes() {
		return DenominationNotes;
	}

	public void setDenominationNotes(List<String> denominationNotes) {
		DenominationNotes = denominationNotes;
	}
	
	

}
