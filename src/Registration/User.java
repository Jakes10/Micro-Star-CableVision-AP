package Registration;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dashboard.Main;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JPasswordField txt_password;
	private JTextField id;
	private JTextField first_name;
	private JTextField last_name;
	private JTextField email;
	private JTextField contact_number;
	private JTextField email_verified_at;
	private JTextField remember_token;
	private JTextField created_at;
	private JTextField updated_at;
	private JPasswordField passwordField;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		tabbedPane.addTab("Login", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter ID");
		lblNewLabel.setIcon(new ImageIcon(User.class.getResource("/img/icons8-change-user-24.png")));
		lblNewLabel.setBounds(10, 49, 91, 26);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Enter Password");
		lblPassword.setIcon(new ImageIcon(User.class.getResource("/img/icons8-password-book-24.png")));
		lblPassword.setBounds(10, 94, 130, 23);
		panel.add(lblPassword);
		
		txt_id = new JTextField();
		txt_id.setBounds(170, 39, 155, 26);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(170, 91, 155, 26);
		panel.add(txt_password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
					String sql = "Select * from users where id=? and password = ?";
					PreparedStatement pst =con.prepareStatement(sql);
					pst.setString(1, txt_id.getText());
				    pst.setString(2, txt_password.getText());
					
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Successful");
						Main.main(null);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, ":( ID and Password does not match ");
						id.setText("");
						password.setText("");
					
					}
					con.close();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
			
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(User.class.getResource("/img/icons8-login-24.png")));
		btnNewButton.setBounds(170, 144, 155, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(User.class.getResource("/img/icons8-home-24.png")));
		lblNewLabel_2.setBounds(213, 0, 58, 37);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		tabbedPane.addTab("Register", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		panel_1.add(lblId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 36, 66, 14);
		panel_1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 61, 66, 14);
		panel_1.add(lblLastName);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(10, 86, 86, 14);
		panel_1.add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Contact Number");
		lblNewLabel_1.setBounds(10, 111, 123, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("password");
		lblNewLabel_4.setBounds(10, 173, 123, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(10, 212, 86, 14);
		panel_1.add(lblNewLabel_4_1);
		
		id = new JTextField();
		id.setBounds(196, 8, 151, 20);
		panel_1.add(id);
		id.setColumns(10);
		
		first_name = new JTextField();
		first_name.setColumns(10);
		first_name.setBounds(196, 33, 151, 20);
		panel_1.add(first_name);
		
		last_name = new JTextField();
		last_name.setColumns(10);
		last_name.setBounds(196, 58, 151, 20);
		panel_1.add(last_name);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(196, 83, 151, 20);
		panel_1.add(email);
		
		contact_number = new JTextField();
		contact_number.setColumns(10);
		contact_number.setBounds(196, 108, 151, 20);
		panel_1.add(contact_number);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				
				
				try{
					String sql = "INSERT INTO users"
					+"(id, first_name,last_name,email,contact_number,email_verified_at,password,remember_token,created_at,updated_at) "
					+"VALUES (?,?,?,?,?,?,?,?,?,?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
					pst = con.prepareStatement(sql);
					pst.setString(1,id.getText());
					pst.setString(2,first_name.getText());
					pst.setString(3,last_name.getText());
					pst.setString(4,email.getText());
					pst.setString(5,contact_number.getText());
					pst.setString(6,email_verified_at.getText());
					pst.setString(7,password.getText());
					pst.setString(8,remember_token.getText());
					pst.setString(9,created_at.getText());
					pst.setString(10,updated_at.getText());
					
					
			
			
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, " You are registered!");
					 
					}
					catch(SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
					}
			
				
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(User.class.getResource("/img/icons8-login-24.png")));
		btnNewButton_1.setBounds(367, 135, 116, 52);
		panel_1.add(btnNewButton_1);
		
		email_verified_at = new JTextField();
		email_verified_at.setColumns(10);
		email_verified_at.setBounds(196, 139, 151, 20);
		panel_1.add(email_verified_at);
		
		JLabel lblNewLabel_1_1 = new JLabel("email_verified_at");
		lblNewLabel_1_1.setBounds(10, 148, 123, 14);
		panel_1.add(lblNewLabel_1_1);
		
		remember_token = new JTextField();
		remember_token.setColumns(10);
		remember_token.setBounds(196, 198, 151, 20);
		panel_1.add(remember_token);
		
		created_at = new JTextField();
		created_at.setColumns(10);
		created_at.setBounds(196, 247, 151, 20);
		panel_1.add(created_at);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("remember_token");
		lblNewLabel_1_1_1.setBounds(10, 198, 123, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("created_at");
		lblNewLabel_1_1_1_1.setBounds(10, 250, 123, 14);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("updated_at");
		lblNewLabel_1_1_1_1_1.setBounds(10, 275, 123, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		updated_at = new JTextField();
		updated_at.setColumns(10);
		updated_at.setBounds(196, 272, 151, 20);
		panel_1.add(updated_at);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(337, 170, -134, 20);
		panel_1.add(passwordField);
		
		password = new JPasswordField();
		password.setBounds(196, 170, 151, 17);
		panel_1.add(password);
	}
}
