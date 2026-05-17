package com.example.demo.globalexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.BatchServiceException;
import com.example.demo.exception.CounserllorException;
import com.example.demo.exception.CourseServiceException;
import com.example.demo.exception.TrainerServiceException;
import com.example.demo.exception.UsersServiceException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value= UsersServiceException.class)
	ResponseEntity<String> handleUsersServiceException(UsersServiceException use) {
		return new ResponseEntity<String>(use.getMessage(), use.getHttpStatus());
	}
	
	@ExceptionHandler(value = BatchServiceException.class)
	public ResponseEntity<String> handleBatchServiceException(BatchServiceException be)
	{
		return new ResponseEntity<>(be.getMessage() ,be.getHttpStatus());
	}
	
	@ExceptionHandler(value = TrainerServiceException.class)
	public ResponseEntity<String> handleTrainerServiceException(TrainerServiceException te)
	{
		return new ResponseEntity<>(te.getMessage() ,te.getHttpstatus() );
	}
	@ExceptionHandler(value = CourseServiceException.class)
	public ResponseEntity<String> handleCourseServiceException(CourseServiceException ce)
	{
		return new ResponseEntity<>(ce.getMessage() ,ce.getHttpStatus());
	}

	@ExceptionHandler(value = Exception.class)
	ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(value = CounserllorException.class)
	ResponseEntity<String> handleCounsellorException(CounserllorException e) {
		return new ResponseEntity<String>(e.getMessage(), e.getHttpStatus());
	}
	
}
