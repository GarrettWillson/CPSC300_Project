package project.GUI;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import static project.DataStructures.DataLists.addReservation;
import project.DataStructures.Reservation;
import static project.GUI.Login.createLogin;

public class CustomerGUI {
 /*
    it might be easier for you to use layouts for the GUIs instead of hardcoding the
    coordinates and dimensions, probably not worth it to redo whats working but if
    we have to add a new window it would probably be a lot easier and quicker
    
      user name and phone number txt fields should autofill and not be editable, add new
    button to change user ||||got 
    time text field should be a combo box for hours 1-12 so that its more user friendly
    |||got
    and requires less testing on our end, am and pm can be a combo box or jradiobutton
    |||got
    might want to change date text field to uneditable
    |||got
    need button to select table from floorplan ||| i think the btm Time table would be that.
        
 */
	private JFrame frmCustomer;
	private JTextField txtName;
	private JTextField txtPhoneNum;
	private JTextField txtTime;
	private static String userName;
	private static String phoneNum;
        private JTextPane txtpnSpecialRequest;
        private JDateChooser dateChooser;
        private JComboBox JDuration;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args)
        {
            createCustomerGUI();
        }
	
	public static void createCustomerGUI() {
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
		//CustomerLogin cl=new CustomerLogin();
		frmCustomer.setBounds(100, 100, 772, 527);
		frmCustomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCustomer.getContentPane().setLayout(null);
		
		JLabel lblCustomer = new JLabel("Reservation Editor");
		lblCustomer.setBounds(270, 11, 1000, 100);
		lblCustomer.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 20));
		frmCustomer.getContentPane().add(lblCustomer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 73, 693, 2);
		frmCustomer.getContentPane().add(separator);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setText(userName);
		txtName.setBounds(180, 114, 118, 20);
		frmCustomer.getContentPane().add(txtName);
		txtName.setColumns(10);
		//CustomerLogin cl=new CustomerLogin();
		//txtName.setText(cl.getUserName());
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(73, 117, 86, 14);
		frmCustomer.getContentPane().add(lblUserName);
		
		JLabel lblPhoneNumber = new JLabel("Phone #:");
		lblPhoneNumber.setBounds(75, 160, 93, 14);
		frmCustomer.getContentPane().add(lblPhoneNumber);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setEditable(false);
		txtPhoneNum.setText(phoneNum);
		txtPhoneNum.setBounds(180, 157, 118, 20);
		frmCustomer.getContentPane().add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		//txtPhoneNum.setText(cl.getPhoneNum());
		
		//JDateChooser dateChooser= new JDateChooser();
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 222, 656, -6);
		frmCustomer.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(27, 330, 693, 2);
		frmCustomer.getContentPane().add(separator_2);
		
		JComboBox numPeople = new JComboBox();
		numPeople.setModel(new DefaultComboBoxModel(new String[]
                {"","2 People", "3 People", "4 People", "5 People", "6 People", 
                    "7 People", "8 People", "9 People", "10 People", "11 People", 
                    "12 People", "13 People", "14 People", "15 People", "16 People", 
                    "17 People", "18 People", "19 People", "20 People"}));
		numPeople.setBounds(180, 203, 118, 20);
		frmCustomer.getContentPane().add(numPeople);
		
		JLabel lblnumPeople = new JLabel("# of people:");
		lblnumPeople.setBounds(53, 206, 1000, 14);
		frmCustomer.getContentPane().add(lblnumPeople);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(356, 117, 46, 14);
		frmCustomer.getContentPane().add(lblDate);
		
                
                JComboBox times = new JComboBox();
		times.setModel(new DefaultComboBoxModel(new String[] 
                {"","1","2","3","4","5","6"
                ,"7" ,"8","9","10","11","12",}));
		times.setBounds(412, 157, 64, 20);
		frmCustomer.getContentPane().add(times);
                
                JComboBox ampm = new JComboBox();
		ampm.setModel(new DefaultComboBoxModel(new String[] 
                {"am","pm"}));
		ampm.setBounds(476, 157, 64, 20);
		frmCustomer.getContentPane().add(ampm);
                
                
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(356, 160, 46, 14);
		frmCustomer.getContentPane().add(lblTime);
		
		
		
		dateChooser = new JDateChooser();
                dateChooser.getDateEditor().setEnabled(false);
		dateChooser.setBounds(412, 114, 124, 20);
		frmCustomer.getContentPane().add(dateChooser);
                
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSubmit.setBounds(220, 350, 89, 23);
		frmCustomer.getContentPane().add(btnSubmit);
                
                JComboBox JTable= new JComboBox();
                JTable.setModel(new DefaultComboBoxModel(new String[]
                {"","Table 1","Table 2","Table 3",
                "Table 4","Table 5","Table 6"}));
                JTable.setBounds(605,203,80,20);
                frmCustomer.getContentPane().add(JTable);
		
		JDuration = new JComboBox();
		JDuration.setModel(new DefaultComboBoxModel(new String[] 
                {"","1 hour", "2 hours", "3 hours", "4 hours", "5 hours",
                    "6 hours", "7 hours", "8 hours"}));
		JDuration.setBounds(412, 203, 80, 20);
		frmCustomer.getContentPane().add(JDuration);
                
                JLabel lblTable= new JLabel("Choose Table:");
                lblTable.setBounds(500, 206, 1000, 14);
                frmCustomer.getContentPane().add(lblTable);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setBounds(338, 206, 1000, 14);
		frmCustomer.getContentPane().add(lblDuration);
		
		JButton btnCancel = new JButton("Reset");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//txtName.setText(null);
				//txtPhoneNum.setText(null);
