package com.ssk.attendancetracker.controllers;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssk.attendancetracker.exceptions.AttendanceTrackerException;
import com.ssk.attendancetracker.model.AttendanceRequest;
import com.ssk.attendancetracker.service.AttendanceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/monitor")
@Slf4j
public class AttendanceTrackerController {
	
	@Autowired
	AttendanceService attendanceService; 
	
	@PostMapping(path = "/updateAttendance")
	public ResponseEntity<String> updateAttendance(@RequestHeader HttpHeaders header,@RequestBody AttendanceRequest request){
		
		try {
			attendanceService.updateAttendance(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info(e.getLocalizedMessage());
			
			throw new AttendanceTrackerException("Failure at updating attendance");
		}
		return new ResponseEntity("Attendance Submitted Sucessfully",HttpStatus.OK);
		
	}

}
