package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.EmployeeApplication.dao.DepartmentDao;
import com.tcs.EmployeeApplication.model.Department;
import com.tcs.EmployeeApplication.model.Employee;
@Service
public class DepartmentServicesImpl implements DepartmentServices {
	@Autowired
	DepartmentDao deptdao;

	
	
		
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		Long id=department.getId();
		List<Employee> employees=deptdao.findEmpByDepartment(id);
		department.setEmployees(employees);
		return deptdao.addDepartment(department);
	}

	@Override
	public String updateDepartment(Long id,String name) {
		// TODO Auto-generated method stub
		return deptdao.updateDepartment(id,name);
	}

	@Override
	public String deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		return deptdao.deleteDepartment(id);
	}

	@Override
	public Optional<Department> findById(Long id) {
		// TODO Auto-generated method stub
		return deptdao.findById(id);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return deptdao.getDepartments();
	}

	@Override
	public Optional<List<Department>> findByOrganizationId(Long id) {
		// TODO Auto-generated method stub
		return deptdao.findByOrganizationId(id);
	}

}
