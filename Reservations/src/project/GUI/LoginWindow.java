package project.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPhoneNum;
	protected String userName;
	protected String PhoneNum;
	/**
	 * Launch the application.
	 */
        public static void main(String[] args)
        {
            createLoginWindow();
        }
        
	public static void createLoginWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 469, 324);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerLogin = new JLabel("Customer Login");
		lblCustomerLogin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCustomerLogin.setBounds(136, 11, 163, 48);
		frame.getContentPane().add(lblCustomerLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(58, 57, 331, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(58, 95, 86, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPhoneNum = new JLabel("Phone Num:");
		lblPhoneNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNum.setBounds(58, 149, 86, 14);
		frame.getContentPane().add(lblPhoneNum);
		
		txtName = new JTextField();
		txtName.setBounds(169, 92, 86, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setBounds(169, 146, 86, 20);
		frame.getContentPane().add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setUserName(txtName.getText());
				setPhoneNum(txtPhoneNum.getText());
				
				CustomerGUI.main(null);
				CustomerGUI cg= new CustomerGUI();
				cg.setUserName(getUserName());
				cg.setPhoneNum(getPhoneNum());
				
				
				frame.dispose();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(300, 91, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                            LoginWindowResetButton();
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(300, 145, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(55, 194, 334, -11);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(65, 194, 324, -11);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(58, 194, 331, 2);
		frame.getContentPane().add(separator_3);
		
		JButton btnAdminLogin = new JButton("Admin login");
		btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeLogin.main(null);
				frame.dispose();
			}
		});
		btnAdminLogin.setBounds(65, 207, 116, 23);
		frame.getContentPane().add(btnAdminLogin);
		
		JButton btnCreatNew = new JButton("Creat new");
		btnCreatNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                            LoginWindowCreatenewButton();
				// here will make a new file for new customer
			}
		});
		btnCreatNew.setBounds(248, 207, 89, 23);
		frame.getContentPane().add(btnCreatNew);
	}

	protected void setUserName(String text) {
		// TODO Auto-generated method stub
		userName= text;
	}
	protected  String getUserName() {
		return userName;
	}
	
	protected void setPhoneNum(String text) {
		// TODO Auto-generated method stub
		PhoneNum= text;
	}
	protected String getPhoneNum() {
		return PhoneNum;
	}
        
        private void LoginWindowLoginButton()
        {
            
        }
        
        private void LoginWindowResetButton()
        {
            
        }
        
        private void LoginWindowAdminLoginButton()
        {
            
        }
        
        private void LoginWindowCreatenewButton()
        {
            
        }
        
}
