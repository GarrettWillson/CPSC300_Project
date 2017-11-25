package project.GUI;

import com.toedter.calendar.JDateChooser;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import project.DataStructures.DataLists;
import static project.DataStructures.DataLists.addReservation;
import project.DataStructures.Table;
import project.FileIO.FileIOInterface;
import static project.GUI.Login.createLogin;
import static project.GUI.Staff.createStaff;

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
        private JComboBox JTable;
        private JComboBox ampm;
        private JComboBox times;
        private JComboBox numPeople;
	private JComboBox comboBoxTime;
        
	
	/**
	 * Launch the application.
	 */
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
		txtPhoneNum.setText(phoneNum);
		txtPhoneNum.setBounds(180, 157, 118, 20);
		frmCustomer.getContentPane().add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		//txtPhoneNum.setText(cl.getPhoneNum());
		
                canChangeUserInfo();
                
		//JDateChooser dateChooser= new JDateChooser();
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 222, 656, -6);
		frmCustomer.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(27, 330, 693, 2);
		frmCustomer.getContentPane().add(separator_2);
		
		numPeople = new JComboBox();
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
		
                
                times = new JComboBox();
		times.setModel(new DefaultComboBoxModel(new String[] 
                {"","1","2","3","4","5","6"
                ,"7" ,"8","9","10","11","12",}));
		times.setBounds(412, 157, 64, 20);
		frmCustomer.getContentPane().add(times);
                
                ampm = new JComboBox();
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
				customerGUISubmitButton();
			}
		});
		btnSubmit.setBounds(220, 350, 89, 23);
		frmCustomer.getContentPane().add(btnSubmit);
                
                List<Table> tables = DataLists.getTables();
                tables.add(0,null);
                JTable= new JComboBox();
                JTable.setModel(new DefaultComboBoxModel(new Vector<>(tables)));
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
                                JTable.setSelectedIndex(0);
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
				TimeTable.createTimeTable();
				
				
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
		
		
		
		JButton btnExit = new JButton("Back");
		//btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                if(Login.isEmployee)
                                {
                                    frmCustomer.dispose();
                                    createStaff();
                                }
                                else
                                {
                                   frmCustomer.dispose(); 
                                   createLogin();
                                }
                                
			}
		});
		btnExit.setBounds(580, 350, 120, 23);
		frmCustomer.getContentPane().add(btnExit);
		
		JButton btnNewButton = new JButton("Manage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// at this moment, the system should search the file from exist file and gives the information.
				CustomerManage.createCustomerManage();
				CustomerManage cm=new CustomerManage();
				cm.setUserName(userName);
				cm.setPhoneNum(phoneNum);
				frmCustomer.dispose();
			}
		});
		btnNewButton.setBounds(445, 350, 120, 23);
		frmCustomer.getContentPane().add(btnNewButton);
                
                JLabel lblSpecialRequest= new JLabel("Special requese:");
                lblSpecialRequest.setBounds(52, 228, 130, 20);
                
                frmCustomer.getContentPane().add(lblSpecialRequest);
                
		
		txtpnSpecialRequest = new JTextPane();
		txtpnSpecialRequest.setText("SR: ");
		txtpnSpecialRequest.setBounds(62, 248, 631, 60);
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
		comboBoxTime = new JComboBox();
		comboBoxTime.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxTime.setBounds(412, 157, 89, 20);
		frmCustomer.getContentPane().add(comboBoxTime);
		
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
           //cgeckReservation();
        if(checkSubmitCanRun())
        {
            JOptionPane.showMessageDialog(null, "Is available!", "Ahhh", JOptionPane.INFORMATION_MESSAGE);
        }
//        else
//        {
//            JOptionPane.showMessageDialog(null, "Have a conflicted date or time !", "error", JOptionPane.INFORMATION_MESSAGE);
//            
//        }
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
            //check that fields havent been left blank
            int newtime=Integer.parseInt(times.getSelectedItem().toString());
            if(comboBoxTime.getSelectedIndex()==0)
            {
                newtime+=12;
            }
            
           
            //(comboBoxTime.getSelectedIndex()==1?12:0) + Integer.parseInt(times.getSelectedItem().toString())
             if(checkSubmitCanRun())
            {
                    FileIOInterface.saveReservation("A", addReservation(txtName.getText(),txtPhoneNum.getText(),
                    dateChooser.getDateEditor().getDate(),newtime ,
                    Integer.parseInt(JDuration.getSelectedItem().toString().split(" ")[0]), Integer.parseInt(JTable.getSelectedItem().toString().split(" ")[1]),
                    txtpnSpecialRequest.getText()));
                    //JOptionPane.showMessageDialog(null, "Your reservation has submited successfully!", ": )", JOptionPane.INFORMATION_MESSAGE);
            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "You have left an entry blank!", "Unfinished reservation", JOptionPane.INFORMATION_MESSAGE);
//            }
            //put this into manage window as well
            //save to a file
            
        }
        public boolean checkSubmitCanRun()
        {
//            int newtime=Integer.parseInt(times.getSelectedItem().toString());
//            if(ampm.getSelectedIndex()!=0)
//            {
//             newtime+=12;   
//            }
//               
            
            if(!noneLeftBlank())
            {
                JOptionPane.showMessageDialog(null, "You have left an entry blank!", "Unfinished reservation", JOptionPane.INFORMATION_MESSAGE);

            }
            else if (!DataLists.hasTimeConflict(dateChooser.getDateEditor().getDate(),
                    (comboBoxTime.getSelectedItem().equals("pm")?12:0)+ Integer.parseInt(times.getSelectedItem().toString()),
                    Integer.parseInt(JDuration.getSelectedItem().toString().split(" ")[0]),
                    Integer.parseInt(JTable.getSelectedItem().toString().split(" ")[1])))
            {
//                JOptionPane.showMessageDialog(null, "Is available!", "Ahhh", JOptionPane.INFORMATION_MESSAGE); 
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Have a conflicted date or time !", "error", JOptionPane.INFORMATION_MESSAGE);
            }
            
            return false;
            
        }  
           
//        public boolean isValidReservation()
//        {
//            //this should be changed
//            return true;
//        }
        public boolean noneLeftBlank()
        {//checks if any of the fields have been left empty
            if(JTable.getSelectedItem() !=null
                    && times.getSelectedIndex() != 0
                    && dateChooser.getDate() != null
                    && numPeople.getSelectedIndex() != 0
                    && JDuration.getSelectedIndex() != 0)
                return true; 
            
           return false;
        }
        public void canChangeUserInfo()
        {//allows user name and phone number to be changed only by employee
            txtName.setEditable(Login.isEmployee);
            txtPhoneNum.setEditable(Login.isEmployee);
        }
}
