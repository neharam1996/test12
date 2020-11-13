package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.dao.EmployeeDao;
import com.tcs.EmployeeApplication.dao.EmployeeDaoImpl;
import com.tcs.EmployeeApplication.model.Employee;

public class EmployeeServicesImpl implements EmployeeServices {
	private EmployeeServicesImpl() {
		
	}
	private static EmployeeServices empservices;
	public static EmployeeServices getInstance() {
		if(empservices==null) {
			empservices=new EmployeeServicesImpl();
			return empservices;
			}
	 return empservices;
		
	}
	EmployeeDao empdao=EmployeeDaoImpl.getInstance();

	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empdao.addEmployee(employee);
	}

	public String updateEmployee(long id) {
		// TODO Auto-generated method stub
		return empdao.updateEmployee(id);
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
