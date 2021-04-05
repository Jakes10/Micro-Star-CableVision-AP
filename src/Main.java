
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import services.Validation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.util.Calendar;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Choice;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.border.LineBorder;

import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;


public class Main {

	private JFrame frmMscv;
	private DefaultTableModel dtm ;
	private JButton mainBtnDashboard;
	private JButton ServiceBtn;
	private JButton complainBtn;
	private JButton respondBtn;
	private JButton assignBtn;
	private JPanel assignPanel;
	private JPanel respondPanel;
	private JPanel complaintsPanel;
	private JPanel servicePanel;
	private JPanel dashboardPanel;
	private JLabel mainLabel;
	private JTextField email;
	private JTextField password;
	private JPanel loginPanel;
	private JPanel representativePanel;
	private JPanel customerPanel;
	private JPanel technicianPanel;
	private JPanel registerPanel;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_1_2;
	private JLabel lblNewLabel_3_1_1_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_3_3;
	private JLabel lblNewLabel_3_4;
	private JTextField textField_6;
	private JButton btnLogin;
	private JLabel timeAndDate;
	String pass;
	
	String[] users = { "Select Login Type","Customer", "Representative", "Technician" };
	private JComboBox loginType;
	Validation validate = new Validation();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMscv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		
		initialize();
		displayDate();

	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void setPanel(int panelNum) {
	
		JButton[] mainButton= {mainBtnDashboard, ServiceBtn, complainBtn, respondBtn, assignBtn};
		JPanel[] mainPanel= {dashboardPanel, servicePanel, complaintsPanel, respondPanel, assignPanel};
	
		for (int i=0; i<5; i++) {
			
			if(i==panelNum) {
				mainButton[panelNum].setForeground(new Color(0, 191, 255));
				mainPanel[panelNum].setVisible(true);
			}else {
				mainButton[i].setForeground(Color.darkGray);
				mainPanel[i].setVisible(false);
			}
			
		}
		
	}
	
	
	
	public void setMainPanel(int panelNum) {
		 
		JPanel[] mainPanel= {loginPanel, representativePanel, customerPanel, technicianPanel, registerPanel};
	
		for (int i=0; i<5; i++) {
			
			if(i==panelNum) {
//				mainButton[panelNum].setForeground(new Color(0, 191, 255));
				mainPanel[panelNum].setVisible(true);
			}else {
//				mainButton[i].setForeground(Color.darkGray);
				mainPanel[i].setVisible(false);
			}
			
		}
		
	}
	
