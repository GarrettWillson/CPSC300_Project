package project.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class CustomerManage {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPhoneNum;
	private static String userName;
	private static String phoneNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerManage window = new CustomerManage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerManage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 716, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblReservationManagement = new JLabel("Reservation management");
		lblReservationManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReservationManagement.setBounds(235, 27, 221, 48);
		frame.getContentPane().add(lblReservationManagement);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(57, 73, 590, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblUserName = new JLabel("User name:");
		lblUserName.setBounds(77, 97, 96, 30);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPhoneNum = new JLabel("Phone num:");
		lblPhoneNum.setBounds(77, 138, 96, 30);
		frame.getContentPane().add(lblPhoneNum);
		
		txtUsername = new JTextField();
		txtUsername.setText(userName);
		txtUsername.setBounds(182, 102, 118, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setText(phoneNum);
		txtPhoneNum.setBounds(182, 143, 118, 20);
		frame.getContentPane().add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
	}
	public void setUserName(String userName2) {
		// TODO Auto-generated method stub
		userName=userName2;
	}

	public void setPhoneNum(String phoneNum2) {
		// TODO Auto-generated method stub
		phoneNum=phoneNum2;
	}
}
