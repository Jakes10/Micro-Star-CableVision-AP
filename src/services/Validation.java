package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
 

import controller.Connection;
 

public class Validation {
	
	public boolean Login(String userEmail, String password, String userType) {
		
		
		Connection connect = new Connection();
		
		 
//		 System.out.println(userType);
//		 System.out.println(userEmail);
		 if(userType.isEmpty() || userType.length()==0 || userType.equals("Select Login Type") ){
			 	required("Login Type");
				return false;
			}
		 
		 
		 if(userEmail.isEmpty() || userEmail.length()==0 ){
			 	required("Email");
				return false;
		}else{
//			public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
//				    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			
			Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(userEmail);

			if (!m.find()){
				JOptionPane.showMessageDialog(null,"Incorrect Email format!\n","Error Occured", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		 
		 
		 
		 if(password.isEmpty() || password.length()==0  ){
			 	required("Password");
				return false;
			}
		 
		 
		 if(!userEmail.contains("DR") && userType.equals("Doctor")) {
			 JOptionPane.showMessageDialog(null,userEmail+" is not a "+userType+" ID!\n","Error Occured", JOptionPane.ERROR_MESSAGE);
				return false;
		 }
		 
		 if(!userEmail.contains("NS") && userType.equals("Nurse")) {
			 JOptionPane.showMessageDialog(null,userEmail+" is not a "+userType+" ID!\n","Error Occured", JOptionPane.ERROR_MESSAGE);
				return false;
		 }
		 
		 if(!userEmail.contains("RT") && userType.equals("Receptionist")) {
				JOptionPane.showMessageDialog(null,userEmail+" is not a "+userType+" ID!\n","Error Occured", JOptionPane.ERROR_MESSAGE);
				return false;
		 }
		
		
		
		 
		 
		return connect.LoginAuthentification(userEmail, password);
	}
	
	
	private void required(String input) {
		JOptionPane.showMessageDialog(null, input+" is Required\n","Error Occured", JOptionPane.ERROR_MESSAGE);
		
	}

}
