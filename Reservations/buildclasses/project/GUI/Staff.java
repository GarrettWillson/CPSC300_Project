package project.GUI;

import com.toedter.calendar.JDateChooser;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import project.DataStructures.DataLists;
import static project.DataStructures.DataLists.addReservation;
import project.DataStructures.Reservation;
import project.FileIO.FileIOInterface;
import static project.GUI.CustomerGUI.createCustomerGUI;
import static project.GUI.Login.createLogin;
import project.Startup;
import project.Users.Employee;

public class Staff {

    private JFrame frame;

    private static String userName;
    private static String password;
    private JTable table;
    private DefaultTableModel myModel;
    private JDateChooser dateChooser;

    /**
     * Launch the application. add a button to modify a reservation
     */
    public static void createStaff() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    Staff window = new Staff();
                    //UIManager.setLookAndFeel(new LookAndFeel(frame));  
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
    public Staff() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 912, 701);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblHello = new JLabel("Hello");
        lblHello.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblHello.setBounds(60, 11, 78, 47);
        frame.getContentPane().add(lblHello);

        //menu bar
        JMenuBar Jmb = new JMenuBar();
        frame.setJMenuBar(Jmb);

        JMenu m1 = new JMenu("File");
        Jmb.add(m1);

        JMenuItem mi1 = new JMenuItem("New employee");
        mi1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String addEmployee = JOptionPane.showInputDialog("Enter the user name:");
                String addEPassword = JOptionPane.showInputDialog("Enter the password:");
                if (addEmployee.isEmpty() || addEPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Wrong enter! Please enter again.");
                } else {

                    Employee newE = new Employee(addEmployee, addEPassword, Startup.restaurantName);
                    FileIOInterface.saveEmployee(Startup.restaurantName, newE);
                }
            }
        });
        JMenuItem mi2 = new JMenuItem("delete employee");
        mi2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String DeleteUser = JOptionPane.showInputDialog("enter the user name to be deleted:");
                FileIOInterface.deleteEmployee(DeleteUser);
            }
        });
        mi1.setActionCommand("New employee");
        m1.add(mi1);
        m1.add(mi2);

        table = new JTable();
        Object[][] d = new Object[0][8];
        myModel = new DefaultTableModel(
                d,
                new String[]{
                    "Name", "Phone#", "#of People", "Date", "Time",
                    "Duration", "#of Table", "Special request"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Vector<String> rowData;
        List<Reservation> list = DataLists.getReservations();
        for (int i = 0; i < list.size(); i++) {
            rowData = new Vector<String>();
            rowData.add(list.get(i).getCustomerName());
            rowData.add(list.get(i).getCustomerNumber());
            rowData.add("4");
            rowData.add(FileIOInterface.dateFormat.format(list.get(i).getReservationDate()));
            rowData.add(String.valueOf(list.get(i).getStartHour()));
            rowData.add(String.valueOf(list.get(i).getLengthOfReservation()));
            rowData.add(String.valueOf(list.get(i).getReservedTable().getTableNumber()));
            rowData.add(list.get(i).getSpecialRequest());
            myModel.insertRow(i, rowData);
        }
        table.setModel(myModel);
        table.setBounds(60, 139, 778, 475);
        frame.getContentPane().add(table);

        JScrollPane j1;
        j1 = new JScrollPane();

        j1.setBounds(60, 139, 798, 495);
        j1.getViewport().add(table, null);
        frame.getContentPane().add(j1);

        dateChooser = new JDateChooser();
        dateChooser.getDateEditor().setEnabled(false);
        dateChooser.setBounds(120, 83, 124, 23);
        frame.getContentPane().add(dateChooser);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(70, 83, 46, 23);
        frame.getContentPane().add(lblDate);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                staffAddBut();
            }
        });
        btnAdd.setBounds(260, 83, 89, 23);
        frame.getContentPane().add(btnAdd);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                staffDelBut();
            }
        });
        btnDelete.setBounds(359, 83, 89, 23);
        frame.getContentPane().add(btnDelete);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                staffSearchBut();
            }
        });
        btnSearch.setBounds(458, 83, 89, 23);
        frame.getContentPane().add(btnSearch);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 56, 876, 2);
        frame.getContentPane().add(separator);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                staffBackBut();
            }
        });
        btnExit.setBounds(700, 83, 89, 23);
        frame.getContentPane().add(btnExit);

        JButton btnClear = new JButton("Clear Expired");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                staffClearBut();
            }
        });
        btnClear.setBounds(557, 83, 130, 23);
        frame.getContentPane().add(btnClear);
    }

    public void setUserName(String userName2) {
        // TODO Auto-generated method stub
        userName = userName2;
    }

    public void setPassword(String p) {
        // TODO Auto-generated method stub
        password = p;
    }

    public void staffAddBut() {
        frame.dispose();
        createCustomerGUI();
    }

    public void staffDelBut() {
        //delete row from table
        //delete reservation file
        //myModel.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
        deleteReservation(table.getSelectedRow());
    }

    public void deleteReservation(int row) {//deletes a row fromt able
        //delete associated item in data structure
        //delete associated file 

        myModel.removeRow(row);
        FileIOInterface.deleteReservation(Startup.restaurantName,myModel.getValueAt(row, 0).toString(),
        myModel.getValueAt(row, 1).toString(),myModel.getValueAt(row, 2).toString(),
        myModel.getValueAt(row, 3).toString(),myModel.getValueAt(row, 4).toString(),
        myModel.getValueAt(row, 5).toString(),myModel.getValueAt(row, 6).toString(),
        myModel.getValueAt(row, 7).toString()
        );
        
    }
//    FileIOInterface.saveReservation(Startup.restaurantName, addReservation(txtName.getText()
    //,txtPhoneNum.getText(),
//                    dateChooser.getDateEditor().getDate(), 
    // (comboBoxTime.getSelectedItem().equals("pm")?12:0) + Integer.parseInt(times.getSelectedItem().toString()),
//                    Integer.parseInt(JDuration.getSelectedItem().toString().split(" ")[0]), 
    //    Integer.parseInt(JTable.getSelectedItem().toString().split(" ")[1]),
//                    txtpnSpecialRequest.getText()));

    public void staffSearchBut() {

    }

    public void staffClearBut() {
        //clears the reservatopms 
        //start or end before current time
        for (int i = 0; i < myModel.getRowCount();) {
            if (isReservationExipred(myModel.getValueAt(i, 3).toString(),
                    myModel.getValueAt(i, 4).toString(),
                    myModel.getValueAt(i, 5).toString())) {
                deleteReservation(i);
            } else {
                i++;
            }
        }
    }

    public void staffBackBut() {
        this.frame.dispose();
        createLogin();
    }
    //clear expired should remove from table as well as call methods to delete\
    //files themselves

    private boolean isReservationExipred(String date, String startHour, String duration) {
        Date d = null;
        Date now = new Date(System.nanoTime());
        try {
            d = FileIOInterface.dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        if (now.before(d)) {
            return false;
        }
        if (now.getYear() == d.getYear()
                && now.getMonth() == d.getMonth()
                && now.getDate() == d.getDate()) {
            return now.getHours() > Integer.parseInt(startHour) + Integer.parseInt(duration);
        }
        return true;
    }
}
