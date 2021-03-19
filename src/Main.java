
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;


public class Main {

	private JFrame frmMscv;
	private JPanel dashboardPanel;
	private JLabel mainLabel;
	private JPanel complaintsPanel;
	private JButton mainBtnView;
	private JButton mainBtnAddMember;
	private JButton mainBtnDashboard;
	private JPanel selectPanel;
	private JPanel servicePanel;
	private JPanel respondPanel;
	private JPanel assignPanel;
	private JTable table; 
	private DefaultTableModel dtm ;
	private JTextField searchSingle;  
	private JButton mainBtnUpdate;
	private JButton mainBtnDelete; 
	private JLabel timeAndDate;
	private JTextField textField;
	private JTextField technician_id;
	private JTextField created_at;
	private JTextField updated_at;
	private JTextField txt_updated_at;
	private JTextField txt_created_at;
	private JTextField cost;
	private JTextField description;
	private JTextField reponse_id;
	private JTextField representative_id;
	private JTextField customer_id;
	private JTextField complaint_id;
	private JTextField txt_customer_id;
	private JTextField txt_created_at1;
	private JTextField txt_updated_at1;
	private JTextField rep_1;
	private JTextField created_at_;
	private JTextField updated_at_;
	private JTextField respond_id;
	private JTextField technician_id_;
	private JTextField customer_id_;
	private JTextField created_at_1;
	private JTextField updated_at_1;
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
	
		JButton[] mainButton= {mainBtnDashboard, mainBtnAddMember, mainBtnView, mainBtnUpdate, mainBtnDelete};
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
		frmMscv.setBounds(100, 100, 941, 614);
		frmMscv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMscv.getContentPane().setLayout(new CardLayout(0, 0));
		frmMscv.setLocationRelativeTo(null);
		frmMscv.setTitle("MSCV");
		frmMscv.setResizable(false);
		

		JPanel mainPanel = new JPanel();
		frmMscv.getContentPane().add(mainPanel, "name_40632074234174");
		
		JPanel representativePanel = new JPanel();
		representativePanel.setBackground(new Color(211, 211, 211));
		mainPanel.setVisible(true);
		mainPanel.setLayout(new CardLayout(0, 0));
		mainPanel.add(representativePanel, "name_555888053346368");
		representativePanel.setLayout(null);
		mainLabel = new JLabel("Dashboard");
		mainLabel.setForeground(Color.DARK_GRAY);
		
		
		mainBtnDashboard = new JButton("Dashboard");
		mainBtnDashboard.setHorizontalAlignment(SwingConstants.LEFT);
		mainBtnDashboard.setHorizontalTextPosition(SwingConstants.RIGHT);
		mainBtnDashboard.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mainBtnDashboard.setBorder(null);
		mainBtnDashboard.setFocusable(false);
		mainBtnDashboard.setBackground(new Color(211, 211, 211));
		mainBtnDashboard.setForeground(new Color(0, 191, 255));
		mainBtnDashboard.setFont(new Font("Elephant", Font.PLAIN, 16));
		mainBtnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainLabel.setText("Dashboard");
		
