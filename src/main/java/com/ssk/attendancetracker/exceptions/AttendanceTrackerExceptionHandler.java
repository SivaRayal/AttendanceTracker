package com.ssk.attendancetracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AttendanceTrackerExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {AttendanceTrackerException.class})
	public ResponseEntity<Object> handleRuntimeApplicationException(AttendanceTrackerException ex){
		String errorMessage=ex.getLocalizedMessage();
		if(errorMessage==null) errorMessage=ex.toString();
		return new ResponseEntity(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
