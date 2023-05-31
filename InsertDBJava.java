package Kites;

import java.sql.*;
import java.util.Scanner;
public class InsertDBJava {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3308/soham";
		String user = "root";
		String password = "";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			conn = DriverManager.getConnection(url,user,password);
			
			stmt = conn.createStatement();
			
			int id = 0;
			String name, username, email, phone, website, company_name, company_catchPhrase, company_bs;
			
			while(id != -1)
			{
					id = getIDInput("Enter id: ");					
					if(id == -1)
						break;
					name = getUserInput("Enter name: ");
					username = getUserInput("Enter username: ");
					email = getUserInput("Enter email: ");
					phone = getUserInput("Enter phone: ");
					website = getUserInput("Enter website: ");
					company_name = getUserInput("Enter company's name: ");
					company_catchPhrase = getUserInput("Enter company's catch phrase: ");
					company_bs = getUserInput("Enter company's bs: ");
					
					String query = "INSERT INTO users (id, name, username, email, phone, website, company_name, company_catchPhrase, company_bs) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

					PreparedStatement st = conn.prepareStatement(query);
					st.setInt(1, id);
					st.setString(2, name);
					st.setString(3, username);
					st.setString(4, email);
					st.setString(5, phone);
					st.setString(6, website);
					st.setString(7, company_name);
					st.setString(8, company_catchPhrase);
					st.setString(9, company_bs);
					st.executeUpdate();
					st.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getUserInput(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    } 
	
	private static int getIDInput(String message) {
		System.out.print(message);
		int p = 0;
		Scanner scanner = new Scanner(System.in);
		p = scanner.nextInt();
		return p;
	}
}
