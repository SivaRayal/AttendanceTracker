package com.ssk.attendancetracker.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.ssk.attendancetracker.model.AttendanceRequest;
import com.ssk.attendancetracker.service.AttendanceService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AttendanceServiceHandler implements AttendanceService{

	@Override
	public String updateAttendance(AttendanceRequest request) {
		// TODO Auto-generated method stub
		FileInputStream file;
		try {
			file = new FileInputStream(new File("/attendancetracker/src/main/resources/AttendanceReport.xlsx"));
			HSSFWorkbook workbook=new HSSFWorkbook(file);
			HSSFSheet sheet=workbook.getSheetAt(0);
			int rowCount=sheet.getLastRowNum();
			HSSFRow row=sheet.createRow(++rowCount);
			int columnCount=0;
			HSSFCell cell=row.createCell(columnCount);
			if(!Optional.ofNullable(request).isEmpty()) {
				cell=row.createCell(columnCount++);
				if(request.getEmployeeId()!=null) {
					cell.setCellValue(request.getEmployeeId());
				}
				if(request.getEmail()!=null) {
					cell=row.createCell(1);
					cell.setCellValue(request.getEmail());
					
				}
				if(request.getProject()!=null) {
					cell=row.createCell(3);
					cell.setCellValue(request.getProject());
				}
				if(request.getDate()!=null) {
					cell=row.createCell(4);
					cell.setCellValue(request.getDate());
					
				}
				if(request.getLocation()!=null) {
					cell=row.createCell(5);
					cell.setCellValue(request.getLocation());
				}
				if(request.getLocationVerification()!=null) {
					cell=row.createCell(6);
					cell.setCellValue(request.getLocationVerification());
				}
				if(request.getAttendanceStatus()!=null) {
					cell=row.createCell(7);
					cell.setCellValue(request.getAttendanceStatus());
				}
				if(request.getLoginTime()!=null) {
					cell=row.createCell(8);
					cell.setCellValue(request.getLoginTime());
				}
				if(request.getLogoutTime()!=null) {
					cell=row.createCell(9);
					cell.setCellValue(request.getLogoutTime());
				}
				if(request.getComments()!=null) {
					cell=row.createCell(10);
					cell.setCellValue(request.getComments());
				}
			}
			file.close();
			FileOutputStream fos=new FileOutputStream("/attendancetracker/src/main/resources/AttendanceReport.xlsx");
			workbook.write(fos);
			log.info("Excel is updated Sucessfully");
			workbook.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getReports() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
