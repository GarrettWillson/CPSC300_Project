/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.GUI;

/**
 *
 * @author qiu
 */
import com.toedter.calendar.JDateChooser;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import project.DataStructures.DataLists;
import project.DataStructures.Table;


public class StaffAddReservation {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPhoneNum;
        private JComboBox JDuration;
        private JComboBox JTable;

    /**
     * Launch the application.
     */
    public static void createStaffAddReservation() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StaffAddReservation window = new StaffAddReservation();
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
    public StaffAddReservation() {
        initialize();
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 662, 294);
                frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(12, 12, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhoneNum = new JLabel("Phone num:");
		lblPhoneNum.setBounds(12, 39, 97, 15);
		frame.getContentPane().add(lblPhoneNum);
		
		txtName = new JTextField();
		txtName.setBounds(128, 10, 114, 19);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setBounds(128, 37, 114, 19);
		frame.getContentPane().add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(335, 12, 96, 19);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(260, 12, 70, 15);
		frame.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(260, 39, 70, 15);
		frame.getContentPane().add(lblTime);
		
		JComboBox comboBoxTime = new JComboBox();
		comboBoxTime.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "0"}));
		comboBoxTime.setBounds(335, 34, 96, 20);
		frame.getContentPane().add(comboBoxTime);
		
		JLabel lblOfPeople = new JLabel("# of people:");
		lblOfPeople.setBounds(22, 66, 100, 15);
		frame.getContentPane().add(lblOfPeople);
                
                JComboBox numPeople= new JComboBox();
                numPeople.setModel(new DefaultComboBoxModel(new String[]
                {"","2 People", "3 People", "4 People", "5 People", "6 People", 
                    "7 People", "8 People", "9 People", "10 People", "11 People", 
                    "12 People", "13 People", "14 People", "15 People", "16 People", 
                    "17 People", "18 People", "19 People", "20 People"}));
		numPeople.setBounds(128, 66, 114, 20);
		frame.getContentPane().add(numPeople);
                
                JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setBounds(250, 66, 1000, 14);
		frame.getContentPane().add(lblDuration);
                
                JDuration = new JComboBox();
		JDuration.setModel(new DefaultComboBoxModel(new String[] 
                {"","1 hour", "2 hours", "3 hours", "4 hours", "5 hours",
                    "6 hours", "7 hours", "8 hours"}));
		JDuration.setBounds(335, 66, 96, 20);
		frame.getContentPane().add(JDuration);
                
                JLabel lblTable= new JLabel("Choose Table:");
                lblTable.setBounds(440, 12, 1000, 14);
                frame.getContentPane().add(lblTable);
                
                List<Table> tables = DataLists.getTables();
                tables.add(0,null);
                JTable= new JComboBox();
                JTable.setModel(new DefaultComboBoxModel(new Vector<>(tables)));
                JTable.setBounds(550,12,80,20);
                frame.getContentPane().add(JTable);
	}
}
