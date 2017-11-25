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
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class StaffAddReservation {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPhoneNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		comboBoxTime.setBounds(335, 34, 96, 24);
		frame.getContentPane().add(comboBoxTime);
		
		JLabel lblOfPeople = new JLabel("# of people:");
		lblOfPeople.setBounds(22, 66, 100, 15);
		frame.getContentPane().add(lblOfPeople);
	}
}
