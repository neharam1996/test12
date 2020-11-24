package com.tcs.studenthostel.service;

import org.springframework.stereotype.Service;

import com.tcs.studenthostel.model.StudentHostel;

public interface StudentService {
	public String addstudent(StudentHostel student);
	 public String deletestudent(int id);

	 
}
