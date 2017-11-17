package project.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class CustomerManage {
/*
    user name and phone number should just be displayed, not editable
    table entries should not be directly editable via text, add modify entry button
    to change row entries
    
    */
	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPhoneNum;
	private static String userName;
	private static String phoneNum;
	private JTable table;

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
		frame.setBounds(100, 100, 847, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblReservationManagement = new JLabel("Reservation management");
		lblReservationManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReservationManagement.setBounds(235, 27, 221, 48);
		frame.getContentPane().add(lblReservationManagement);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(57, 73, 764, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblUserName = new JLabel("User name:");
		lblUserName.setBounds(76, 97, 96, 30);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPhoneNum = new JLabel("Phone num:");
		lblPhoneNum.setBounds(76, 138, 96, 30);
		frame.getContentPane().add(lblPhoneNum);
		
		txtUsername = new JTextField();
		txtUsername.setEditable(false);
		txtUsername.setText(userName);
		txtUsername.setBounds(182, 102, 118, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setEditable(false);
		txtPhoneNum.setText(phoneNum);
		txtPhoneNum.setBounds(182, 143, 118, 20);
		frame.getContentPane().add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Name", "# of people", "Date", "Time", "Duration", "# of table", "special request"},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Name", "# of people", "Date", "Time", "Duration", "# of table", "special request"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(88);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(193);
		table.setBounds(76, 202, 714, 160);
		frame.getContentPane().add(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(155, 400, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(264, 400, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(375, 400, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(484, 400, 89, 23);
		frame.getContentPane().add(btnBack);
	}
	public void setUserName(String userName2) {
		// TODO Auto-generated method stub
		userName=userName2;
	}

	public void setPhoneNum(String phoneNum2) {
		// TODO Auto-generated method stub
		phoneNum=phoneNum2;
	}
        
        public void CustomerManageAddButton()
        {
        }
        public void CustomerManageDeleteButton()
        {
        }
        public void CustomerManageSearchButton()
        {
            
        }
        public void CustomerManageBackButton()
        {
        }
}
