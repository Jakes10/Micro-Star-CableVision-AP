package Registration;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		setBounds(100, 100, 450, 300);
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
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setIcon(new ImageIcon(User.class.getResource("/img/icons8-change-user-24.png")));
		lblNewLabel.setBounds(10, 45, 91, 26);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setIcon(new ImageIcon(User.class.getResource("/img/icons8-password-book-24.png")));
		lblPassword.setBounds(10, 94, 112, 23);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(170, 39, 155, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 91, 155, 26);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
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
		
		JLabel lblNewLabel_3 = new JLabel("password");
		lblNewLabel_3.setBounds(10, 138, 86, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("remember_token");
		lblNewLabel_4.setBounds(10, 173, 123, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(10, 198, 86, 14);
		panel_1.add(lblNewLabel_4_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 8, 151, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(196, 33, 151, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(196, 58, 151, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(196, 83, 151, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(196, 108, 151, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(196, 135, 151, 20);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(196, 170, 151, 20);
		panel_1.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setIcon(new ImageIcon(User.class.getResource("/img/icons8-login-24.png")));
		btnNewButton_1.setBounds(196, 198, 162, 23);
		panel_1.add(btnNewButton_1);
	}
}
