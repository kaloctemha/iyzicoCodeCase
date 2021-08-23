package com.iyzico.challenge.service;

public class BankPaymentResponse {

    private String resultCode;
    
    public BankPaymentResponse() {
		// TODO Auto-generated constructor stub
	}

    public BankPaymentResponse(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    
    public String toString() {
    	return "ResultCode : " + getResultCode();
    }
}


