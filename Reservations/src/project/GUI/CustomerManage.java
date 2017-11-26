package project.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import project.DataStructures.DataLists;
import project.DataStructures.Reservation;
import project.FileIO.FileIOInterface;
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
    private DefaultTableModel model;

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
		Object[][] d = new Object[0][7];
                model = new DefaultTableModel(
			d,
			new String[] {
				"Name", "# of people", "Date", "Time", "Duration", "Table #", "special request"
			}
                        
		){@Override
                public boolean isCellEditable(int row, int column){return false;}};
                              
        Vector<String> vc = new Vector();
        List<Reservation> lst = DataLists.getReservationsForCustomer(userName, phoneNum);
        for(int i=0; i < lst.size(); i++){
            vc.add(lst.get(i).getCustomerName());
            vc.add("4");
            vc.add(FileIOInterface.dateFormat.format(lst.get(i).getReservationDate()));
            vc.add(String.valueOf(lst.get(i).getStartHour()));
            vc.add(String.valueOf(lst.get(i).getLengthOfReservation()));
            vc.add(String.valueOf(lst.get(i).getReservedTable()));
            vc.add(lst.get(i).getSpecialRequest());
            model.insertRow(0, vc);        
        }
        table.setModel(model);
	table.setBounds(76, 202, 714, 160);
	frame.getContentPane().add(table);
                
        JScrollPane j1;
        j1 = new JScrollPane();

        j1.setBounds(76, 202, 734, 180);
        j1.getViewport().add(table, null);
        frame.getContentPane().add(j1);
                
		
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

//        JButton btnSearch = new JButton("Search");
//        btnSearch.setBounds(375, 400, 89, 23);
//        frame.getContentPane().add(btnSearch);
//        btnSearch.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                CustomerManageSearchButton();
//            }
//        });

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

        //table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn());
        //deleteReservation(table.getSelectedRow());
        deleteReservation(table.getSelectedRow());
    }

//    public void CustomerManageSearchButton() {
//
//    }
    public void deleteReservation(int row) {//deletes a row fromt able
        //delete associated item in data structure
        //delete associated file 
        FileIOInterface.deleteReservation("A", table.getModel().getValueAt(row, 0).toString(),
        table.getModel().getValueAt(row, 1).toString(), table.getModel().getValueAt(row, 3).toString(),
        table.getModel().getValueAt(row, 4).toString(),
        table.getModel().getValueAt(row, 6).toString()
        );
        model.removeRow(row);
    }
    public void CustomerManageBackButton() {
        frame.dispose();
        createCustomerGUI();
    }
}
