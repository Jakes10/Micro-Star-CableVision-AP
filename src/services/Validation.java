package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


import controller.Connection;
import model.User;


public class Validation {
	Connection connect = new Connection();

	public boolean Login(User user) {
		//		String userEmail, String password, String userType




		//		 System.out.println(userType);
		//		 System.out.println(userEmail);
		if(user.getType().isEmpty() || user.getType().length()==0 || user.getType().equals("Select User Type") ){
			required("Login Type");
			return false;
		}


		if(user.getId().isEmpty() || user.getId().length()==0){
			required("User ID");
			return false;
		}else{ 
			try{				

				Integer.parseInt(user.getId());
			}catch(NumberFormatException e2){
				JOptionPane.showMessageDialog(null,"Invalid User ID!\n","Error Occured", JOptionPane.ERROR_MESSAGE);
				return false;
			} 
		}



		if(user.getPassword().isEmpty() || user.getPassword().length()==0  ){
			required("Password");
			return false;
		}








		return connect.LoginAuthentification(user);
	}


	public boolean UserRegistration(User user) {


		if(user.getType().equals("Select User Type")){
			required("User Type");
			return false;
		}

		if(user.getFirstName().isEmpty() || user.getFirstName().length()==0){
			required("First Name");
			return false;
		}

		if(user.getLastName().isEmpty() || user.getLastName().length()==0){
			required("Last Name");
			return false;
		}


		if(user.getMobile().isEmpty() || user.getMobile().length()==0){
			required("Mobile");
			return false;
		}else {

			//				 try{
			//					 Integer.parseInt(user.getMobile());
			//				}catch(NumberFormatException e2){
			//						JOptionPane.showMessageDialog(null,"Please use only digits for mobile!\n","Error Occured", JOptionPane.ERROR_MESSAGE);
			//						return false;
			//				}

			if(user.getMobile().length()<7 || user.getMobile().length()>10) {
				JOptionPane.showMessageDialog(null,"Invalid Mobile Number!\n","Error Occured", JOptionPane.ERROR_MESSAGE);
				return false;
			}	
		}



		if(user.getEmail().isEmpty() || user.getEmail().length()==0){
			required("Email");
			return false;
		}else {


			Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(user.getEmail());
			if(!matcher.find()) {

				JOptionPane.showMessageDialog(null, "Incorrect Email Format\n","Error Occured", JOptionPane.ERROR_MESSAGE);

				return false;
			}


		}


		return connect.AddUser(user);

		//		return true;
	}



	private void required(String input) {
		JOptionPane.showMessageDialog(null, input+" is Required\n","Error Occured", JOptionPane.ERROR_MESSAGE);

	}

}
