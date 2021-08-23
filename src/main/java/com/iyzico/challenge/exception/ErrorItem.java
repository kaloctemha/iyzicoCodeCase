package com.iyzico.challenge.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ErrorItem {
	
    @JsonInclude(JsonInclude.Include.NON_NULL) private String message;
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
