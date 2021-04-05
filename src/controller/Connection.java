package controller;
  
//import java.sql.Connection;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.User;
import services.Crypto;

 

public class Connection {
	
	ResultSet rs;
	Connection conn;
	Statement st;
	String sql;
	
	public java.sql.Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.cj.jdbc.Driver"; 
			String url = "jdbc:mysql://localhost/micro_star";
			String username = "root";
			String password = "";
			Class.forName(driver);
 

			java.sql.Connection conn = DriverManager.getConnection(url, username, password); 
			return conn;
		} catch(Exception e){

			//				  System.out.println(e);
			JOptionPane.showMessageDialog(null,"Server Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();

		}

		return null;
	}
	
	
	public boolean LoginAuthentification(User user) {

		boolean passwordMatch=false;
		boolean IDMatch=false; 
		
		
		try {
			java.sql.Connection con=   getConnection();
			Statement st = con.createStatement(); 
			String sql=("SELECT * FROM users WHERE id = ?;");
			
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, user.getId());
			
			rs=  pst.executeQuery();
			while (rs.next()) {

				if (user.getId().equals(rs.getString("id"))) {
					IDMatch=true;
					
					 if(user.getPassword().equals(new String(Crypto.Decrypt(rs.getString("password").getBytes())))) {
						passwordMatch=true;
						
						
						if(!user.getType().equals(rs.getString("user_type"))) {
							 JOptionPane.showMessageDialog(null,"User type does not match!!\nCannot login as a "+user.getType(),"Error Occured", JOptionPane.ERROR_MESSAGE);
							
							 return false;
						 }else {
							 JOptionPane.showMessageDialog(null, "Login Successful");
								break;	
						 }
						  
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
	
	public boolean AddUser(User user )  {


		try{

			java.sql.Connection con=   getConnection();
//			Statement st = con.createStatement(); 
			PreparedStatement pst = null;
//			ResultSet rs = null;
			
			String sql = "INSERT INTO users"
					+"(first_name,last_name,email,contact_number,user_type,password)"
					+"VALUES (?,?,?,?,?,?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
					pst = con.prepareStatement(sql);
					pst.setString(1,user.getFirstName());
					pst.setString(2,user.getLastName());
					pst.setString(3,user.getEmail());
					pst.setString(4,user.getMobile());
					pst.setString(5,user.getType());
					pst.setString(6,new String(Crypto.Encrypt(user.getPassword().getBytes())));
//					pst.setString(6,user.getFirstName());
//					pst.setString(7,user.getFirstName());
//					pst.setString(8,remember_token.getText());
//					pst.setString(9,created_at.getText());
//					pst.setString(10,updated_at.getText());
					pst.executeUpdate();

			con.close();

			JOptionPane.showMessageDialog(null, "Registration Successful");

			return true;
		} catch(Exception e){

			JOptionPane.showMessageDialog(null," Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);

		}
		
		return false;
	}
	 

}