				setPanel(0);
			 
			}
		});
		
		
		mainLabel.setFont(new Font("Elephant", Font.PLAIN, 25));
		mainLabel.setBounds(169, 10, 370, 34);
		representativePanel.add(mainLabel);
		mainBtnDashboard.setBounds(10, 53, 138, 33);
		representativePanel.add(mainBtnDashboard);
		
	
		mainBtnAddMember = new JButton("Services");
		mainBtnAddMember.setHorizontalAlignment(SwingConstants.LEFT);
		mainBtnAddMember.setHorizontalTextPosition(SwingConstants.RIGHT);
		mainBtnAddMember.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mainBtnAddMember.setBorder(null);
		mainBtnAddMember.setFocusable(false);
		mainBtnAddMember.setForeground(Color.DARK_GRAY);
		mainBtnAddMember.setBackground(new Color(211, 211, 211));
		mainBtnAddMember.setFont(new Font("Elephant", Font.PLAIN, 16));
		mainBtnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			
				mainLabel.setText("Services");
				setPanel(1);
			}
		});
		mainBtnAddMember.setBounds(10, 88, 138, 33);
		representativePanel.add(mainBtnAddMember);
		
		mainBtnView = new JButton("Complaints");
		mainBtnView.setHorizontalAlignment(SwingConstants.LEFT);
		mainBtnView.setHorizontalTextPosition(SwingConstants.RIGHT);
		mainBtnView.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mainBtnView.setFont(new Font("Elephant", Font.PLAIN, 16));
		mainBtnView.setForeground(Color.DARK_GRAY);
		mainBtnView.setBackground(new Color(211, 211, 211));
		mainBtnView.setBorder(null);
		mainBtnView.setFocusable(false);
		mainBtnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				mainLabel.setText("View Complaints");
				setPanel(2);
			}
		});
		mainBtnView.setBounds(10, 124, 138, 33);
		representativePanel.add(mainBtnView);
		
		mainBtnUpdate = new JButton("Respond to Enquiry");
		mainBtnUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		mainBtnUpdate.setHorizontalTextPosition(SwingConstants.RIGHT);
		mainBtnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mainBtnUpdate.setForeground(Color.DARK_GRAY);
		mainBtnUpdate.setFont(new Font("Elephant", Font.PLAIN, 16));
		mainBtnUpdate.setBackground(new Color(211, 211, 211));
		mainBtnUpdate.setBorder(null);
		mainBtnUpdate.setFocusable(false);
		mainBtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainLabel.setText("Enquires");
		        setPanel(3);
			}
		});
		mainBtnUpdate.setBounds(10, 161, 138, 33);
		representativePanel.add(mainBtnUpdate);
		
		mainBtnDelete = new JButton("Assign Complaint");
		mainBtnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		mainBtnDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
		mainBtnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mainBtnDelete.setForeground(Color.DARK_GRAY);
		mainBtnDelete.setFont(new Font("Elephant", Font.PLAIN, 16));
		mainBtnDelete.setBackground(new Color(211, 211, 211));
		mainBtnDelete.setBorder(null);
		mainBtnDelete.setFocusable(false);
		mainBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainLabel.setText("Assign a Technician");
			    setPanel(4);
			}
		});
		mainBtnDelete.setBounds(10, 198, 138, 33);
		representativePanel.add(mainBtnDelete);
		
		selectPanel = new JPanel();
		selectPanel.setBounds(167, 53, 750, 443);
		representativePanel.add(selectPanel);
		
		selectPanel.setLayout(new CardLayout(0, 0));
		dashboardPanel = new JPanel();
		dashboardPanel.setBackground(new Color(220, 220, 220));
		selectPanel.add(dashboardPanel, "name_45964627510302");
		dashboardPanel.setLayout(null);
		
		
		JButton btnAdd1 = new JButton("Services");
		btnAdd1.setFocusable(false);
		btnAdd1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnAdd1.setFont(new Font("Elephant", Font.PLAIN, 17));
		btnAdd1.setBackground(new Color(211, 211, 211));
		btnAdd1.setForeground(Color.DARK_GRAY);
		btnAdd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText("Services");
				setPanel(1);
			}
		});
	
		btnAdd1.setBounds(42, 392, 140, 43);
		dashboardPanel.add(btnAdd1);
		
		JButton btnView1 = new JButton("Complaints");
		btnView1.setFocusable(false);
		btnView1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnView1.setFont(new Font("Elephant", Font.PLAIN, 17));
		btnView1.setBackground(new Color(211, 211, 211));
		btnView1.setForeground(Color.DARK_GRAY);
		btnView1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText("View Members");
				setPanel(2);
			}
		});
		
		btnView1.setBounds(224, 392, 140, 43);
		dashboardPanel.add(btnView1);
		
		JButton btnUpdateRecords = new JButton("Assign");
		btnUpdateRecords.setFocusable(false);
		btnUpdateRecords.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnUpdateRecords.setFont(new Font("Elephant", Font.PLAIN, 17));
		btnUpdateRecords.setBackground(new Color(211, 211, 211));
		btnUpdateRecords.setForeground(Color.DARK_GRAY);
		btnUpdateRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText("Update");
				setPanel(3);
			}
		});
		btnUpdateRecords.setBounds(588, 392, 140, 43);
		dashboardPanel.add(btnUpdateRecords);
		
		
		JButton btnDeleteRecords = new JButton("Respond");
		btnDeleteRecords.setFocusable(false);
		btnDeleteRecords.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnDeleteRecords.setFont(new Font("Elephant", Font.PLAIN, 17));
		btnDeleteRecords.setBackground(new Color(211, 211, 211));
		btnDeleteRecords.setForeground(Color.DARK_GRAY);
		btnDeleteRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText("Delete");
				setPanel(4);
			}
		});
		btnDeleteRecords.setBounds(406, 392, 140, 43);
		dashboardPanel.add(btnDeleteRecords);
		
		JLabel lblNewLabel_5 = new JLabel("Representative ");
		lblNewLabel_5.setBounds(91, 63, 103, 14);
		dashboardPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Created At");
		lblNewLabel_5_1.setBounds(91, 138, 103, 14);
		dashboardPanel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Updated At");
		lblNewLabel_5_2.setBounds(91, 207, 103, 14);
		dashboardPanel.add(lblNewLabel_5_2);
		
		rep_1 = new JTextField();
		rep_1.setBounds(322, 60, 160, 33);
		dashboardPanel.add(rep_1);
		rep_1.setColumns(10);
		
		created_at_ = new JTextField();
		created_at_.setColumns(10);
		created_at_.setBounds(322, 135, 160, 33);
		dashboardPanel.add(created_at_);
		
		updated_at_ = new JTextField();
		updated_at_.setColumns(10);
		updated_at_.setBounds(322, 198, 160, 33);
		dashboardPanel.add(updated_at_);
		
		JButton btnNewButton = new JButton("Assign Representative");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				
				
				
				try{
					String sql = "INSERT INTO representatives"
					+"(representative_id, created_at,updated_at) "
					+"VALUES (?,?,?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
					pst = con.prepareStatement(sql);
					pst.setString(1,rep_1.getText());
					pst.setString(2,created_at_.getText());
					pst.setString(3,updated_at_.getText());		
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "inserted successfully");
					 
					}
					catch(SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
					}
		
			}
						
			
		});
		btnNewButton.setBounds(322, 257, 176, 33);
		dashboardPanel.add(btnNewButton);
		
		servicePanel = new JPanel();
		servicePanel.setBackground(new Color(220, 220, 220));
		selectPanel.add(servicePanel, "name_46042517729470");
		servicePanel.setLayout(null);
		servicePanel.setVisible(false);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(74, 33, 595, 2);
		servicePanel.add(separator_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(74, 77, 595, 2);
		servicePanel.add(separator);
		
		txt_updated_at = new JTextField();
		txt_updated_at.setColumns(10);
		txt_updated_at.setBounds(348, 401, 153, 31);
		servicePanel.add(txt_updated_at);
		
		txt_created_at = new JTextField();
		txt_created_at.setColumns(10);
		txt_created_at.setBounds(348, 347, 153, 31);
		servicePanel.add(txt_created_at);
		
		cost = new JTextField();
		cost.setColumns(10);
		cost.setBounds(348, 305, 153, 31);
		servicePanel.add(cost);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(348, 247, 153, 31);
		servicePanel.add(description);
		
		reponse_id = new JTextField();
		reponse_id.setColumns(10);
		reponse_id.setBounds(348, 205, 153, 31);
		servicePanel.add(reponse_id);
		
		representative_id = new JTextField();
		representative_id.setColumns(10);
		representative_id.setBounds(348, 163, 153, 31);
		servicePanel.add(representative_id);
		
		customer_id = new JTextField();
		customer_id.setColumns(10);
		customer_id.setBounds(348, 121, 153, 31);
		servicePanel.add(customer_id);
		
		complaint_id = new JTextField();
		complaint_id.setColumns(10);
		complaint_id.setBounds(348, 79, 153, 31);
		servicePanel.add(complaint_id);
		
		JLabel lblNewLabel_3 = new JLabel("Complaint ID");
		lblNewLabel_3.setBounds(158, 90, 93, 14);
		servicePanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Customer ID");
		lblNewLabel_3_1.setBounds(158, 129, 93, 14);
		servicePanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Representative ID");
		lblNewLabel_3_2.setBounds(158, 171, 109, 14);
		servicePanel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Response ID");
		lblNewLabel_3_3.setBounds(158, 213, 109, 14);
		servicePanel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Description ID");
		lblNewLabel_3_4.setBounds(158, 259, 93, 14);
		servicePanel.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Cost");
		lblNewLabel_3_5.setBounds(158, 313, 93, 14);
		servicePanel.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("Created At");
		lblNewLabel_3_6.setBounds(158, 362, 71, 14);
		servicePanel.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("Updated At");
		lblNewLabel_3_7.setBounds(158, 409, 71, 14);
		servicePanel.add(lblNewLabel_3_7);
		
		JButton btnLodgeComplaint = new JButton("Lodge Complaint");
		btnLodgeComplaint.setBounds(512, 402, 109, 27);
		servicePanel.add(btnLodgeComplaint);
		btnLodgeComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				
				
				
				try{
					String sql = "INSERT INTO complaints"
					+"(complaint_id, customer_id,representative_id,response_id,description,cost,created_at,updated_at) "
					+"VALUES (?,?,?,?,?,?,?,?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
					pst = con.prepareStatement(sql);
					pst.setString(1,complaint_id.getText());
					pst.setString(2,customer_id.getText());
					pst.setString(3,representative_id.getText());
					
					pst.setString(4,reponse_id.getText());
					pst.setString(5,description.getText());
					pst.setString(6,cost.getText());
					pst.setString(7,txt_created_at.getText());
					pst.setString(8,txt_updated_at.getText());
			
			
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "inserted successfully");
					 
					}
					catch(SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
					}
			

			
				

				
			}
		});
		
			
			btnLodgeComplaint.setIconTextGap(0);
			btnLodgeComplaint.setForeground(Color.DARK_GRAY);
			btnLodgeComplaint.setFont(new Font("Dialog", Font.PLAIN, 13));
			btnLodgeComplaint.setFocusable(false);
			btnLodgeComplaint.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
			btnLodgeComplaint.setBackground(new Color(211, 211, 211));
			
			JButton btnMakeQuery = new JButton("Make Query");
			btnMakeQuery.setBounds(631, 402, 109, 27);
			servicePanel.add(btnMakeQuery);
			btnMakeQuery.setIconTextGap(0);
			btnMakeQuery.setForeground(Color.DARK_GRAY);
			btnMakeQuery.setFont(new Font("Dialog", Font.PLAIN, 13));
			btnMakeQuery.setFocusable(false);
			btnMakeQuery.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
			btnMakeQuery.setBackground(new Color(211, 211, 211));
		
		
		complaintsPanel = new JPanel();
		complaintsPanel.setBackground(new Color(220, 220, 220));
		complaintsPanel.setVisible(false);
		selectPanel.add(complaintsPanel, "name_46047565955497");
		complaintsPanel.setLayout(null);
		
		
	        
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(119, 136, 153));
		scrollPane.setBounds(10, 11, 730, 368);
		complaintsPanel.add(scrollPane);	
		
		Object[] title = {"Complaints"};
	    dtm = new DefaultTableModel(); 
	    dtm.setColumnIdentifiers(title);
		table = new JTable(dtm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setGridColor(new Color(0, 191, 255));
		scrollPane.setViewportView(table);
		table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);
        
        JButton btnNewButton_2 = new JButton("Search");
        btnNewButton_2.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
        btnNewButton_2.setForeground(Color.DARK_GRAY);
        btnNewButton_2.setFont(new Font("Elephant", Font.PLAIN, 13));
        btnNewButton_2.setBackground(new Color(211, 211, 211));
        btnNewButton_2.addActionListener(new ActionListener() {

            	public void actionPerformed(ActionEvent arg0) {

            	
            	}
        });
        btnNewButton_2.setBounds(461, 407, 89, 26);
        complaintsPanel.add(btnNewButton_2);
        
        JButton btnViewAll = new JButton("View All");
        btnViewAll.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
        btnViewAll.setForeground(Color.DARK_GRAY);
        btnViewAll.setFont(new Font("Elephant", Font.PLAIN, 13));
        btnViewAll.setBackground(new Color(211, 211, 211));
        btnViewAll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}

        });
        btnViewAll.setBounds(579, 407, 98, 26);
        complaintsPanel.add(btnViewAll);
        
        searchSingle = new JTextField();
        searchSingle.setFont(new Font("Arial", Font.PLAIN, 14));
        searchSingle.setBackground(new Color(220, 220, 220));
        searchSingle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
        searchSingle.setBounds(149, 411, 159, 20);
        complaintsPanel.add(searchSingle);
        searchSingle.setColumns(10);
        
        JLabel lblAlias_1 = new JLabel("Key Word");
        lblAlias_1.setForeground(Color.DARK_GRAY);
        lblAlias_1.setFont(new Font("Elephant", Font.PLAIN, 13));
        lblAlias_1.setBounds(150, 398, 98, 14);
        complaintsPanel.add(lblAlias_1);
		
		respondPanel = new JPanel();
		respondPanel.setFocusable(false);
		respondPanel.setBackground(new Color(220, 220, 220));
		respondPanel.setVisible(false);
		selectPanel.add(respondPanel, "name_46061562353485");
		respondPanel.setLayout(null);
		
		 
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(87, 65, 595, 2);
		respondPanel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(87, 21, 595, 2);
		respondPanel.add(separator_5);
		
		respond_id = new JTextField();
		respond_id.setBounds(411, 78, 160, 34);
		respondPanel.add(respond_id);
		respond_id.setColumns(10);
		
		technician_id_ = new JTextField();
		technician_id_.setColumns(10);
		technician_id_.setBounds(411, 123, 160, 34);
		respondPanel.add(technician_id_);
		
		customer_id_ = new JTextField();
		customer_id_.setColumns(10);
		customer_id_.setBounds(411, 168, 160, 34);
		respondPanel.add(customer_id_);
		
		JLabel lblNewLabel_6 = new JLabel("Response id");
		lblNewLabel_6.setBounds(138, 88, 83, 14);
		respondPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Technician id");
		lblNewLabel_6_1.setBounds(138, 137, 83, 14);
		respondPanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Customer id");
		lblNewLabel_6_1_1.setBounds(138, 183, 83, 14);
		respondPanel.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("Created At");
		lblNewLabel_7.setBounds(138, 239, 83, 14);
		respondPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Updated At");
		lblNewLabel_7_1.setBounds(138, 286, 83, 14);
		respondPanel.add(lblNewLabel_7_1);
		
		created_at_1 = new JTextField();
		created_at_1.setColumns(10);
		created_at_1.setBounds(411, 229, 160, 34);
		respondPanel.add(created_at_1);
		
		updated_at_1 = new JTextField();
		updated_at_1.setColumns(10);
		updated_at_1.setBounds(411, 283, 160, 34);
		respondPanel.add(updated_at_1);
		
		JButton btnNewButton_1 = new JButton("Add Response");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				
				
				
				try{
					String sql = "INSERT INTO responses"
					+"(response_id, technician_id,customer_id,created_at,updated_at) "
					+"VALUES (?,?,?,?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
					pst = con.prepareStatement(sql);
					pst.setString(1,respond_id.getText());
					pst.setString(2,technician_id_.getText());
					pst.setString(3,customer_id_.getText());
					pst.setString(4,created_at_1.getText());
					pst.setString(5,updated_at_1.getText());
					
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "inserted successfully");
					 
					}
					catch(SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
					}
			

			}
				
				
				
				
				
			
			
		});
		btnNewButton_1.setBounds(411, 331, 117, 39);
		respondPanel.add(btnNewButton_1);
		
		assignPanel = new JPanel();
		assignPanel.setFocusable(false);
		assignPanel.setBackground(new Color(220, 220, 220));
		assignPanel.setVisible(false);
		selectPanel.add(assignPanel, "name_46100311220098");
		assignPanel.setLayout(null);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(75, 67, 595, 2);
		assignPanel.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(75, 342, 595, 2);
		assignPanel.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(75, 23, 595, 2);
		assignPanel.add(separator_8);
		
		JButton deleteSearchBtn = new JButton("Assign Technician");
		deleteSearchBtn.setFocusable(false);
		deleteSearchBtn.setIconTextGap(0);
		deleteSearchBtn.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		deleteSearchBtn.setForeground(Color.DARK_GRAY);
		deleteSearchBtn.setFont(new Font("Elephant", Font.PLAIN, 13));
		deleteSearchBtn.setBackground(new Color(211, 211, 211));
		deleteSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				
				
				
				try{
					String sql = "INSERT INTO technicians"
					+"(technician_id,created_at,updated_at) "
					+"VALUES (?,?,?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
					pst = con.prepareStatement(sql);
					pst.setString(1,technician_id.getText());
					pst.setString(2,created_at.getText());
					pst.setString(3,updated_at.getText());
					
			
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "inserted successfully");
					 
					}
					catch(SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
					}
			
			}
				
			
		});
		deleteSearchBtn.setBounds(364, 407, 109, 27);
		assignPanel.add(deleteSearchBtn);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		textField.setBackground(new Color(220, 220, 220));
		textField.setBounds(168, 411, 159, 20);
		assignPanel.add(textField);
		
		JButton deleteSearchBtn_1 = new JButton("Search");
		deleteSearchBtn_1.setIconTextGap(0);
		deleteSearchBtn_1.setForeground(Color.DARK_GRAY);
		deleteSearchBtn_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		deleteSearchBtn_1.setFocusable(false);
		deleteSearchBtn_1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		deleteSearchBtn_1.setBackground(new Color(211, 211, 211));
		deleteSearchBtn_1.setBounds(515, 407, 89, 27);
		assignPanel.add(deleteSearchBtn_1);
		
		JLabel lblNewLabel_2 = new JLabel("Technicians");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(110, 115, 102, 14);
		assignPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Created At");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(110, 161, 72, 14);
		assignPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Updated At");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(110, 217, 72, 14);
		assignPanel.add(lblNewLabel_2_1_1);
		
		technician_id = new JTextField();
		technician_id.setBounds(311, 113, 162, 32);
		assignPanel.add(technician_id);
		technician_id.setColumns(10);
		
		created_at = new JTextField();
		created_at.setColumns(10);
		created_at.setBounds(311, 159, 162, 32);
		assignPanel.add(created_at);
		
		updated_at = new JTextField();
		updated_at.setColumns(10);
		updated_at.setBounds(311, 202, 162, 32);
		assignPanel.add(updated_at);
		
		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(null);
		customerPanel.setBackground(new Color(211, 211, 211));
		mainPanel.add(customerPanel, "name_556438443648875");
		
		JLabel lblNewLabel_1 = new JLabel("Technician Panel");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(327, 36, 184, 34);
		customerPanel.add(lblNewLabel_1);
		
		txt_customer_id = new JTextField();
		txt_customer_id.setBounds(503, 109, 170, 34);
		customerPanel.add(txt_customer_id);
		txt_customer_id.setColumns(10);
		
		txt_created_at1 = new JTextField();
		txt_created_at1.setColumns(10);
		txt_created_at1.setBounds(503, 166, 170, 34);
		customerPanel.add(txt_created_at1);
		
		txt_updated_at1 = new JTextField();
		txt_updated_at1.setColumns(10);
		txt_updated_at1.setBounds(503, 227, 170, 34);
		customerPanel.add(txt_updated_at1);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				
				
				
				try{
					String sql = "INSERT INTO customers"
					+"(customer_id, created_at,customer_id,updated_at) "
					+"VALUES (?,?,?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
					pst = con.prepareStatement(sql);
					pst.setString(1,txt_customer_id.getText());
					pst.setString(2,txt_created_at1.getText());
					pst.setString(3,txt_updated_at1.getText());
				
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "inserted successfully");
					 
					}
					catch(SQLException | HeadlessException ex){
					JOptionPane.showMessageDialog(null, ex);
					}
			

			}
				
				
			
		});
		btnAddCustomer.setIconTextGap(0);
		btnAddCustomer.setForeground(Color.DARK_GRAY);
		btnAddCustomer.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnAddCustomer.setFocusable(false);
		btnAddCustomer.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnAddCustomer.setBackground(new Color(211, 211, 211));
		btnAddCustomer.setBounds(503, 299, 109, 27);
		customerPanel.add(btnAddCustomer);
		
		JLabel lblNewLabel_4 = new JLabel("Customer ID");
		lblNewLabel_4.setBounds(123, 119, 91, 24);
		customerPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Created At");
		lblNewLabel_4_1.setBounds(123, 176, 91, 24);
		customerPanel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Updated At");
		lblNewLabel_4_1_1.setBounds(123, 237, 91, 24);
		customerPanel.add(lblNewLabel_4_1_1);
		
		JPanel technicianPanel = new JPanel();
		technicianPanel.setLayout(null);
		technicianPanel.setBackground(new Color(211, 211, 211));
		mainPanel.add(technicianPanel, "name_556438773347036");
		
		JLabel lblNewLabel = new JLabel("Technician Panel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(327, 36, 184, 34);
		technicianPanel.add(lblNewLabel);
		
		JLabel lblAllRights = new JLabel("Micro Star Cable Vission");
		mainPanel.add(lblAllRights, "name_555888063834957");
		lblAllRights.setForeground(Color.DARK_GRAY);
		
		JLabel label = new JLabel("\u00AE");
		label.setForeground(SystemColor.controlShadow);
		mainPanel.add(label, "name_555888075935142");
		
		timeAndDate = new JLabel("");
		timeAndDate.setHorizontalTextPosition(SwingConstants.CENTER);
		timeAndDate.setHorizontalAlignment(SwingConstants.CENTER);
		timeAndDate.setForeground(Color.DARK_GRAY);
		timeAndDate.setFont(new Font("Dialog", Font.ITALIC, 15));
		mainPanel.add(timeAndDate, "name_555888086982109");
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
