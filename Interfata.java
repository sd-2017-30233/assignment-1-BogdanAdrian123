package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Interfata {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfata window = new Interfata();
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
	public Interfata() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 197);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton administratorBtn = new JButton("ADMINISTRATOR");
		administratorBtn.setForeground(Color.BLUE);
		administratorBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		administratorBtn.setBounds(0, 0, 215, 159);
		panel.add(administratorBtn);
		
		JButton userBtn = new JButton("USER");
		userBtn.setForeground(Color.BLUE);
		userBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		userBtn.setBounds(213, 0, 215, 159);
		panel.add(userBtn);
		
	
		
	administratorBtn.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        
        	Login login=new Login();
        	login.frame.setVisible(true);
        }
        		
});
	
    userBtn.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        
        	Login login=new Login();
        	login.frame.setVisible(true);
        }
        		
});
	}
}
