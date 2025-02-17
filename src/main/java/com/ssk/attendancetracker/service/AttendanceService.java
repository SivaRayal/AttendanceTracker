package com.ssk.attendancetracker.service;

import java.io.FileNotFoundException;

import com.ssk.attendancetracker.model.AttendanceRequest;

public interface AttendanceService {
	public String updateAttendance(AttendanceRequest request);
	public String getReports();
	
}
