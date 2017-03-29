package Presentation;

import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 362, 264);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setBounds(60, 46, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setBounds(60, 88, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(143, 43, 104, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 86, 104, 17);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connection conn = null;
				 
					View view=new View();
					view.frame.setVisible(true);

				     try
				     {
				         Class.forName("com.mysql.jdbc.Driver").newInstance();
				         String url = "jdbc:mysql://localhost/bank";
				         conn = DriverManager.getConnection(url, "root", "bogdan");
				         System.out.println("Successfully connected to the database");

				     }
				     catch(Exception e1){
				         e1.printStackTrace();
				     }
				     try{
				    String status=Business.Employee.login(textField.getText(), new String(passwordField.getPassword()));
                    if (status.equals("Admin logged in"))
                    {
                       System.out.println("admin logat");
                    }
                    else if (status.equals("User logged in"))
                    {
                    	System.out.println("user logat");
                    }
                     } catch (Exception exception)
                 {
                     exception.printStackTrace();
                     System.out.println("Incorrect");
                 }


				    
				    
				    
				    
			}
		});
		btnNewButton.setBounds(93, 125, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT !");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setBounds(93, 159, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
