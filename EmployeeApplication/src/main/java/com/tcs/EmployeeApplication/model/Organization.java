package com.tcs.EmployeeApplication.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
private Long id;
private String name;
private String address;
private List<Department> departments=new ArrayList<>();
private List<Employee> employees=new ArrayList<>();


}
