package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.model.Employee;

public interface EmployeeServices {
	public String addEmployee(Employee employee);
	public String updateEmployee(long id);
	public String deleteEmployee(long id);
	public Optional<Employee> findById(long id);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> findByOrganization(long id);
}
