package com.tcs.EmployeeApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.model.Department;
import com.tcs.EmployeeApplication.model.Organization;
import com.tcs.EmployeeApplication.util.DBUtils;

public class OrganizationDaoImpl implements OrganizationDao {
	private OrganizationDaoImpl() {
		
	}
	private static OrganizationDao orgdao;
	public static OrganizationDao getInstance() {
		if(orgdao==null) {
			orgdao=new OrganizationDaoImpl();
			return orgdao;
			}
	 return orgdao;	}
	
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String addquery="insert into ORGANIZATION (id,name,address) values(?,?,?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(addquery);
			preparedStatement.setLong(1,organization.getId());
			
			preparedStatement.setString(2, organization.getName());
			preparedStatement.setString(3, organization.getAddress());
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
	public String updateOrganization(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrganization(Long id) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String deletequery="delete from ORGANIZATION where id=?";
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
	public Optional<Organization> findById(Long id) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			Organization organization=null;
			String findquery="select * from ORGANIZATION where id=?";
			try {
				connection.setAutoCommit(false);
				preparedStatement=connection.prepareStatement(findquery);
				preparedStatement.setLong(1, id);
				
				resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					organization=new Organization();
					organization.setId(resultSet.getLong("id"));
					organization.setName(resultSet.getString("name"));
					organization.setAddress(resultSet.getString("address"));
					
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
			return Optional.of(organization);
				
		}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Organization organization=null;
		List<Organization> organizationlist=new ArrayList<Organization>();
		String findAllquery="select * from ORGANIZATION";
		try {
			connection.setAutoCommit(false);

			preparedStatement=connection.prepareStatement(findAllquery);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				organization=new Organization();
				organization.setId(resultSet.getLong("id"));
				organization.setName(resultSet.getString("name"));
				organization.setAddress(resultSet.getString("address"));
				organizationlist.add(organization);
				
				
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
		return Optional.of(organizationlist);
		
	}

}
