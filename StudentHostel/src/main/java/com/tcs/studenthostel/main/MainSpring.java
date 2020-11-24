package com.tcs.studenthostel.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.studenthostel.config.DBConfig;
import com.tcs.studenthostel.model.StudentHostel;
import com.tcs.studenthostel.service.StudentService;

public class MainSpring {
	public static void main(String[] args) {
		
	
AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext(DBConfig.class);
StudentHostel stu=new StudentHostel(1,"abcd",32);
StudentService ss=context.getBean(StudentService.class);
System.out.println(ss.addstudent(stu));
	}
}
