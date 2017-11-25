package project.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static project.GUI.CustomerGUI.createCustomerGUI;

public class CustomerManage {
    /*
     user name and phone number should just be displayed, not editable
     table entries should not be directly editable via text, add modify entry button
     to change row entries
    
     phone number shouldnt be password field, maybe add another text
     field ontop of the password field and make the radio buttons
     switch between which one is displayed
    
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
    public static void createCustomerManage() {
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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblReservationManagement = new JLabel("Reservation management");
        lblReservationManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblReservationManagement.setBounds(235, 27, 300, 48);
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

        table.setEnabled(true);
        table.setModel(new DefaultTableModel(
                new Object[][]{
                    {"Name", "# of people", "Date", "Time", "Duration", "# of table", "special request"},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},},
                new String[]{
                    "Name", "# of people", "Date", "Time", "Duration", "# of table", "special request"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
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
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerManageAddButton();
            }
        });

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(264, 400, 89, 23);
        frame.getContentPane().add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerManageDeleteButton();
            }
        });

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(375, 400, 89, 23);
        frame.getContentPane().add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerManageSearchButton();
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(484, 400, 89, 23);
        frame.getContentPane().add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerManageBackButton();
            }
        });
    }

    public void setUserName(String userName2) {
        // TODO Auto-generated method stub
        userName = userName2;
    }

    public void setPhoneNum(String phoneNum2) {
        // TODO Auto-generated method stub
        phoneNum = phoneNum2;
    }

    public void CustomerManageAddButton() {
        frame.dispose();
        createCustomerGUI();

    }

    public void CustomerManageDeleteButton() {//deletes a selected reservation from the users

    }

    public void CustomerManageSearchButton() {

    }

    public void CustomerManageBackButton() {
        frame.dispose();
        createCustomerGUI();
    }
}
