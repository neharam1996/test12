package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.dao.DepartmentDao;
import com.tcs.EmployeeApplication.dao.DepartmentDaoImpl;
import com.tcs.EmployeeApplication.dao.OrganizationDao;
import com.tcs.EmployeeApplication.dao.OrganizationDaoImpl;
import com.tcs.EmployeeApplication.model.Organization;

public class OrganizationServicesImpl implements OrganizationServices {
private OrganizationServicesImpl() {
		
	}
	private static OrganizationServices orgservices;
	public static OrganizationServices getInstance() {
		if(orgservices==null) {
			orgservices=new OrganizationServicesImpl();
			return orgservices;
			}
	 return orgservices;
		
	}
	OrganizationDao orgdao=OrganizationDaoImpl.getInstance();
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return orgdao.addOrganization(organization);
	}

	@Override
	public String updateOrganization(Long id) {
		// TODO Auto-generated method stub
		return orgdao.updateOrganization(id);
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
