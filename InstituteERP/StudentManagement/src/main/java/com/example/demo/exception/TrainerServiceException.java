package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class TrainerServiceException extends RuntimeException {

	private String message;
    private HttpStatus httpstatus;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
	public TrainerServiceException(String message, HttpStatus httpstatus) {
		super();
		this.message = message;
		this.httpstatus = httpstatus;
	}
	


    
}