package com.tcs.studenthostel.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.studenthostel.Utils.DBUtils;
import com.tcs.studenthostel.model.StudentHostel;
@Repository
public class StudentHostelDaoImpl implements StudentHostelDao {
	@Autowired
	DBUtils dbutils;
	public String addstudent(StudentHostel student) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement pstmt=null;
		connection=dbutils.getConnection();
		String sql="insert into student_hostel values(?,?,?)";
		int status=0;
		try {
			
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getRoom_number());
			status=pstmt.executeUpdate();
			if(status>0) {
				return "success";
			}
			else {
				return "fail";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
		finally {
			dbutils.closeConnection(connection);
		}
	}

	public String deletestudent(int id) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement pstmt=null;
		connection=dbutils.getConnection();
		String sql="delete from student_hostel where id=?";
		int status=0;
		try {
			
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			status=pstmt.executeUpdate();
			if(status>0) {
				return "success";
			}
			else {
				return "fail";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
		finally {
			dbutils.closeConnection(connection);
		}
	}

}