 void initialize() {
		frmMscv = new JFrame();
		frmMscv.setBounds(100, 100, 1004, 656);
		frmMscv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMscv.getContentPane().setLayout(new CardLayout(0, 0));
		frmMscv.setLocationRelativeTo(null);
		frmMscv.setTitle("MSCV");
		frmMscv.setResizable(false); 

		JPanel mainPanel = new JPanel();
		frmMscv.getContentPane().add(mainPanel, "name_40632074234174");
		mainPanel.setVisible(true);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		Object[] title = {"Complaints"};
	    dtm = new DefaultTableModel(); 
	    dtm.setColumnIdentifiers(title);
		
		JPanel panel = new JPanel();
		mainPanel.add(panel, "name_694152248491594");
		panel.setLayout(null);
		
		JPanel UserPanel = new JPanel();
		UserPanel.setBounds(0, 37, 1000, 550);
		panel.add(UserPanel);
		UserPanel.setLayout(new CardLayout(0, 0));
		
		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		UserPanel.add(loginPanel, "name_100830795326703");
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(378, 321, 273, 28);
		loginPanel.add(email);
		
		password = new JPasswordField(); 
		password.setColumns(10);
		password.setBounds(378, 382, 273, 28);
		loginPanel.add(password);
		
		JLabel lblNewLabel_2 = new JLabel("Micro Star Cable Vission");
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.ITALIC, 37));
		lblNewLabel_2.setBounds(165, 32, 668, 80);
		loginPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Login");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Segoe Print", Font.ITALIC, 37));
		lblNewLabel_2_1.setBounds(400, 124, 197, 80);
		loginPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(378, 291, 80, 22);
		loginPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(378, 359, 93, 22);
		loginPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Don't have an account?"); 
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(460, 420, 183, 22);
		loginPanel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Click here");
		lblNewLabel_3_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMainPanel(4);
			}
		}); 
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1.setForeground(SystemColor.desktop);
		lblNewLabel_3_1_1_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblNewLabel_3_1_1_1.setBounds(592, 420, 68, 22);
		loginPanel.add(lblNewLabel_3_1_1_1);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				validate.Login(email.getText().toString(), password.getText().toString(), loginType.getSelectedItem().toString());
				
			}
		});
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnLogin.setFocusable(false);
		btnLogin.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnLogin.setBackground(new Color(211, 211, 211));
		btnLogin.setBounds(530, 486, 117, 36);
		loginPanel.add(btnLogin);
		
		loginType = new JComboBox(users);
		loginType.setFocusable(false);
		loginType.setBackground(new Color(255, 255, 255));
		loginType.setBounds(379, 246, 273, 28); 
		
		loginPanel.add(loginType); 
		JLabel lblNewLabel_3_5 = new JLabel("Log In as");
		lblNewLabel_3_5.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_5.setBounds(379, 214, 92, 22);
		loginPanel.add(lblNewLabel_3_5);
		
		representativePanel = new JPanel();
		representativePanel.setLayout(null);
		representativePanel.setBackground(new Color(211, 211, 211));
		UserPanel.add(representativePanel, "name_695581416808347");	
		
		mainLabel = new JLabel("Dashboard");
		mainLabel.setForeground(Color.DARK_GRAY);
		mainLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		mainLabel.setBounds(169, 10, 370, 34);
		representativePanel.add(mainLabel);
		
		mainBtnDashboard = new JButton("Dashboard");
		mainBtnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(0);
			}
		});
		mainBtnDashboard.setHorizontalTextPosition(SwingConstants.RIGHT);
		mainBtnDashboard.setHorizontalAlignment(SwingConstants.LEFT);
		mainBtnDashboard.setForeground(new Color(0, 191, 255));
		mainBtnDashboard.setFont(new Font("Dialog", Font.PLAIN, 16));
		mainBtnDashboard.setFocusable(false);
		mainBtnDashboard.setBorder(null);
		mainBtnDashboard.setBackground(new Color(211, 211, 211));
		mainBtnDashboard.setBounds(10, 53, 138, 33);
		representativePanel.add(mainBtnDashboard);
		
		ServiceBtn = new JButton("Services");
		ServiceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(1);
