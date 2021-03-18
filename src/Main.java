
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

//Edited by Crystal
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
        btnNewButton_2.setBounds(318, 407, 89, 26);
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
        btnViewAll.setBounds(431, 407, 98, 26);
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
		
		JButton deleteSearchBtn = new JButton("Search");
		deleteSearchBtn.setFocusable(false);
		deleteSearchBtn.setIconTextGap(0);
		deleteSearchBtn.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		deleteSearchBtn.setForeground(Color.DARK_GRAY);
		deleteSearchBtn.setFont(new Font("Elephant", Font.PLAIN, 13));
		deleteSearchBtn.setBackground(new Color(211, 211, 211));
		deleteSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
			}
		});
		deleteSearchBtn.setBounds(364, 407, 89, 27);
		assignPanel.add(deleteSearchBtn);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		textField.setBackground(new Color(220, 220, 220));
		textField.setBounds(168, 411, 159, 20);
		assignPanel.add(textField);
		
		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(null);
		customerPanel.setBackground(new Color(211, 211, 211));
		mainPanel.add(customerPanel, "name_556438443648875");
		
		JLabel lblNewLabel_1 = new JLabel("Technician Panel");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(327, 36, 184, 34);
		customerPanel.add(lblNewLabel_1);
		
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
