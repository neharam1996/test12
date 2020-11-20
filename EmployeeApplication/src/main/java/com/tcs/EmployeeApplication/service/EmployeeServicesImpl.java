package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.EmployeeApplication.dao.EmployeeDao;
import com.tcs.EmployeeApplication.dao.EmployeeDaoImpl;
import com.tcs.EmployeeApplication.model.Employee;
import com.tcs.EmployeeApplication.repository.EmployeeRepository;
@Service
public class EmployeeServicesImpl implements EmployeeServices {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee2=null;
		try {
			employee2=employeeRepository.save(employee);
			return "success";
		}
		catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		
	}

	

	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
				return "success";
	}

	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(employeeRepository.findAll());
	}

	public Optional<List<Employee>> findByOrganization(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByOrganizationid(id);
	}

}
