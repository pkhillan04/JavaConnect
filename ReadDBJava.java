package Kites;

import java.sql.*;

public class ReadDBJava {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3308/soham";
		String user = "root";
		String password = "";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			conn = DriverManager.getConnection(url,user,password);
			
			stmt = conn.createStatement();
			
			String query = "Select * from users";
			ResultSet res = stmt.executeQuery(query);
			
			while(res.next())
			{
				int id = res.getInt("id");
				String name = res.getString("name");
				String username = res.getString("username");
				String email = res.getString("email");
				String phone = res.getString("phone");
				String website = res.getString("website");
                String company_name = res.getString("company_name");
                String company_catchPhrase = res.getString("company_catchPhrase");
                String company_bs = res.getString("company_bs");
				
                System.out.printf("%-5d %-25s %-27s %-30s %-25s %-25s %-20s %-30s %s %n %n",
                        id, name, username, email, phone, website, company_name, company_catchPhrase, company_bs);
            
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
	