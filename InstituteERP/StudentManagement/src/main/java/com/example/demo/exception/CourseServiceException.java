package com.example.demo.exception;

import org.springframework.http.HttpStatus;


public class CourseServiceException extends RuntimeException {

    private String errorMessage;
    private HttpStatus httpStatus;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public CourseServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public CourseServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public CourseServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public CourseServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
    
     
    
}


