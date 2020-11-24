package com.tcs.studenthostel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.studenthostel.dao.StudentHostelDao;
import com.tcs.studenthostel.model.StudentHostel;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentHostelDao dao;
	public String addstudent(StudentHostel student) {
		// TODO Auto-generated method stub
		return dao.addstudent(student);
	}

	public String deletestudent(int id) {
		// TODO Auto-generated method stub
		return dao.deletestudent(id);
	}

}