//				mainLabel.
			}
		});
		ServiceBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		ServiceBtn.setHorizontalAlignment(SwingConstants.LEFT);
		ServiceBtn.setForeground(Color.DARK_GRAY);
		ServiceBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		ServiceBtn.setFocusable(false);
		ServiceBtn.setBorder(null);
		ServiceBtn.setBackground(new Color(211, 211, 211));
		ServiceBtn.setBounds(10, 88, 138, 33);
		representativePanel.add(ServiceBtn);
		
		complainBtn = new JButton("Complaints");
		complainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(2);
			}
		});
		complainBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		complainBtn.setHorizontalAlignment(SwingConstants.LEFT);
		complainBtn.setForeground(Color.DARK_GRAY);
		complainBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		complainBtn.setFocusable(false);
		complainBtn.setBorder(null);
		complainBtn.setBackground(new Color(211, 211, 211));
		complainBtn.setBounds(10, 124, 138, 33);
		representativePanel.add(complainBtn);
		
		respondBtn = new JButton("Respond to Enquiry");
		respondBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(3);
			}
		});
		respondBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		respondBtn.setHorizontalAlignment(SwingConstants.LEFT);
		respondBtn.setForeground(Color.DARK_GRAY);
		respondBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		respondBtn.setFocusable(false);
		respondBtn.setBorder(null);
		respondBtn.setBackground(new Color(211, 211, 211));
		respondBtn.setBounds(10, 161, 138, 33);
		representativePanel.add(respondBtn);
		
		assignBtn = new JButton("Assign Complaint");
		assignBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(4);
			}
		});
		assignBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		assignBtn.setHorizontalAlignment(SwingConstants.LEFT);
		assignBtn.setForeground(Color.DARK_GRAY);
		assignBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		assignBtn.setFocusable(false);
		assignBtn.setBorder(null);
		assignBtn.setBackground(new Color(211, 211, 211));
		assignBtn.setBounds(10, 198, 138, 33);
		representativePanel.add(assignBtn);
		
		JPanel selectPanel = new JPanel();
		selectPanel.setBounds(167, 53, 750, 443);
		representativePanel.add(selectPanel);
		selectPanel.setLayout(new CardLayout(0, 0));
		
		dashboardPanel = new JPanel();
		selectPanel.add(dashboardPanel, "name_7386572354584");
		dashboardPanel.setLayout(null);
		
		JButton btnAdd1 = new JButton("Services");
		btnAdd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(1);
			}
		});
		btnAdd1.setBounds(56, 397, 117, 36);
		btnAdd1.setForeground(Color.DARK_GRAY);
		btnAdd1.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnAdd1.setFocusable(false);
		btnAdd1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnAdd1.setBackground(new Color(211, 211, 211));
		dashboardPanel.add(btnAdd1);
		
		JButton btnView1 = new JButton("Complaints");
		btnView1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(2);
			}
		});
		btnView1.setBounds(229, 397, 117, 36);
		btnView1.setForeground(Color.DARK_GRAY);
		btnView1.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnView1.setFocusable(false);
		btnView1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnView1.setBackground(new Color(211, 211, 211));
		dashboardPanel.add(btnView1);
		
		JButton btnUpdateRecords = new JButton("Assign");
		btnUpdateRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(4);
			}
		});
		btnUpdateRecords.setBounds(575, 397, 117, 36);
		btnUpdateRecords.setForeground(Color.DARK_GRAY);
		btnUpdateRecords.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnUpdateRecords.setFocusable(false);
		btnUpdateRecords.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnUpdateRecords.setBackground(new Color(211, 211, 211));
		dashboardPanel.add(btnUpdateRecords);
		
		JButton btnDeleteRecords = new JButton("Respond");
		btnDeleteRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(3);
			}
		});
		btnDeleteRecords.setBounds(402, 397, 117, 36);
		btnDeleteRecords.setForeground(Color.DARK_GRAY);
		btnDeleteRecords.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnDeleteRecords.setFocusable(false);
		btnDeleteRecords.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnDeleteRecords.setBackground(new Color(211, 211, 211));
		dashboardPanel.add(btnDeleteRecords);
		
		servicePanel = new JPanel();
		selectPanel.add(servicePanel, "name_7390094721899");
		
		complaintsPanel = new JPanel();
		selectPanel.add(complaintsPanel, "name_7392668747440");
		
		respondPanel = new JPanel();
		selectPanel.add(respondPanel, "name_7395395437632");
		
		assignPanel = new JPanel();
		selectPanel.add(assignPanel, "name_7401454985022");
		
		customerPanel = new JPanel();
		customerPanel.setLayout(null);
		customerPanel.setBackground(new Color(211, 211, 211));
		UserPanel.add(customerPanel, "name_695582208484637");
		
		JLabel lblNewLabel_1 = new JLabel("Technician Panel");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(327, 36, 184, 34);
		customerPanel.add(lblNewLabel_1);
		
		technicianPanel = new JPanel();
		technicianPanel.setLayout(null);
		technicianPanel.setBackground(new Color(211, 211, 211));
		UserPanel.add(technicianPanel, "name_695582346701449");
		
		JLabel lblNewLabel = new JLabel("Technician Panel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(327, 36, 184, 34);
		technicianPanel.add(lblNewLabel);
		
		registerPanel = new JPanel();
		UserPanel.add(registerPanel, "name_6944047469471");
		registerPanel.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(393, 355, 273, 28);
		registerPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(393, 402, 273, 28);
		registerPanel.add(textField_3);
		
		lblNewLabel_4 = new JLabel("Micro Star Cable Vission");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(SystemColor.desktop);
		lblNewLabel_4.setFont(new Font("Segoe Print", Font.ITALIC, 35));
		lblNewLabel_4.setBounds(165, 10, 668, 80);
		registerPanel.add(lblNewLabel_4);
		
		lblNewLabel_2_2 = new JLabel("Register");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Segoe Print", Font.ITALIC, 35));
		lblNewLabel_2_2.setBounds(384, 88, 226, 80);
		registerPanel.add(lblNewLabel_2_2);
		
		lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_5.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(304, 354, 80, 22);
		registerPanel.add(lblNewLabel_5);
		
		lblNewLabel_3_2 = new JLabel("Password");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_2.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(291, 408, 93, 22);
		registerPanel.add(lblNewLabel_3_2);
		
		lblNewLabel_3_1_2 = new JLabel("Already Registererd?");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_2.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblNewLabel_3_1_2.setBounds(486, 440, 174, 22);
		registerPanel.add(lblNewLabel_3_1_2);
		
		lblNewLabel_3_1_1_2 = new JLabel("Click here");
		lblNewLabel_3_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMainPanel(0);
			}
		});
		lblNewLabel_3_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_2.setForeground(SystemColor.desktop);
		lblNewLabel_3_1_1_2.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblNewLabel_3_1_1_2.setBounds(609, 440, 68, 22);
		registerPanel.add(lblNewLabel_3_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(393, 201, 273, 28);
		registerPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(393, 250, 273, 28);
		registerPanel.add(textField_5);
		
		lblNewLabel_6 = new JLabel("First Name");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(281, 200, 103, 22);
		registerPanel.add(lblNewLabel_6);
		
		lblNewLabel_3_3 = new JLabel("Last Name");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_3.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(291, 256, 93, 22);
		registerPanel.add(lblNewLabel_3_3);
		
		lblNewLabel_3_4 = new JLabel("Mobile");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_4.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_4.setBounds(291, 307, 93, 22);
		registerPanel.add(lblNewLabel_3_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(393, 301, 273, 28);
		registerPanel.add(textField_6);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.DARK_GRAY);
		btnRegister.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnRegister.setFocusable(false);
		btnRegister.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnRegister.setBackground(new Color(211, 211, 211));
		btnRegister.setBounds(549, 482, 117, 36);
		registerPanel.add(btnRegister);
		
		JLabel lblAllRights = new JLabel("Micro Star Cable Vission");
		lblAllRights.setBounds(10, 597, 180, 19);
		lblAllRights.setForeground(Color.DARK_GRAY);
		panel.add(lblAllRights);
		
		JLabel label = new JLabel("\u00AE");
		label.setBounds(152, 588, 54, 27);
		label.setForeground(SystemColor.controlShadow);
		panel.add(label);
		
		timeAndDate = new JLabel("Sunday March 21, 2021");
		timeAndDate.setBounds(743, 10, 257, 32);
		timeAndDate.setHorizontalTextPosition(SwingConstants.CENTER);
		timeAndDate.setHorizontalAlignment(SwingConstants.CENTER);
		timeAndDate.setForeground(Color.DARK_GRAY);
		timeAndDate.setFont(new Font("Dialog", Font.ITALIC, 15));
		panel.add(timeAndDate);
	}
	


	private void displayDate() {
		// TODO Auto-generated method stub
		String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
		
		String[] weekName = {null,"Sunday", "Monday",
                "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		
		Calendar cal = Calendar.getInstance();
		
		timeAndDate.setText(weekName[cal.get(Calendar.DAY_OF_WEEK)]+" "+
				monthName[cal.get(Calendar.MONTH)]+" "+
				String.valueOf(cal.get(Calendar.DAY_OF_MONTH))+", "+
				String.valueOf(cal.get(Calendar.YEAR)));
			
	}
}
