package com.tcs.EmployeeApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Long id;
	private Long organizationid;
	private Long departmentid;
	private String name;
	private int age;
	private String position;
	

}
