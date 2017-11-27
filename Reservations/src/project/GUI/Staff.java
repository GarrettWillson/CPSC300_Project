package project.GUI;

import com.toedter.calendar.JDateChooser;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.Instant;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import project.DataStructures.DataLists;
import project.DataStructures.Reservation;
import project.FileIO.FileIO;
import project.FileIO.FileIOInterface;
import static project.GUI.CustomerGUI.createCustomerGUI;
import static project.GUI.Login.createLogin;
import project.Users.Employee;

public class Staff {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel myModel;
    private JDateChooser dateChooser;
    TableRowSorter<TableModel> sorter;

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
        frame.setResizable(false);
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
                    JOptionPane.showMessageDialog(null, "Please enter both an unused username and a password.");
                    return;
                } else {
                    if(DataLists.userNameTaken(addEmployee)) {
                        JOptionPane.showMessageDialog(null, "Username is already in use. Please enter a unique one.");
                        return;
                    } else if(!DataLists.isValidPassword(addEPassword)) {
                        JOptionPane.showMessageDialog(null, "Password is invalid. Please enter a stronger one.");
                        return;
                    }
                    Employee newE = new Employee(addEmployee, addEPassword, "A");
                    FileIOInterface.saveEmployee("A", newE);
                }
            }
        });
        JMenuItem mi2 = new JMenuItem("delete employee");
        mi2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String DeleteUser = JOptionPane.showInputDialog("enter the user name to be deleted:");
                //FileIOInterface.deleteEmployee(DeleteUser);
                //deleteEmployee() is not working.
                FileIO.deleteEmployee("A", DeleteUser);
            }
        });
        JMenuItem mi3 = new JMenuItem("diplay all employee");
        mi3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Employee> res = DataLists.getEmployees();
                String info= "";
                if(res.size()==0){
                   info= "no other employee yet.";
                   
                }else{
                    for(int i=0; i<res.size();i++){
                        info=info+"\r\n"+ "user name: "+res.get(i).getUserName()+
                                "  password: "+ res.get(i).getPassword();
                    }
                    JOptionPane.showMessageDialog(null,info,"All employee info", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
        });
        mi1.setActionCommand("New employee");
        mi2.setActionCommand("delete employee");
        mi3.setActionCommand("diplay all employee");
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);

        table = new JTable();
        Object[][] d = new Object[0][8];
        myModel = new DefaultTableModel(
                d,
                new String[]{
                    "Name", "Phone#", "#of People", "Date", "Time",
                    "Duration", "Table #", "Special request"
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
        
        table.setAutoCreateColumnsFromModel(false);
        sorter = new TableRowSorter<TableModel>(myModel);
        table.setRowSorter(sorter);

        JScrollPane j1;
        j1 = new JScrollPane();

        j1.setBounds(60, 139, 798, 495);
        j1.getViewport().add(table, null);
        frame.getContentPane().add(j1);

        dateChooser = new JDateChooser();
        dateChooser.getDateEditor().setEnabled(false);
        dateChooser.setBounds(120, 83, 124, 23);
        frame.getContentPane().add(dateChooser);

        table.getTableHeader().setReorderingAllowed(false);

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

//        JButton btnSearch = new JButton("Sort");
//        btnSearch.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                staffSortBut();
//            }
//        });
//        btnSearch.setBounds(458, 83, 89, 23);
//        frame.getContentPane().add(btnSearch);

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
        FileIOInterface.deleteReservation("A", myModel.getValueAt(row, 0).toString(),
        myModel.getValueAt(row, 1).toString(), myModel.getValueAt(row, 3).toString(),
        myModel.getValueAt(row, 4).toString(), myModel.getValueAt(row, 6).toString()
        );
        myModel.removeRow(row); 
    }
//    FileIOInterface.saveReservation("A", addReservation(txtName.getText()
    //,txtPhoneNum.getText(),
//                    dateChooser.getDateEditor().getDate(), 
    // (comboBoxTime.getSelectedItem().equals("pm")?12:0) + Integer.parseInt(times.getSelectedItem().toString()),
//                    Integer.parseInt(JDuration.getSelectedItem().toString().split(" ")[0]), 
    //    Integer.parseInt(JTable.getSelectedItem().toString().split(" ")[1]),
//                    txtpnSpecialRequest.getText()));

    public void staffSortBut()
    {
        //ask user how they want to sort
        //sort columns by date
       // myModel.set
        

    }

    public void staffClearBut() {
        //clears the reservatopms 
        //start or end before current time
        for (int i = 0; i < myModel.getRowCount();) {
            if (isReservationExpired(myModel.getValueAt(i, 3).toString(),
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

    private boolean isReservationExpired(String date, String startHour, String duration) {
        Date d = null;
        Date now = Date.from(Instant.now());
        try {
            d = FileIOInterface.dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        if (d.after(now)) {
            return false;
        }
        if (d.getYear() == now.getYear()
                && d.getMonth() == now.getMonth()
                && d.getDate() == now.getDate()) {
            return Integer.parseInt(startHour) + Integer.parseInt(duration) < now.getHours();
        }
        return true;
    }
}
