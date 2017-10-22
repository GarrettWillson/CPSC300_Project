package project.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class CustomerGUI {

	private JFrame frmCustomer;
	private JTextField txtName;
	private JTextField txtPhoneNum;
	private JTextField txtTime;
	
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGUI window = new CustomerGUI();
					window.frmCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomer = new JFrame();
		frmCustomer.setBounds(100, 100, 772, 527);
		frmCustomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCustomer.getContentPane().setLayout(null);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(291, 11, 137, 41);
		lblCustomer.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 45));
		frmCustomer.getContentPane().add(lblCustomer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 73, 693, 2);
		frmCustomer.getContentPane().add(separator);
		
		txtName = new JTextField();
		txtName.setBounds(180, 114, 118, 20);
		frmCustomer.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(73, 117, 86, 14);
		frmCustomer.getContentPane().add(lblUserName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setBounds(55, 160, 93, 14);
		frmCustomer.getContentPane().add(lblPhoneNumber);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setBounds(180, 157, 118, 20);
		frmCustomer.getContentPane().add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		
		//JDateChooser dateChooser= new JDateChooser();
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 222, 656, -6);
		frmCustomer.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(27, 309, 693, 2);
		frmCustomer.getContentPane().add(separator_2);
		
		JComboBox numPeople = new JComboBox();
		numPeople.setModel(new DefaultComboBoxModel(new String[] {"2 People", "3 People", "4 People", "5 People", "6 People", "7 People", "8 People", "9 People", "10 People", "11 People", "12 People", "13 People", "14 People", "15 People", "16 People", "17 People", "18 People", "19 People", "20 People"}));
		numPeople.setBounds(180, 203, 118, 20);
		frmCustomer.getContentPane().add(numPeople);
		
		JLabel lblnumPeople = new JLabel("No. of seat:");
		lblnumPeople.setBounds(73, 206, 64, 14);
		frmCustomer.getContentPane().add(lblnumPeople);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(356, 117, 46, 14);
		frmCustomer.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(356, 160, 46, 14);
		frmCustomer.getContentPane().add(lblTime);
		
		txtTime = new JTextField();
		txtTime.setBounds(412, 157, 124, 20);
		frmCustomer.getContentPane().add(txtTime);
		txtTime.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(412, 114, 124, 20);
		frmCustomer.getContentPane().add(dateChooser);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(103, 248, 89, 23);
		frmCustomer.getContentPane().add(btnSubmit);
		
		JComboBox JDuration = new JComboBox();
		JDuration.setModel(new DefaultComboBoxModel(new String[] {"1 hour", "2 hours", "3 hours", "4 hours", "5 hours", "6 hours", "7 hours", "8 hours"}));
		JDuration.setBounds(412, 203, 124, 20);
		frmCustomer.getContentPane().add(JDuration);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setBounds(338, 206, 55, 14);
		frmCustomer.getContentPane().add(lblDuration);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setText(null);
				txtPhoneNum.setText(null);
				txtTime.setText(null);
				dateChooser.setDate(null);;
				numPeople.setSelectedItem(null);
				JDuration.setSelectedItem(null);
				
			}
		});
		btnCancel.setBounds(247, 248, 89, 23);
		frmCustomer.getContentPane().add(btnCancel);
		
		JButton btnTimeTable = new JButton("Time Table");
		btnTimeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeTable.main(null);
				
				
				//here will show the available information about tables
				
			}
		});
		btnTimeTable.setBounds(565, 113, 118, 23);
		frmCustomer.getContentPane().add(btnTimeTable);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//here will show that the time or the date whether be available or not
				
				
			}
		});
		btnCheck.setBounds(565, 156, 118, 23);
		frmCustomer.getContentPane().add(btnCheck);
		
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomer.dispose();
			}
		});
		btnExit.setBounds(565, 248, 118, 23);
		frmCustomer.getContentPane().add(btnExit);
		
		JButton btnNewButton = new JButton("Manage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerManage.main(null);
				frmCustomer.dispose();
			}
		});
		btnNewButton.setBounds(378, 248, 89, 23);
		frmCustomer.getContentPane().add(btnNewButton);
		
		JTextPane txtpnSpecialRequest = new JTextPane();
		txtpnSpecialRequest.setText("Special request");
		txtpnSpecialRequest.setBounds(52, 339, 631, 76);
		frmCustomer.getContentPane().add(txtpnSpecialRequest);
	}
}
