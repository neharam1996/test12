package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.EmployeeApplication.dao.DepartmentDao;
import com.tcs.EmployeeApplication.dao.DepartmentDaoImpl;
import com.tcs.EmployeeApplication.dao.OrganizationDao;
import com.tcs.EmployeeApplication.dao.OrganizationDaoImpl;
import com.tcs.EmployeeApplication.model.Department;
import com.tcs.EmployeeApplication.model.Employee;
import com.tcs.EmployeeApplication.model.Organization;
@Service
public class OrganizationServicesImpl implements OrganizationServices {
	@Autowired
	OrganizationDao orgdao;
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		Long id=organization.getId();
		List<Employee> employees=orgdao.findEmpByOrganization(id);
		List<Department> departments=orgdao.findByOrganizationId(id);
		organization.setDepartments(departments);
		organization.setEmployees(employees);
		return orgdao.addOrganization(organization);
	}

	@Override
	public String updateOrganization(Long id,String name) {
		// TODO Auto-generated method stub
		return orgdao.updateOrganization(id,name);
	}

	@Override
	public String deleteOrganization(Long id) {
		// TODO Auto-generated method stub
		return orgdao.deleteOrganization(id);
	}

	@Override
	public Optional<Organization> findById(Long id) {
		// TODO Auto-generated method stub
		return orgdao.findById(id);
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		return orgdao.getOrganizations();
	}

}
