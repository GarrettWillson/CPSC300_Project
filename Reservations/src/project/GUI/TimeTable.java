package project.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import project.DataStructures.DataLists;
import project.DataStructures.Reservation;
import project.DataStructures.Table;

public class TimeTable {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void createTimeTable() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TimeTable window = new TimeTable();
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
    public TimeTable() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 637, 471);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTextPane txtpnTable1 = new JTextPane();
        //here can use DataLists.getFoorPlan().getTable get #of seats about the table,
        //right now only use deafult value.
        List<Table> tables = DataLists.getTables();

        //String tableNum="";
        //tableNum= String.valueOf(tables.get(0).getTableNumber());
        txtpnTable1.setText("Table 1" + "\r\n" + "has " + String.valueOf(tables.get(0).getTableNumber()) + " seats");

        txtpnTable1.setBounds(70, 54, 130, 106);
        frame.getContentPane().add(txtpnTable1);

        JTextPane txtpnTable2 = new JTextPane();
        //tableNum= String.valueOf(tables.get(1).getTableNumber());
        txtpnTable2.setText("Table 2" + "\r\n" + "has " + String.valueOf(tables.get(1).getNumberOfSeats()) + " seats");
        txtpnTable2.setBounds(210, 54, 130, 106);
        frame.getContentPane().add(txtpnTable2);

        JTextPane txtpnTable3 = new JTextPane();
        //tableNum= String.valueOf(tables.get(2).getTableNumber());
        txtpnTable3.setText("Table 3" + "\r\n" + "has " + String.valueOf(tables.get(2).getNumberOfSeats()) + " seats");
        txtpnTable3.setBounds(350, 54, 130, 106);
        frame.getContentPane().add(txtpnTable3);

        JTextPane txtpnTable4 = new JTextPane();
        //tableNum= String.valueOf(tables.get(3).getTableNumber());
        txtpnTable4.setText("Table 4" + "\r\n" + "has " + String.valueOf(tables.get(3).getNumberOfSeats()) + " seats");
        txtpnTable4.setBounds(70, 240, 130, 106);
        frame.getContentPane().add(txtpnTable4);

        JTextPane txtpnTable5 = new JTextPane();
        //tableNum= String.valueOf(tables.get(4).getTableNumber());
        txtpnTable5.setText("Table 5" + "\r\n" + "has " + String.valueOf(tables.get(4).getNumberOfSeats()) + " seats");
        txtpnTable5.setBounds(210, 240, 130, 106);
        frame.getContentPane().add(txtpnTable5);

        JTextPane txtpnTable6 = new JTextPane();
        //tableNum= String.valueOf(tables.get(5).getTableNumber());
        txtpnTable6.setText("Table 6" + "\r\n" + "has " + String.valueOf(tables.get(5).getNumberOfSeats()) + " seats");
        txtpnTable6.setBounds(350, 240, 130, 106);
        frame.getContentPane().add(txtpnTable6);

        //DataLists.getReservationsForTable(1);
        JButton btnNewButton = new JButton("More info");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Reservation> res = DataLists.getReservationsForTable(1);

                String info = "info: ";
                if (res.size() == 0) {
                    info = info + "\r\n" + "no reseration yet! ";
                }
                for (int i = 0; i < res.size(); i++) {
                    //here teh Reservation doesn't finished, once it finished, here will get
                    // the reservation arrival time and leave time.
                    info = info + "\r\n" + new SimpleDateFormat("dd MMM YYYY").format(res.get(i).getReservationDate()) + " "
                            + String.valueOf(res.get(i).getStartHour()) + "-" + String.valueOf(res.get(i).getStartHour() + res.get(i).getLengthOfReservation());

                }
                //info should be the information of time table depends on # of table.
                JOptionPane.showMessageDialog(null, info, "More info", JOptionPane.PLAIN_MESSAGE);

            }

        });

        btnNewButton.setBounds(70, 171, 130, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("More info");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Reservation> res = DataLists.getReservationsForTable(2);
                String info = "info:";
                if (res.size() == 0) {
                    info = info + "\r\n" + "no reseration yet! ";
                }
                for (int i = 0; i < res.size(); i++) {
                    //here teh Reservation doesn't finished, once it finished, here will get
                    // the reservation arrival time and leave time.
                    info = info + "\r\n" + new SimpleDateFormat("dd MMM YYYY").format(res.get(i).getReservationDate()) + " "
                            + String.valueOf(res.get(i).getStartHour()) + "-" + String.valueOf(res.get(i).getStartHour() + res.get(i).getLengthOfReservation());

                }
                //info should be the information of time table depends on # of table.
                JOptionPane.showMessageDialog(null, info, "More info", JOptionPane.PLAIN_MESSAGE);
            }

        });
        btnNewButton_1.setBounds(210, 171, 130, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("More info");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Reservation> res = DataLists.getReservationsForTable(3);
                String info = "info:";
                if (res.size() == 0) {
                    info = info + "\r\n" + "no reseration yet! ";
                }
                for (int i = 0; i < res.size(); i++) {
                    //here teh Reservation doesn't finished, once it finished, here will get
                    // the reservation arrival time and leave time.
                    info = info + "\r\n" + new SimpleDateFormat("dd MMM YYYY").format(res.get(i).getReservationDate()) + " "
                            + String.valueOf(res.get(i).getStartHour()) + "-" + String.valueOf(res.get(i).getStartHour() + res.get(i).getLengthOfReservation());

                }
                //info should be the information of time table depends on # of table.
                JOptionPane.showMessageDialog(null, info, "More info", JOptionPane.PLAIN_MESSAGE);
            }

        });
        btnNewButton_2.setBounds(350, 171, 130, 23);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("More info");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Reservation> res = DataLists.getReservationsForTable(4);
                String info = "info:";
                if (res.size() == 0) {
                    info = info + "\r\n" + "no reseration yet! ";
                }
                for (int i = 0; i < res.size(); i++) {
                    //here teh Reservation doesn't finished, once it finished, here will get
                    // the reservation arrival time and leave time.
                    info = info + "\r\n" + new SimpleDateFormat("dd MMM YYYY").format(res.get(i).getReservationDate()) + " "
                            + String.valueOf(res.get(i).getStartHour()) + "-" + String.valueOf(res.get(i).getStartHour() + res.get(i).getLengthOfReservation());

                }
                //info should be the information of time table depends on # of table.
                JOptionPane.showMessageDialog(null, info, "More info", JOptionPane.PLAIN_MESSAGE);
            }

        });
        btnNewButton_3.setBounds(70, 357, 130, 23);
        frame.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("More info");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Reservation> res = DataLists.getReservationsForTable(5);
                String info = "info:";
                if (res.size() == 0) {
                    info = info + "\r\n" + "no reseration yet! ";
                }
                for (int i = 0; i < res.size(); i++) {
                    //here teh Reservation doesn't finished, once it finished, here will get
                    // the reservation arrival time and leave time.
                    info = info + "\r\n" + new SimpleDateFormat("dd MMM YYYY").format(res.get(i).getReservationDate()) + " "
                            + String.valueOf(res.get(i).getStartHour()) + "-" + String.valueOf(res.get(i).getStartHour() + res.get(i).getLengthOfReservation());

                }
                //info should be the information of time table depends on # of table.
                JOptionPane.showMessageDialog(null, info, "More info", JOptionPane.PLAIN_MESSAGE);
            }

        });
        btnNewButton_4.setBounds(210, 357, 130, 23);
        frame.getContentPane().add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("More info");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Reservation> res = DataLists.getReservationsForTable(6);
                String info = "info:";
                if (res.size() == 0) {
                    info = info + "\r\n" + "no reseration yet! ";
                }
                for (int i = 0; i < res.size(); i++) {
                    //here teh Reservation doesn't finished, once it finished, here will get
                    // the reservation arrival time and leave time.
                    info = info + "\r\n" + new SimpleDateFormat("dd MMM YYYY").format(res.get(i).getReservationDate()) + " "
                            + String.valueOf(res.get(i).getStartHour()) + "-" + String.valueOf(res.get(i).getStartHour() + res.get(i).getLengthOfReservation());

                }
                //info should be the information of time table depends on # of table.
                JOptionPane.showMessageDialog(null, info, "More info", JOptionPane.PLAIN_MESSAGE);
            }

        });
        btnNewButton_5.setBounds(350, 357, 130, 23);
        frame.getContentPane().add(btnNewButton_5);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
            }
        });
        btnExit.setBounds(500, 357, 89, 23);
        frame.getContentPane().add(btnExit);
    }
}
