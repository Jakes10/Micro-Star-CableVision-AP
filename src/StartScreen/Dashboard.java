package StartScreen;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Registration.Employee;
import Registration.User;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Dashboard {

	private JFrame frmMicrostar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMicrostar = new JFrame();
		frmMicrostar.setTitle("Micro_Star");
		frmMicrostar.setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/img/icons8-home-24.png")));
		frmMicrostar.getContentPane().setBackground(Color.CYAN);
		frmMicrostar.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Customer");
		btnNewButton.setToolTipText("Login as a Customer or Register");
		btnNewButton.setMnemonic('A');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User.main(null);
				frmMicrostar.dispose();
			}
		});
		btnNewButton.setBounds(124, 66, 174, 52);
		frmMicrostar.getContentPane().add(btnNewButton);

		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.setToolTipText("Login with your Employee ID if you work here");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee.main(null);
				frmMicrostar.dispose();
			}
		});
		btnEmployee.setBounds(124, 169, 174, 52);
		frmMicrostar.getContentPane().add(btnEmployee);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Dashboard.class.getResource("/img/behavior.png")));
		lblNewLabel_2.setBounds(35, 32, 125, 114);
		frmMicrostar.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/business.png")));
		lblNewLabel.setBounds(35, 188, 68, 33);
		frmMicrostar.getContentPane().add(lblNewLabel);
		frmMicrostar.setBounds(100, 100, 450, 300);
		frmMicrostar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}
}
