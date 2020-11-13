package com.tcs.EmployeeApplication.dao;

import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.model.Organization;

public interface OrganizationDao {
	public String addOrganization(Organization organization);
	public String updateOrganization(Long id);
	public String deleteOrganization(Long id);
	public Optional<Organization> findById(Long id);
	public Optional<List<Organization>> getOrganizations();
	
}
