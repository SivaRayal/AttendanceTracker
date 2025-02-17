package com.ssk.attendancetracker.model;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttendanceRequest implements Serializable{
	public static final long serialVersionUID=360L;
	
	@JsonProperty("EmployeeId")
	public String employeeId;
	@JsonProperty("Email")
	public String email;
	//@JsonProperty("Role")
	//public String role;
	@JsonProperty("Project")
	public String project;
	@JsonProperty("Date")
	public Date date;
	@JsonProperty("Location")
	public String location;
	@JsonProperty("LocationVerification")
	public String locationVerification;
	@JsonProperty("AttendanceStatus")
	public String attendanceStatus;
	@JsonProperty("LoginTime")
	public String loginTime;
	@JsonProperty("LogoutTime")
	public String logoutTime;
	@JsonProperty("Comments")
	public String comments;

	
}
