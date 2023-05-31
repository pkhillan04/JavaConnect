package Kites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3308/soham","root","");
		
		System.out.println("Database Connected");

	}

}
 