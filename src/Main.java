
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
		UserPanel.setBounds(0, 29, 1000, 570);
		panel.add(UserPanel);
		UserPanel.setLayout(new CardLayout(0, 0));
		
		JPanel representativePanel = new JPanel();
		representativePanel.setLayout(null);
		representativePanel.setBackground(new Color(211, 211, 211));
		UserPanel.add(representativePanel, "name_695581416808347");
		
		JLabel mainLabel = new JLabel("Dashboard");
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
		btnUpdateRecords.setBounds(402, 397, 117, 36);
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
		btnDeleteRecords.setBounds(575, 397, 117, 36);
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
		
		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(null);
		customerPanel.setBackground(new Color(211, 211, 211));
		UserPanel.add(customerPanel, "name_695582208484637");
		
		JLabel lblNewLabel_1 = new JLabel("Technician Panel");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(327, 36, 184, 34);
		customerPanel.add(lblNewLabel_1);
		
		JPanel technicianPanel = new JPanel();
		technicianPanel.setLayout(null);
		technicianPanel.setBackground(new Color(211, 211, 211));
		UserPanel.add(technicianPanel, "name_695582346701449");
		
		JLabel lblNewLabel = new JLabel("Technician Panel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(327, 36, 184, 34);
		technicianPanel.add(lblNewLabel);
		
		JPanel loginPanel = new JPanel();
		UserPanel.add(loginPanel, "name_6943972397436");
		
		JPanel registerPanel = new JPanel();
		UserPanel.add(registerPanel, "name_6944047469471");
		
		JLabel lblAllRights = new JLabel("Micro Star Cable Vission");
		lblAllRights.setBounds(0, 609, 121, 19);
		lblAllRights.setForeground(Color.DARK_GRAY);
		panel.add(lblAllRights);
		
		JLabel label = new JLabel("\u00AE");
		label.setBounds(108, 598, 60, 27);
		label.setForeground(SystemColor.controlShadow);
		panel.add(label);
		
		JLabel timeAndDate = new JLabel("Sunday March 21, 2021");
		timeAndDate.setBounds(743, 0, 257, 32);
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
	
	}
}
