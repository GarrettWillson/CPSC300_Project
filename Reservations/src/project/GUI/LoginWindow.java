/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginWindow {

    private JFrame frame;
    private JPasswordField textPassword;
    private JTextField textName;
 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginWindow window = new LoginWindow();
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
    public LoginWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        frame.setBounds(100, 100, 542, 361);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblLog = new JLabel("Login");
        lblLog.setFont(new Font("Segoe UI Black", Font.PLAIN, 26));
        lblLog.setBounds(247, 30, 103, 36);
        frame.getContentPane().add(lblLog);

        JLabel lblUsername = new JLabel("Name:");
        lblUsername.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
        lblUsername.setBounds(131, 124, 77, 14);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
        lblPassword.setBounds(113, 187, 95, 14);
        frame.getContentPane().add(lblPassword);

        textPassword = new JPasswordField();
        textPassword.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        textPassword.setBounds(246, 184, 147, 20);
        frame.getContentPane().add(textPassword);

        textName = new JTextField();
        textName.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        textName.setBounds(246, 122, 147, 20);
        frame.getContentPane().add(textName);
        textName.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String password = textPassword.getText();
                String username = textName.getText();

				//this part check the user name and the password default name "boss"
                // default password "123456"
                if (password.contains("123456") && username.contains("boss")) {

                    textPassword.setText(null);
                    textName.setText(null);

                    //staff info = new staff();
                    Staff.main(null);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid name or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnLogin.setBounds(113, 246, 89, 23);
        frame.getContentPane().add(btnLogin);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textName.setText(null);
                textPassword.setText(null);
            }
        });
        btnReset.setBounds(241, 246, 89, 23);
        frame.getContentPane().add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("EXIT");
                
                loginWindowExitButton(frame);

            }
        });
        btnExit.setBounds(366, 246, 89, 23);
        frame.getContentPane().add(btnExit);

        JSeparator separator = new JSeparator();
        separator.setBounds(45, 225, 544, 2);
        frame.getContentPane().add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(45, 77, 544, 2);
        frame.getContentPane().add(separator_1);
    }

    ////______________________________________
    ////button functions do not Change!!!!
    //           Garrett's part
    ////_____________________________________
    
  

    public void loginWindowLoginButton() {
        //match given credentials to our list of acceptable credentials
        //if not matching, tell user, return to login

    }

    public void loginWindowResetButton() {

    }

  

    public void loginWindowExitButton(JFrame frame) {
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }

    }

}


