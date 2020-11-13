package com.tcs.EmployeeApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.model.Department;
import com.tcs.EmployeeApplication.util.DBUtils;

public class DepartmentDaoImpl implements DepartmentDao {
	private DepartmentDaoImpl() {
		
	}
	private static DepartmentDao depdao;
	public static DepartmentDao getInstance() {
		if(depdao==null) {
			depdao=new DepartmentDaoImpl();
			return depdao;
			}
	 return depdao;
		
	}
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String addquery="insert into DEPARTMENT (id,orgnizationid,name) values(?,?,?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(addquery);
			preparedStatement.setLong(1,department.getId());
			preparedStatement.setLong(2, department.getOrganizationid());
			preparedStatement.setString(3, department.getName());
			result=preparedStatement.executeUpdate();
			if(result>0) {
				connection.commit();
				return "success";
			}
			else {
				return "fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		
		}
		finally {
			DBUtils.closeConnection(connection);
		}
	
		
	}

	@Override
	public String updateDepartment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String deletequery="delete from DEPARTMENT where id=?";
		try {
			connection.setAutoCommit(false);

			preparedStatement=connection.prepareStatement(deletequery);
			preparedStatement.setLong(1,id);
			
			result=preparedStatement.executeUpdate();
			if(result>0) {
				connection.commit();
				return "success";
			}
			else {
				return "fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		
		}
		finally {
			DBUtils.closeConnection(connection);
		}
	}

	@Override
	public Optional<Department> findById(Long id) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			Department department=null;
			String findquery="select * from DEPARTMENT where id=?";
			try {
				connection.setAutoCommit(false);
				preparedStatement=connection.prepareStatement(findquery);
				preparedStatement.setLong(1, id);
				
				resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					department=new Department();
					department.setId(resultSet.getLong("id"));
					department.setOrganizationid(resultSet.getLong("orgnizationid"));
					department.setName(resultSet.getString("name"));
					
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					connection.rollback();
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
				return Optional.empty();
			
			}
			finally {
				DBUtils.closeConnection(connection);
			}
			return Optional.of(department);
				
		}
		

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Department department=null;
		List<Department> departmentlist=new ArrayList<Department>();
		String findAllquery="select * from DEPARTMENT";
		try {
			connection.setAutoCommit(false);

			preparedStatement=connection.prepareStatement(findAllquery);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				department=new Department();
				department.setId(resultSet.getLong("id"));
				department.setOrganizationid(resultSet.getLong("orgnizationid"));
				department.setName(resultSet.getString("name"));
				departmentlist.add(department);
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return Optional.of(departmentlist);
		
	}

	@Override
	public Optional<List<Department>> findByOrganizationId(Long id) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Department department=null;
		List<Department> departmentlist=new ArrayList<Department>();
		String findAllquery="select * from DEPARTMENT where orgnizationid=?";
		try {
			connection.setAutoCommit(false);

			preparedStatement=connection.prepareStatement(findAllquery);
			preparedStatement.setLong(1, id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				department=new Department();
				department.setId(resultSet.getLong("id"));
				department.setOrganizationid(resultSet.getLong("orgnizationid"));
				department.setName(resultSet.getString("name"));
				departmentlist.add(department);
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return Optional.of(departmentlist);
	}

}
