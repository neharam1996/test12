package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.dao.DepartmentDao;
import com.tcs.EmployeeApplication.dao.DepartmentDaoImpl;
import com.tcs.EmployeeApplication.model.Department;

public class DepartmentServicesImpl implements DepartmentServices {
	private DepartmentServicesImpl() {
		
	}
	private static DepartmentServices depservices;
	public static DepartmentServices getInstance() {
		if(depservices==null) {
			depservices=new DepartmentServicesImpl();
			return depservices;
			}
	 return depservices;
		
	}
	DepartmentDao deptdao=DepartmentDaoImpl.getInstance();
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		return deptdao.addDepartment(department);
	}

	@Override
	public String updateDepartment(Long id) {
		// TODO Auto-generated method stub
		return deptdao.updateDepartment(id);
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
