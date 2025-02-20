package com.ssk.attendancetracker.exceptions;

public class AttendanceTrackerException extends RuntimeException{
	
	private Integer status;
	private String message;
	private String errorCode;
	
	public AttendanceTrackerException() {
		super();
	}
	
	public AttendanceTrackerException(String message) {
		super(message);
		this.message=message;
	}
	
	public AttendanceTrackerException(Integer status,String message,String errorCode) {
		super(message);
		this.message=message;
		this.status=status;
		this.errorCode=errorCode;
	}

}
