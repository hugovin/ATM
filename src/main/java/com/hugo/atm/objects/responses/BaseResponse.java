package com.hugo.atm.objects.responses;

public class BaseResponse {
	
	private String Message;
	
	private boolean Acknowledgment;	
	
	
	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public boolean isAcknowledgment() {
		return Acknowledgment;
	}

	public void setAcknowledgment(boolean acknowledgment) {
		Acknowledgment = acknowledgment;
	}
	
	

	public BaseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BaseResponse [Message=" + Message + ", Acknowledgment="
				+ Acknowledgment + "]";
	}
	
	
	
	

}

