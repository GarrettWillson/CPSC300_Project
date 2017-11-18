package project.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.JTextPane;

public class TimeTable {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnTable1 = new JTextPane();
		txtpnTable1.setText("Table 1");
		txtpnTable1.setBounds(70, 54, 130, 106);
		frame.getContentPane().add(txtpnTable1);
		
		JTextPane txtpnTable2 = new JTextPane();
		txtpnTable2.setText("Table 2");
		txtpnTable2.setBounds(210, 54, 130, 106);
		frame.getContentPane().add(txtpnTable2);
		
		JTextPane txtpnTable3 = new JTextPane();
		txtpnTable3.setText("Table 3");
		txtpnTable3.setBounds(350, 54, 130, 106);
		frame.getContentPane().add(txtpnTable3);
		
		JTextPane txtpnTable4 = new JTextPane();
		txtpnTable4.setText("Table 4");
		txtpnTable4.setBounds(70, 240, 130, 106);
		frame.getContentPane().add(txtpnTable4);
		
		JTextPane txtpnTable5 = new JTextPane();
		txtpnTable5.setText("Table 5");
		txtpnTable5.setBounds(210, 240, 130, 106);
		frame.getContentPane().add(txtpnTable5);
		
		JTextPane txtpnTable6 = new JTextPane();
		txtpnTable6.setText("Table 6");
		txtpnTable6.setBounds(350, 240, 130, 106);
		frame.getContentPane().add(txtpnTable6);
		
		JButton btnNewButton = new JButton("More info");
                btnNewButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String info="example: 3pm-4pm"+"\r\n"+"                 5pm-6pm";
                        //info should be the information of time table depends on # of table.
                        JOptionPane.showMessageDialog(null,info,"More info", JOptionPane.PLAIN_MESSAGE);
                        
                    }
                
                });
                
		btnNewButton.setBounds(70, 171, 130, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("More info");
                btnNewButton_1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String info="";
                        //info should be the information of time table depends on # of table.
                        JOptionPane.showMessageDialog(null,info,"More info", JOptionPane.PLAIN_MESSAGE);
                    }
                
                });
		btnNewButton_1.setBounds(210, 171, 130, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("More info");
                btnNewButton_2.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String info="";
                        //info should be the information of time table depends on # of table.
                        JOptionPane.showMessageDialog(null,info,"More info", JOptionPane.PLAIN_MESSAGE);
                    }
                
                });
		btnNewButton_2.setBounds(350, 171, 130, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("More info");
                btnNewButton_3.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String info="";
                        //info should be the information of time table depends on # of table.
                        JOptionPane.showMessageDialog(null,info,"More info", JOptionPane.PLAIN_MESSAGE);
                    }
                
                });
		btnNewButton_3.setBounds(70, 357, 130, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("More info");
                btnNewButton_4.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String info="";
                        //info should be the information of time table depends on # of table.
                        JOptionPane.showMessageDialog(null,info,"More info", JOptionPane.PLAIN_MESSAGE);
                    }
                
                });
		btnNewButton_4.setBounds(210, 357, 130, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("More info");
                btnNewButton_5.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String info="";
                        //info should be the information of time table depends on # of table.
                        JOptionPane.showMessageDialog(null,info,"More info", JOptionPane.PLAIN_MESSAGE);
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
