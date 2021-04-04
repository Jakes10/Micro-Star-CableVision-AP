package Registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Dashboard.Main;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Employee {

	private JFrame frmMicrostar;
	private JTextField technician_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
					window.frmMicrostar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Employee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMicrostar = new JFrame();
		frmMicrostar.setIconImage(Toolkit.getDefaultToolkit().getImage(Employee.class.getResource("/img/icons8-home-24.png")));
		frmMicrostar.setTitle("MicroStar");
		frmMicrostar.getContentPane().setBackground(Color.CYAN);
		frmMicrostar.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Technician ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(25, 38, 95, 14);
		frmMicrostar.getContentPane().add(lblNewLabel);
		
		technician_id = new JTextField();
		technician_id.setBounds(130, 37, 196, 27);
		frmMicrostar.getContentPane().add(technician_id);
		technician_id.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
Connection con = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
					String sql = "Select * from technicians where technician_id=?";
					PreparedStatement pst =con.prepareStatement(sql);
					pst.setString(1, technician_id.getText());
				   
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Successful");
						Main.main(null);
						frmMicrostar.dispose();
					}else {
						JOptionPane.showMessageDialog(null, ":( ID Does not match with any record within our database");
				
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
		btnNewButton.setIcon(new ImageIcon(Employee.class.getResource("/img/icons8-login-24.png")));
		btnNewButton.setBounds(167, 108, 126, 27);
		frmMicrostar.getContentPane().add(btnNewButton);
		frmMicrostar.setBounds(100, 100, 450, 300);
		frmMicrostar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
