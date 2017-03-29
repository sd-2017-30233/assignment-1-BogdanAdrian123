package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class View {

	JFrame frame;
	private JTextField txtIcn;
	private JTextField txtCnp;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtId;
	private JTextField txtType;
	private JTextField txtAmount;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 469, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client information");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(39, 24, 102, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account information");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setBounds(266, 24, 130, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(27, 187, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setBounds(27, 221, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VIEW");
		btnNewButton_2.setBounds(27, 255, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CREATE");
		btnNewButton_3.setBounds(248, 187, 89, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("READ");
		btnNewButton_4.setBounds(347, 187, 89, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("UPDATE");
		btnNewButton_5.setBounds(248, 221, 89, 23);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("DELETE");
		btnNewButton_6.setBounds(347, 221, 89, 23);
		panel.add(btnNewButton_6);
		
		txtIcn = new JTextField();
		txtIcn.setBounds(77, 74, 64, 20);
		panel.add(txtIcn);
		txtIcn.setColumns(10);
		
		txtCnp = new JTextField();
		txtCnp.setBounds(77, 105, 64, 20);
		panel.add(txtCnp);
		txtCnp.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(77, 49, 64, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(77, 136, 64, 20);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(338, 49, 58, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtType = new JTextField();
		txtType.setBounds(338, 74, 58, 20);
		panel.add(txtType);
		txtType.setColumns(10);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(338, 105, 58, 20);
		panel.add(txtAmount);
		txtAmount.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setBounds(338, 136, 58, 20);
		panel.add(txtDate);
		txtDate.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("Transfer");
		btnNewButton_7.setForeground(Color.BLUE);
		btnNewButton_7.setBounds(169, 270, 89, 23);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Bills");
		btnNewButton_8.setForeground(Color.BLUE);
		btnNewButton_8.setBounds(266, 270, 89, 23);
		panel.add(btnNewButton_8);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(21, 52, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CNP");
		lblNewLabel_3.setBounds(21, 108, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ICN");
		lblNewLabel_4.setBounds(21, 77, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setBounds(21, 139, 57, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setBounds(266, 52, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Type");
		lblNewLabel_7.setBounds(266, 77, 46, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Amount");
		lblNewLabel_8.setBounds(266, 108, 46, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Date");
		lblNewLabel_9.setBounds(266, 139, 46, 14);
		panel.add(lblNewLabel_9);
		
		JButton btnNewButton_9 = new JButton("!");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_9.setBackground(Color.RED);
		btnNewButton_9.setBounds(399, 270, 37, 23);
		panel.add(btnNewButton_9);
	}
}
