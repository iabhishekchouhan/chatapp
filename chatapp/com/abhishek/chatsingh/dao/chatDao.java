package com.abhishek.chatsingh.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.abhishek.chatsingh.utils.ConfigReader.getValue;

public interface chatDao {
		public static Connection createConnection() throws ClassNotFoundException,SQLException{
			Class.forName(getValue("Driver"));
			String CONNECTION_STRING =getValue("Connection_Url");
			final String USER_ID=getValue("USER_ID");
			final String PASSWORD=getValue("PASSWORD");
			Connection con = DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
			if(con!=null) {
				System.out.println("Success");
//				con.close();
			}
			return con;
			
		}
		
}