//				txtTime.setText(null);
                                ampm.setSelectedIndex(0);
                                times.setSelectedIndex(0);
				dateChooser.setDate(null);;
				numPeople.setSelectedIndex(0);
				JDuration.setSelectedIndex(0);
                                txtpnSpecialRequest.setText("Special request: ");
				
			}
		});
		btnCancel.setBounds(325, 350, 100, 23);
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
				customerGUICheckButton();
				
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
		btnExit.setBounds(580, 350, 120, 23);
		frmCustomer.getContentPane().add(btnExit);
		
		JButton btnNewButton = new JButton("Manage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// at this moment, the system should search the file from exist file and gives the information.
				CustomerManage.main(null);
				CustomerManage cm=new CustomerManage();
				cm.setUserName(userName);
				cm.setPhoneNum(phoneNum);
				frmCustomer.dispose();
			}
		});
		btnNewButton.setBounds(445, 350, 120, 23);
		frmCustomer.getContentPane().add(btnNewButton);
		
		txtpnSpecialRequest = new JTextPane();
		txtpnSpecialRequest.setText("Special request: ");
		txtpnSpecialRequest.setBounds(62, 234, 631, 76);
		frmCustomer.getContentPane().add(txtpnSpecialRequest);
		//chang user btn
		JButton btnChangeUser = new JButton("Change user");
		btnChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            
                            frmCustomer.dispose();
                            createLogin();
				
			}
		});
		btnChangeUser.setBounds(70, 350, 130, 23);
		frmCustomer.getContentPane().add(btnChangeUser);
		JComboBox comboBoxTime = new JComboBox();
		comboBoxTime.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxTime.setBounds(412, 157, 89, 20);
		frmCustomer.getContentPane().add(comboBoxTime);
		/**
		JRadioButton rdbtnAm = new JRadioButton("AM");
		rdbtnAm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		rdbtnAm.setBounds(507, 141, 46, 23);
		frmCustomer.getContentPane().add(rdbtnAm);
		
		JRadioButton rdbtnPm = new JRadioButton("PM");
		rdbtnPm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		rdbtnPm.setBounds(507, 160, 46, 23);
		frmCustomer.getContentPane().add(rdbtnPm);
                */
	}

	public void setUserName(String userName2) {
		// TODO Auto-generated method stub
		userName=userName2;
	}

	public void setPhoneNum(String phoneNum2) {
		// TODO Auto-generated method stub
		phoneNum=phoneNum2;
	}
       
     
        public void customerGUICheckButton()
        {//check if given reservation slot is available
            
        }
//         public static void addReservation(String name, String number,int custResNum,
        //Date date, int startTime, int duration, int tableNumber, String request) {
//      
//    }
//        	private JTextField txtName;
//	private JTextField txtPhoneNum;
//	private JTextField txtTime;
//	private static String userName;
//	private static String phoneNum;
//        private JTextPane txtpnSpecialRequest;
        public void customerGUISubmitButton()
        {//submit given reservation info
            //checkReservation();
            int timeNum=1;
            int tableNum=1;
            addReservation(txtName.getText(),txtPhoneNum.getText(),
                    dateChooser.getDateEditor().getDate(), timeNum,
                    Integer.parseInt(JDuration.getSelectedItem().toString()), tableNum,
                    txtpnSpecialRequest.getText());
            //put this into manage window as well
            //save to a file
            
        }
        public boolean isValidReservation()
        {
            return true;
        }
        

        
        
        

	
}

