package controller;
  
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import services.Crypto;

 

public class Connection {
	
	ResultSet rs;
	Connection conn;
	Statement st;
	String sql;
	
	public java.sql.Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.cj.jdbc.Driver";
//			String driver = "com.mysql.jdbc.Driver";
			
//			String url = "jdbc:mysql://localhost:3306/micro_star";
			String url = "jdbc:mysql://localhost/micro_star";
			String username = "root";
			String password = "";
			Class.forName(driver);

			//////////////////////////////////

//			String driver = "com.mysql.cj.jdbc.Driver";
//			String url = "jdbc:mysql://107.180.40.19:3306/portmoreHC";
//			String username = "jakes";
//			String password = ".[cuKo#?SXJ1";
//			Class.forName(driver);

			java.sql.Connection conn = DriverManager.getConnection(url, username, password);
//			con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
			return conn;
		} catch(Exception e){

			//				  System.out.println(e);
			JOptionPane.showMessageDialog(null,"Server Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();

		}

		return null;
	}
	
	
	public boolean LoginAuthentification(String email, String password) {

		boolean passwordMatch=false;
		boolean IDMatch=false; 
		
		
		try {
			java.sql.Connection con=   getConnection();
			Statement st = con.createStatement(); 

			String sql=("SELECT * FROM users WHERE email = '"+email+"';");
			rs= st.executeQuery(sql);

			while (rs.next()) {

				if (email.equals(rs.getString("User_ID"))) {
					IDMatch=true;
					
					 if(password.equals(new String(Crypto.Decrypt(rs.getString("Password").getBytes())))) {
						passwordMatch=true;
					}


				} 

			}

			if(!IDMatch && !passwordMatch) {
				JOptionPane.showMessageDialog(null, "Incorrect User ID and Password!", "Error", JOptionPane.ERROR_MESSAGE);
			}else {

				if(!IDMatch)
				{
					JOptionPane.showMessageDialog(null, "Incorrect User ID!", "Error", JOptionPane.ERROR_MESSAGE);
				}

				if(!passwordMatch)
				{
					JOptionPane.showMessageDialog(null, "Incorrect Password!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch(Exception e){
			System.out.println(e);

		}

		return passwordMatch;

	}
	
	 

}
