package com.abhishek.chatsingh.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.abhishek.chatsingh.dto.UserDTO;
import com.abhishek.chatsingh.utils.PasswordEncryption;

public class UserDAO {
	public int register(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception{
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=chatDao.createConnection();
		stmt=conn.createStatement();
		
		try {
			String userId=userDTO.getUserid();
			char[] password=userDTO.getPassword();
			String pass=PasswordEncryption.passwordEncrypt(new String(password));
			String query="insert into users values('"+userId+"'"+",'"+pass+"'"+",'of')";
			int record=stmt.executeUpdate(query);
//			System.out.println(query);
//			System.out.println(userId);
//			System.out.println(pass);
			return record;
		}
		finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		
		
		
		 
	}
	
	public boolean islogin(UserDTO userDTO) throws ClassNotFoundException,SQLException ,Exception{
		Connection conn=null;
		PreparedStatement stmt=null;
		
		ResultSet rs=null;
		String query="select name from users where name=? and password=?";
		
		try {
			conn=chatDao.createConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1,userDTO.getUserid());
			String encPassword=PasswordEncryption.passwordEncrypt(new String(userDTO.getPassword()));
			stmt.setString(2, encPassword);
			rs = stmt.executeQuery();
			return rs.next();
//			if(rs.next()) {
//				return true;
//			}
//			else {
//				return false;
//			}
		}
		finally {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		
//		conn=chatDao.createConnection();
		
	}
	public static void main(String[] args) {
		
	}
}
