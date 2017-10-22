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

public class CustomerGUI {

    private JFrame frmCustomer;
    private JTextField txtName;
    private JTextField txtPhoneNum;
    private JTextField textField;

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
        frmCustomer.setBounds(100, 100, 745, 504);
        frmCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCustomer.getContentPane().setLayout(null);

        JLabel lblCustomer = new JLabel("Customer");
        lblCustomer.setBounds(200, 11, 300, 41);
        lblCustomer.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 45));
        frmCustomer.getContentPane().add(lblCustomer);

        JSeparator separator = new JSeparator();
        separator.setBounds(27, 73, 656, 2);
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
        separator_2.setBounds(27, 309, 656, 2);
        frmCustomer.getContentPane().add(separator_2);

        JComboBox numPeople = new JComboBox();
        numPeople.setModel(new DefaultComboBoxModel(new String[]{"2 People", "3 People", "4 People", "5 People", "6 People", "7 People", "8 People", "9 People", "10 People", "11 People", "12 People", "13 People", "14 People", "15 People", "16 People", "17 People", "18 People", "19 People", "20 People"}));
        numPeople.setBounds(180, 203, 118, 20);
        frmCustomer.getContentPane().add(numPeople);

        JLabel lblnumPeople = new JLabel("No. of seat:");
        lblnumPeople.setBounds(73, 206, 64, 14);
        frmCustomer.getContentPane().add(lblnumPeople);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(356, 117, 46, 14);
        frmCustomer.getContentPane().add(lblDate);

        JRadioButton rdbtnDurition3 = new JRadioButton("3 hours");
        rdbtnDurition3.setBounds(353, 202, 109, 23);
        frmCustomer.getContentPane().add(rdbtnDurition3);

        JRadioButton rdbtnHours = new JRadioButton("4 hours");
        rdbtnHours.setBounds(464, 202, 109, 23);
        frmCustomer.getContentPane().add(rdbtnHours);

        JLabel lblTime = new JLabel("Time:");
        lblTime.setBounds(356, 160, 46, 14);
        frmCustomer.getContentPane().add(lblTime);

        textField = new JTextField();
        textField.setBounds(412, 157, 124, 20);
        frmCustomer.getContentPane().add(textField);
        textField.setColumns(10);

        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(10, 11, 87, 16);
        frmCustomer.getContentPane().add(toolBar);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(412, 114, 124, 20);
        frmCustomer.getContentPane().add(dateChooser);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(209, 248, 89, 23);
        frmCustomer.getContentPane().add(btnSubmit);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(356, 248, 89, 23);
        frmCustomer.getContentPane().add(btnCancel);
    }

    public void customerReservationSubmitButton() {

    }

    public void customerReservationCancelButton() {
    }

}
