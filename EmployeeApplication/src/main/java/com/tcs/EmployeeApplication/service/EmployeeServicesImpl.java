package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.EmployeeApplication.dao.EmployeeDao;
import com.tcs.EmployeeApplication.dao.EmployeeDaoImpl;
import com.tcs.EmployeeApplication.model.Employee;
@Service
public class EmployeeServicesImpl implements EmployeeServices {
	@Autowired
	EmployeeDao empdao;

	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empdao.addEmployee(employee);
	}

	public String updateEmployee(long id,String name) {
		// TODO Auto-generated method stub
		return empdao.updateEmployee(id,name);
	}

	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return empdao.deleteEmployee(id);
	}

	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return empdao.findById(id);
	}

	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return empdao.getEmployees();
	}

	public Optional<List<Employee>> findByOrganization(long id) {
		// TODO Auto-generated method stub
		return empdao.findByOrganization(id);
	}

}
