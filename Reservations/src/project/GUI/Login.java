package project.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import project.DataStructures.DataLists;

public class Login {

	private JFrame frame;
	private JTextField textName;
	private JPasswordField passwordField;
	protected String userName;
	protected String PhoneNum;
	/**
	 * Launch the application.
	 */
        public static void main(String[] args)
        {
            createLogin();
        }
        
	public static void createLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 240));
		frame.setBackground(Color.GRAY);
		frame.setBounds(200, 200, 648, 387);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(241, 21, 160, 39);
		lblWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 33));
		frame.getContentPane().add(lblWelcome);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(104, 71, 423, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblUserName = new JLabel("User name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(104, 123, 105, 39);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(104, 173, 90, 26);
		frame.getContentPane().add(lblPhone);
		
		textName = new JTextField();
		textName.setBounds(241, 132, 163, 26);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		passwordField = new JPasswordField();
                passwordField.setEchoChar((char)0);
		passwordField.setBounds(241, 176, 163, 26);
		frame.getContentPane().add(passwordField);
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		JRadioButton rdbtnEmployee = new JRadioButton("Employee");
		rdbtnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnEmployee.setSelected(false);
                                passwordField.setEchoChar((char)0);
                                //lblPhone= new JLabel("Phone:");
                                //passwordField.setEchoChar((char)0);
                                lblPhone.setText("Phone:");
			}
		});
		rdbtnCustomer.setSelected(true);
		rdbtnCustomer.setBounds(488, 134, 109, 23);
		frame.getContentPane().add(rdbtnCustomer);
		
		//JRadioButton rdbtnEmployee = new JRadioButton("Employee");
		rdbtnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCustomer.setSelected(false);
                                passwordField.setEchoChar((char)'@');
                                //passwordField.setVisible(false);
				//lblPhone = new JLabel("Password:");
                                /**
				JLabel lblPassword= new JLabel("Password:");
				lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
				frame.getContentPane().remove(lblPhone);
				lblPassword.setBounds(104, 173, 84, 26);
				frame.getContentPane().add(lblPassword);
                                * */
                                lblPhone.setText("Password:");
                                
			}
		});
		rdbtnEmployee.setBounds(488, 178, 109, 23);
		frame.getContentPane().add(rdbtnEmployee);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnCustomer.isSelected()) {
					setUserName(textName.getText());
					setPhoneNum(passwordField.getText());
					CustomerGUI.main(null);
					CustomerGUI cg= new CustomerGUI();
					cg.setUserName(getUserName());
					cg.setPhoneNum(getPhoneNum());
					frame.dispose();
				}else {
					loginWindowLoginButton(passwordField, textName);
				}
				//String username= textName.getText();
				//String password= passwordField.getText();
                                
                                   // JOptionPane.showMessageDialog(null,"User name is empty! Please enter your name.","More info", JOptionPane.PLAIN_MESSAGE);
                                
			}
		});
		btnLogin.setBounds(174, 256, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText(null);
				passwordField.setText(null);
				
			}
		});
		btnReset.setBounds(273, 256, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("EXIT");
				 loginWindowExitButton(frame);
			}
		});
		btnExit.setBounds(372, 256, 89, 23);
		frame.getContentPane().add(btnExit);
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

	public void loginWindowLoginButton(JPasswordField password, JTextField name) {
        //match given credentials to our list of acceptable credentials
        //if not matching, tell user, return to login

        //conver text fields to strings
        String nameString = name.getText();
        String passString = password.getText();
        if (DataLists.isValidEmployee(nameString, passString)) {
            //close current window
            frame.dispose();
            //go to next window
            //Staff info = new Staff();
            //info.main(null);

            Staff.main(null);

        } else {
            JOptionPane.showMessageDialog(null, "Invalid name or password", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        //else, tell user to change info
    }
	
	public void loginWindowResetButton(JPasswordField password, JTextField name) {
        //clear both text fields
        password.setText(null);
        name.setText(null);

    }
	public void loginWindowExitButton(JFrame frame) {
        //ask if they are sure
        //if yes, exit
        int selectedOption = JOptionPane.showConfirmDialog(frame,
                "Are you sure?",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
	
	
	
	
	
	
	
	
}}
