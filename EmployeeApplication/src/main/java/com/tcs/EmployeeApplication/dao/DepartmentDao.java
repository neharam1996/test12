package com.tcs.EmployeeApplication.dao;

import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.model.Department;

public interface DepartmentDao {
	public String addDepartment(Department department);
	public String updateDepartment(Long id);
	public String deleteDepartment(Long id);
	public Optional<Department> findById(Long id);
	public Optional<List<Department>> getDepartments();
	public Optional<List<Department>> findByOrganizationId(Long id);
	
}
