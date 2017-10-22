package cpsc300;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		txtpnTable1.setBounds(76, 54, 85, 106);
		frame.getContentPane().add(txtpnTable1);
		
		JTextPane txtpnTable2 = new JTextPane();
		txtpnTable2.setText("Table 2");
		txtpnTable2.setBounds(171, 54, 85, 106);
		frame.getContentPane().add(txtpnTable2);
		
		JTextPane txtpnTable3 = new JTextPane();
		txtpnTable3.setText("Table 3");
		txtpnTable3.setBounds(266, 54, 85, 106);
		frame.getContentPane().add(txtpnTable3);
		
		JTextPane txtpnTable4 = new JTextPane();
		txtpnTable4.setText("Table 4");
		txtpnTable4.setBounds(76, 240, 85, 106);
		frame.getContentPane().add(txtpnTable4);
		
		JTextPane txtpnTable5 = new JTextPane();
		txtpnTable5.setText("Table 5");
		txtpnTable5.setBounds(171, 240, 85, 106);
		frame.getContentPane().add(txtpnTable5);
		
		JTextPane txtpnTable6 = new JTextPane();
		txtpnTable6.setText("Table 6");
		txtpnTable6.setBounds(266, 240, 85, 106);
		frame.getContentPane().add(txtpnTable6);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(72, 171, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(167, 171, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(266, 171, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(72, 357, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(167, 357, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(266, 357, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		btnExit.setBounds(418, 357, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}
