package project.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Staff {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        createStaff();
    }
    
    public static void createStaff() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Staff window = new Staff();
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
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void staffLoginLoginButton() {

    }

    public void staffLoginCancelButton() {
    }

}
