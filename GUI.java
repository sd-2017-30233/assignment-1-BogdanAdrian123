package Presentation;

import Business.*;

import javax.swing.*; //Necessary for GUI
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*; //Necessary for GUI
import java.awt.event.*; //Necessary for ActionListener
import java.util.ArrayList;

public class GUI {

    private boolean connected;

	//GUI variables
	private JFrame frame1;
    private Container pane;
    private JPanel cards, adminPanel,employeePanel;
    private final static String ADMINPANEL = "Card with Admin Panel";
    private final static String EMPLOYEEPANEL = "Card with Employee Panel";
    private JTable table;
    private JScrollPane scrollPane;
	private Insets insets;
	private JMenuBar adminMenuBar,employeeMenuBar;
	private JMenu menuClients,menuAccounts,menuEmployees,menuTransferMoney,menuPayUtilityBill,menuGenerateReport;
	private JMenuItem menuItemAddClient,menuItemAddAccount,menuItemAddEmployee,
                      menuItemViewClients,menuItemViewClientByPNC,menuItemViewAccountByID,menuItemViewAccounts,menuItemViewEmployees,menuItemViewEmployeeByID,
                      menuItemUpdateClient,menuItemUpdateAccount,menuItemUpdateEmployee,
                      menuItemDeleteClient,menuItemDeleteAccount,menuItemDeleteEmployee;


	private JLabel lblUsername, lblPassword, lblID, lblDestinationID, lblName, lblAddress, lblFunds, lblICN,
            lblPNC,lblType,lblOldPNC,lblOldID,lblOwnerPNC,lblUtility,lblEmployeeUsername,lblEmployeePassword,lblAdmin,
             lblEmployeeID,lblEmployeeName,lblEmployeeOldID,lblFromDate,lblToDate;
	private JTextField txtUsername, txtID, txtName, txtDestinationID, txtAddress, txtICN, txtPNC,txtFunds,txtOldPNC,txtOldID,txtOwnerPNC,
            txtEmployeeUsername,txtEmployeeID,txtEmployeeName,txtEmployeeOldID,txtFromDate,txtToDate;
	private JComboBox cbType,cbUtilityType;
    private JCheckBox checkAdmin;
    private JPasswordField txtPassword,txtEmployeePassword;
	private JButton btnConnect,btnAddClient,btnAddAccount,btnAddEmployee,
					btnUpdateClient,btnUpdateAccount,btnUpdateEmployee,
					btnTransferFunds,btnPay,btnGenerate;

	private static final int HS=10,VS=10; //HS=HorizontalSpacing VS=VerticalSpacing

	/**
	 *Initialise the GUI. Creates and adds the different components of the GUI.
	 * Shows the application's window and sets its position to the centre of the screen.
	 */
	public GUI() {

        connected=false;

		// Set Look and Feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (UnsupportedLookAndFeelException e) {
		}

		// Create the frame
		frame1 = new JFrame("Bank Management");
		frame1.setSize(450, 80);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = frame1.getContentPane();
        adminPanel= new JPanel();
        employeePanel = new JPanel();
        insets =pane.getInsets();
        pane.setLayout(null);
        cards = new JPanel(new CardLayout());
        cards.add(adminPanel,ADMINPANEL);
        cards.add(employeePanel,EMPLOYEEPANEL);
        //Create the components
		//Create the menuBars
        adminMenuBar=new JMenuBar();
        employeeMenuBar=new JMenuBar();
		//Create menus
		menuClients=new JMenu("Clients");
		menuAccounts=new JMenu("Accounts");
		menuEmployees=new JMenu("Employees");
		menuTransferMoney=new JMenu("Transfer Money");
        menuPayUtilityBill=new JMenu("Pay Utility Bill");
		//Create menu items

		menuItemAddClient=new JMenuItem("Add client");
        menuItemAddAccount=new JMenuItem("Add account");
        menuItemAddEmployee=new JMenuItem("Add employee");
		menuItemViewClientByPNC=new JMenuItem("View Client By PNC");
		menuItemViewAccountByID=new JMenuItem("View Account By ID");
		menuItemViewEmployeeByID=new JMenuItem("View Employee By ID");
        menuItemViewClients=new JMenuItem("View Clients");
        menuItemViewAccounts=new JMenuItem("View Accounts");
        menuItemViewEmployees=new JMenuItem("View Employees");
		menuItemUpdateClient=new JMenuItem("Update Client By PNC");
        menuItemUpdateAccount=new JMenuItem("Update account By ID");
        menuItemUpdateEmployee=new JMenuItem("Update employee By ID");
        menuItemDeleteClient=new JMenuItem("Delete client By PNC");
		menuItemDeleteAccount=new JMenuItem("Delete account By ID");
        menuItemDeleteEmployee=new JMenuItem("Delete employee ID");


		//Create the labels
		lblUsername=new JLabel("Username:");
		lblPassword=new JLabel("Password:");
		lblID=new JLabel("ID:");
        lblDestinationID= new JLabel("Destination Account ID:");
		lblName=new JLabel("Name:");
		lblAddress=new JLabel("Address:");
		lblFunds=new JLabel("Funds:");
        lblICN=new JLabel("Identity Card Number:");
        lblPNC=new JLabel("Personal Numeric Code:");
        lblType=new JLabel("Type:");
        lblOldPNC=new JLabel("Old PNC:");
        lblOldID=new JLabel("Old ID:");
        lblOwnerPNC=new JLabel("Owner's PNC:");
        lblUtility=new JLabel("Utility:");
        lblEmployeeOldID=new JLabel("Old ID:");
        lblEmployeeID=new JLabel("ID:");
        lblEmployeeName=new JLabel("Name:");
        lblEmployeeUsername=new JLabel("Employee Username:");
        lblEmployeePassword=new JLabel("Employee Password:");
        lblAdmin=new JLabel("Admin");
        lblFromDate=new JLabel("From:");
        lblToDate=new JLabel("To:");

		///Create text fields
		txtUsername=new JTextField(10);
		txtID=new JTextField(5);
		txtName=new JTextField(10);
		txtAddress=new JTextField(10);
		txtFunds=new JTextField(10);
        txtDestinationID=new JTextField(5);
        txtICN= new JTextField(6);
        txtPNC= new JTextField(13);
        txtOldPNC=new JTextField(13);
        txtOldID=new JTextField(13);
        txtOwnerPNC=new JTextField(13);
        txtEmployeeOldID=new JTextField(5);
        txtEmployeeID=new JTextField(5);
        txtEmployeeName= new JTextField(10);
        txtEmployeeUsername=new JTextField(10);
        txtFromDate=new JTextField(15);
        txtToDate=new JTextField(15);


		//Create Password field
		txtPassword=new JPasswordField(10);
        txtEmployeePassword=new JPasswordField(10);
		//Create buttons
		btnConnect=new JButton("Connect");
		btnAddClient=new JButton("Add Client");
		btnAddAccount=new JButton("Add Account");
		btnAddEmployee=new JButton("Add Employee");
		btnUpdateClient=new JButton("Update Client");
		btnUpdateAccount=new JButton("Update Account");
		btnUpdateEmployee=new JButton("Update Employee");
        btnTransferFunds=new JButton("Transfer Funds");
        btnPay=new JButton("Pay");
        btnGenerate=new JButton("Generate");

        String[] options={"Savings","Deposit"};
        cbType=new JComboBox(options);
        String[] utilitiesTypes={"Electricity","Gas","Water"};
        cbUtilityType=new JComboBox(utilitiesTypes);
        checkAdmin=new JCheckBox();

		//Add menus to me menuBars
		employeeMenuBar.add(menuClients);
		employeeMenuBar.add(menuAccounts);
        adminMenuBar.add(menuEmployees);
        employeeMenuBar.add(menuTransferMoney);
        employeeMenuBar.add(menuPayUtilityBill);
		//Add menuItems to menus
		menuClients.add(menuItemAddClient);
		menuClients.add(menuItemViewClients);
		menuClients.add(menuItemViewClientByPNC);
		menuClients.add(menuItemUpdateClient);
        menuClients.add(menuItemDeleteClient);

        menuAccounts.add(menuItemAddAccount);
        menuAccounts.add(menuItemViewAccounts);
        menuAccounts.add(menuItemViewAccountByID);
        menuAccounts.add(menuItemUpdateAccount);
        menuAccounts.add(menuItemDeleteAccount);

        menuEmployees.add(menuItemAddEmployee);
        menuEmployees.add(menuItemViewEmployees);
        menuEmployees.add(menuItemViewEmployeeByID);
        menuEmployees.add(menuItemUpdateEmployee);
        menuEmployees.add(menuItemDeleteEmployee);

		// Add components to the panels
        pane.add(lblUsername);
        pane.add(lblPassword);
        pane.add(txtUsername);
        pane.add(txtPassword);
        pane.add(btnConnect);
        pane.add(cards, null);

        employeePanel.add(lblOldPNC);
        employeePanel.add(txtOldPNC);
		employeePanel.add(lblName);
        employeePanel.add(txtName);
		employeePanel.add(lblPNC);
        employeePanel.add(txtPNC);
		employeePanel.add(lblAddress);
        employeePanel.add(txtAddress);
		employeePanel.add(lblICN);
        employeePanel.add(txtICN);

        employeePanel.add(lblOldID);
        employeePanel.add(txtOldID);
        employeePanel.add(lblID);
        employeePanel.add(txtID);
        employeePanel.add(lblType);
        employeePanel.add(cbType);
        employeePanel.add(lblFunds);
        employeePanel.add(txtFunds);
        employeePanel.add(lblOwnerPNC);
        employeePanel.add(txtOwnerPNC);
        employeePanel.add(lblDestinationID);
        employeePanel.add(txtDestinationID);
        employeePanel.add(lblUtility);
        employeePanel.add(cbUtilityType);

		//buttons
		employeePanel.add(btnAddClient);
        employeePanel.add(btnUpdateClient);
		employeePanel.add(btnAddAccount);
		employeePanel.add(btnUpdateAccount);
        employeePanel.add(btnTransferFunds);
        employeePanel.add(btnPay);

        adminPanel.add(lblEmployeeOldID);
        adminPanel.add(txtEmployeeOldID);
        adminPanel.add(lblEmployeeID);
        adminPanel.add(txtEmployeeID);
        adminPanel.add(lblEmployeeName);
        adminPanel.add(txtEmployeeName);
        adminPanel.add(lblEmployeeUsername);
        adminPanel.add(txtEmployeeUsername);
        adminPanel.add(lblEmployeePassword);
        adminPanel.add(txtEmployeePassword);
        adminPanel.add(checkAdmin);
        adminPanel.add(lblAdmin);
        adminPanel.add(btnAddEmployee);
        adminPanel.add(btnUpdateEmployee);
        adminPanel.add(lblFromDate);
        adminPanel.add(lblToDate);
        adminPanel.add(txtFromDate);
        adminPanel.add(txtToDate);
        adminPanel.add(btnGenerate);

		//set the position of the components
      	//login components
		lblUsername.setBounds(insets.left+HS,insets.top+VS,lblUsername.getPreferredSize().width,lblUsername.getPreferredSize().height);
		txtUsername.setBounds(lblUsername.getX()+lblUsername.getWidth(),lblUsername.getY(),txtUsername.getPreferredSize().width,txtUsername.getPreferredSize().height);
		lblPassword.setBounds(txtUsername.getX()+txtUsername.getWidth()+HS,lblUsername.getY(),lblPassword.getPreferredSize().width,lblPassword.getPreferredSize().height);
		txtPassword.setBounds(lblPassword.getX()+lblPassword.getWidth(),lblUsername.getY(),txtPassword.getPreferredSize().width,txtPassword.getPreferredSize().height);
		btnConnect.setBounds(txtPassword.getX()+txtPassword.getWidth()+HS,lblPassword.getY(),btnConnect.getPreferredSize().width,btnConnect.getPreferredSize().height);

        cards.setBounds(insets.left,lblUsername.getY()+lblUsername.getHeight()+VS,cards.getPreferredSize().width,cards.getPreferredSize().height);
        employeePanel.setLayout(null);
        employeePanel.setBounds(cards.getX(),cards.getY(),employeePanel.getPreferredSize().width,employeePanel.getPreferredSize().height);

        lblOldPNC.setBounds(employeePanel.getInsets().left+HS,employeePanel.getInsets().top,lblOldPNC.getPreferredSize().width,lblOldPNC.getPreferredSize().height);
        txtOldPNC.setBounds(lblOldPNC.getX()+lblOldPNC.getWidth()+HS,lblOldPNC.getY(),txtOldPNC.getPreferredSize().width, txtOldPNC.getPreferredSize().height);

        lblOldID.setBounds(employeePanel.getInsets().left+HS,employeePanel.getInsets().top,lblOldID.getPreferredSize().width,lblOldID.getPreferredSize().height);
        txtOldID.setBounds(lblOldID.getX()+lblOldID.getWidth()+HS,lblOldID.getY(),txtOldID.getPreferredSize().width, txtOldID.getPreferredSize().height);

        adminPanel.setLayout(null);
        adminPanel.setBounds(cards.getX(),cards.getY(),adminPanel.getPreferredSize().width,adminPanel.getPreferredSize().height);

        lblEmployeeOldID.setBounds(adminPanel.getInsets().left+HS,adminPanel.getInsets().top,lblEmployeeOldID.getPreferredSize().width,lblEmployeeOldID.getPreferredSize().height);
        txtEmployeeOldID.setBounds(lblEmployeeOldID.getX()+lblEmployeeOldID.getWidth()+HS,lblEmployeeOldID.getY(),txtEmployeeOldID.getPreferredSize().width, txtEmployeeOldID.getPreferredSize().height);

        //Sets the frame visible, and its position to the centre of the screen
		frame1.setVisible(true);
		frame1.setLocationRelativeTo(null);
        setAllOptionsInvisible();

        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!connected)
                    try {
                        String status=Business.EmployeeModule.login(txtUsername.getText(), new String(txtPassword.getPassword()));
                        if (status.equals("Admin logged in"))
                        {
                            setAdminOptions();
                            connected=true;
                        }
                        else if (status.equals("Employee logged in"))
                        {
                            setEmployeeOptions();
                            connected=true;
                        }
                        else {
                            connected = false;
                            showMessage("Check inputs and try again");
                            }
                        } catch (Exception exception)
                    {
                        exception.printStackTrace();
                        showMessage("Check inputs and try again");
                    }
                else
                {
                    setAllOptionsInvisible();
                    connected=false;
                }

                if (connected) setLoginEnabled(false);
                else setLoginEnabled(true);
            }
        });

        menuItemAddClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllOptionsInvisible();
                setAddClientOptions(true);
            }
        });

        menuItemUpdateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllOptionsInvisible();
                setUpdateClientOptions(true);
            }
        });

        menuItemViewClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Client> clientList=ClientManager.getClients();
                if (clientList!=null)
                    if (!clientList.isEmpty())
                    {
                        String[] columnNames={"Name","ICN","PNC","address"};
                        Object[][] data=new Object[clientList.size()][4];
                        for(int i=0; i<clientList.size();i++ )
                            {
                                Client client=clientList.get(i);
                                data[i][0]=client.getName();
                                data[i][1]=client.getIcn();
                                data[i][2]=client.getPnc();
                                data[i][3]=client.getAddress();
                            }
                        addTable(columnNames,data);
                        String logStatus=LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(),"Viewed clients");
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                    }
            }
        });

        menuItemViewClientByPNC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long PNC = Long.parseLong(JOptionPane.showInputDialog(frame1, "Input the PNC of the client that you wish to view:"));
                    Client client=ClientManager.getClient(PNC);
                    if(client!=null){
                    String[] columnNames={"Name","ICN","PNC","address"};
                    Object[][] data=new Object[1][4];
                    data[0][0]=client.getName();
                    data[0][1]=client.getIcn();
                    data[0][2]=client.getPnc();
                    data[0][3]=client.getAddress();
                    addTable(columnNames,data);
                        String logStatus=LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(),"Viewed client with PNC:"+PNC);
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                    }
                    else showMessage("No client found or invalid PNC, (PNC must have 13 digits)");
                }catch (NumberFormatException nfe)
                {
                    showMessage("Invalid PNC");
                    //nfe.printStackTrace();
                }

            }
        });

        menuItemDeleteClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   long PNC = Long.parseLong(JOptionPane.showInputDialog(frame1, "Input the PNC of the client that you wish to delete:"));
                    String status=ClientManager.deleteClient(PNC);
                    if (status.equals("Deleted successfully")){
                        String logStatus=LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(),"Client with PNC:"+PNC+" deleted");
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                    }
                    showMessage(status);
                }catch (NumberFormatException nfe)
                {
                   // nfe.printStackTrace();
                    showMessage("Invalid PNC, must have 13 digits");
                }
            }
        });

        btnAddClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name=txtName.getText();
                    String address=txtAddress.getText();
                    if(name.equals("") || address.equals(""))
                        showMessage("Name and address fields should not be empty");
                    String status=ClientManager.addClient(name, Integer.parseInt(txtICN.getText()), Long.parseLong(txtPNC.getText()), address);
                    if (status.equals("Inserted successfully")) {
                        String logStatus = LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(), "Client with PNC:" + Long.parseLong(txtPNC.getText()) + " added");
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                    }
                    showMessage(status);
                } catch (NumberFormatException  exception){
                   // exception.printStackTrace();
                    showMessage("Check ICN and PNC and try again");
                }
            }
        });

        btnUpdateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name=txtName.getText(), address=txtAddress.getText(), ICN=txtICN.getText(), PNC=txtPNC.getText(),oldPNC=txtOldPNC.getText();
                    if(name.equals("") || address.equals(""))
                        showMessage("Fields should not be empty");
                    String status=ClientManager.updateClient(name, Integer.parseInt(ICN), Long.parseLong(PNC), address, Long.parseLong(oldPNC));
                    if(status.equals("Updated successfully"))
                    {
                        String logStatus=LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(),"Client with PNC:"+PNC+" updated");
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                    }
                     showMessage(status);
                } catch (NumberFormatException  exception){
                    // exception.printStackTrace();
                    showMessage("Check ICN and PNC and try again");
                }
            }
        });

        menuItemAddAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               setAllOptionsInvisible();
                setAddAccountOptions(true);
            }
        });

        menuItemUpdateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllOptionsInvisible();
                setUpdateAccountOptions(true);
            }
        });

        btnAddAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   String status=AccountManager.addAccount(Integer.parseInt(txtID.getText()), (String) cbType.getSelectedItem(), Long.parseLong(txtFunds.getText()), Long.parseLong(txtOwnerPNC.getText()));
                    if (status.equals("Inserted successfully")) {
                        String logStatus = LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(), "Account with ID:" + Long.parseLong(txtID.getText()) + " added");
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                    }
                        showMessage(status);
                } catch (NumberFormatException nfe)
                {
                    showMessage("Invalid ID, funds or Owner's PNC");
                }
            }
        });

        btnUpdateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String status=AccountManager.updateAccount(Integer.parseInt(txtOldID.getText()),Integer.parseInt(txtID.getText()), (String) cbType.getSelectedItem(), Long.parseLong(txtFunds.getText()), Long.parseLong(txtOwnerPNC.getText()));
                    if (status.equals("Inserted successfully")) {
                        String logStatus = LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(), "Account with ID:" + Long.parseLong(txtID.getText()) + " updated");
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                    }
                    showMessage(status);
                }catch (NumberFormatException nfe)
                {
                    showMessage("Invalid oldID, ID, funds or Owner's PNC");
                }
            }
        });

        menuItemViewAccounts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Account> accountList=AccountManager.getAccounts();
                if (accountList!=null)
                    if (!accountList.isEmpty())
                    {
                        String[] columnNames={"ID","type","funds","owner's PNC","creation date"};
                        Object[][] data=new Object[accountList.size()][5];
                        for(int i=0; i<accountList.size();i++ )
                        {
                            Account account=accountList.get(i);
                            data[i][0]=account.getID();
                            data[i][1]=account.getType();
                            data[i][2]=account.getFunds();
                            data[i][3]=account.getOwnerPNC();
                            data[i][4]=account.getCreationDate();
                        }
                        String logStatus = LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(), "Viewed accounts");
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                        addTable(columnNames,data);
                    }
            }
        });

        menuItemViewAccountByID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ID = Integer.parseInt(JOptionPane.showInputDialog(frame1, "Input the ID of the Account that you wish to view:"));
                    Account account=AccountManager.getAccount(ID);
                    if(account!=null){
                        String[] columnNames={"ID","type","funds","owner's PNC","creation date"};
                        Object[][] data=new Object[1][5];
                        data[0][0]=account.getID();
                        data[0][1]=account.getType();
                        data[0][2]=account.getFunds();
                        data[0][3]=account.getOwnerPNC();
                        data[0][4]=account.getCreationDate();
                        addTable(columnNames,data);
                        String logStatus = LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(), "Viewed account with ID:" + ID);
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");

                    }
                    else showMessage("No account found or invalid ID");
                }catch (NumberFormatException nfe)
                {
                    showMessage("Invalid ID");
                    //nfe.printStackTrace();
                }
            }
        });

        menuItemDeleteAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ID = Integer.parseInt(JOptionPane.showInputDialog(frame1, "Input the ID of the Account that you wish to delete:"));
                    String status=AccountManager.deleteAccount(ID);
                    if(status.equals("Deleted successfully")) {
                        String logStatus = LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(), "Account with ID:" + ID + " deleted");
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                    }
                    showMessage(status);
                }catch (NumberFormatException nfe)
                {
                    showMessage("Invalid ID");
                }
            }
        });

        menuTransferMoney.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                setAllOptionsInvisible();
                setTransferMoneyOptions(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        btnTransferFunds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String status=AccountManager.transferFunds(Integer.parseInt(txtID.getText()),Integer.parseInt(txtDestinationID.getText()),Long.parseLong(txtFunds.getText()));
                    if(status.equals("Funds transferred successfully")) {
                        String logStatus = LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(), txtFunds.getText()+" funds transferred from "+txtID.getText()+" to "+txtDestinationID.getText());
                        if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                    }
                    showMessage(status);
                }catch (NumberFormatException nfe)
                {
                    showMessage("Invalid ID, destinationID or funds");
                }
            }
        });

        menuPayUtilityBill.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                setAllOptionsInvisible();
                setPayUtilityBillOptions(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try{
                String status= AccountManager.payUtilityBill(Integer.parseInt(txtID.getText()),Long.parseLong(txtFunds.getText()),(String) cbUtilityType.getSelectedItem());
                  if(status.contains("Successfully")) {
                      String logStatus = LogManager.saveLog(EmployeeModule.getCurrentEmployeeID(), status.replace("Successfully","")+" for "+txtID.getText());
                      if (!logStatus.equals("Inserted successfully")) showMessage("Error creating action log");
                  }
                  showMessage(status);
            } catch (NumberFormatException nfe)
              {
                  showMessage("Invalid ID or funds");
              }
            }
        });

        menuItemAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllOptionsInvisible();
                setAddEmployeeOptions(true);
            }
        });

        menuItemUpdateEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllOptionsInvisible();
                setUpdateEmployeeOptions(true);
            }
        });

        btnAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=txtEmployeeName.getText();
                String username=txtUsername.getText();
                String password=new String(txtEmployeePassword.getPassword());
                int admin=0;
                if (checkAdmin.isSelected()) admin=1;
                if (name.equals("") || username.equals("") || password.equals("")) showMessage("Please fill all the fields");
                else
                try {
                   String status=EmployeeModule.insert(Integer.parseInt(txtEmployeeID.getText()),name,username,password,admin);
                    showMessage(status);
                }
                catch (NumberFormatException nfe)
                {
                    showMessage("Invalid ID");
                }
            }
        });


    btnUpdateEmployee.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name=txtEmployeeName.getText();
            String username=txtEmployeeUsername.getText();
            String password=new String(txtEmployeePassword.getPassword());
            int admin=0;
            if (checkAdmin.isSelected()) admin=1;
            if (name.equals("") || username.equals("") || password.equals("")) showMessage("Please fill all the fields");
            else
                try {
                    String status=EmployeeModule.update(Integer.parseInt(txtEmployeeOldID.getText()), Integer.parseInt(txtEmployeeID.getText()), name, username, password, admin);
                    showMessage(status);
                }
                catch (NumberFormatException nfe)
                {
                    showMessage("Invalid oldID or ID");
                }
        }
    });

        menuItemViewEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columnNames = {"ID", "Name", "username", "admin"};
                Object[][] data = EmployeeModule.getEmployees();
                 if (data!=null) addTable(columnNames,data);
                else showMessage("No employees found");
            }
    });

        menuItemViewEmployeeByID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ID = Integer.parseInt(JOptionPane.showInputDialog(frame1, "Input the ID of the Employee that you wish to view:"));
                    String[] columnNames = {"ID", "Name", "username", "admin"};
                    Object[][] data = EmployeeModule.getEmployee(ID);
                    if (data!=null) addTable(columnNames,data);
                    else showMessage("No employee found");
                    } catch (NumberFormatException nfe)
                    {
                    showMessage("Invalid ID");
                    //nfe.printStackTrace();
                    }
            }
        });


        menuItemDeleteEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ID = Integer.parseInt(JOptionPane.showInputDialog(frame1, "Input the ID of the Employee that you wish to delete:"));
                    String status=EmployeeModule.delete(ID);
                    showMessage(status);
                }catch (NumberFormatException nfe)
                {
                    showMessage("Invalid ID");
                }
            }
        });
	}
       
    private void addTable(String[] columnsNames,Object[][] data)
    {
        if (scrollPane!=null) pane.remove(scrollPane);
        table = new JTable(data,columnsNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        scrollPane=new JScrollPane(table);
       // scrollPane.setVisible(true);
        scrollPane.setBounds(pane.getInsets().left+HS,lblUsername.getY()+lblUsername.getHeight()+5*VS,scrollPane.getPreferredSize().width+300,scrollPane.getPreferredSize().width);
        pane.add(scrollPane);
        pane.revalidate();
        frame1.setSize(1100, scrollPane.getHeight() + 200);
        frame1.setLocationRelativeTo(null);
    }

    private void setAdminOptions()
    {
        setPanel(ADMINPANEL);
        setMenuBar("Admin");
    }

    private void setEmployeeOptions()
    {
        setPanel(EMPLOYEEPANEL);
        setMenuBar("Employee");
    }

    private void setPanel(String panel)
    {
        CardLayout cardLayout = (CardLayout)(cards.getLayout());
        cardLayout.show(cards, panel);
    }

    private void setMenuBar(String menuBar)
    {
        if (menuBar.contains("Admin"))
        frame1.setJMenuBar(adminMenuBar);
        else frame1.setJMenuBar(employeeMenuBar);
    }

    /**
     * sets the view so only login options are available or all others according to b
     * @param b true to set enabled, false to set disabled
     */
    private void setLoginEnabled(boolean b) {
        lblUsername.setEnabled(b);
        txtUsername.setEnabled(b);
        lblPassword.setEnabled(b);
        txtPassword.setEnabled(b);
        if (b)
        {
            txtUsername.setText("");
            txtPassword.setText("");
            frame1.setJMenuBar(null);
            frame1.setSize(450, 80);
            frame1.setLocationRelativeTo(null);
            btnConnect.setText("Connect");
            cards.setVisible(false);

        }
        else{
            frame1.setSize(1100, 200);
            frame1.setLocationRelativeTo(null);
            btnConnect.setText("Disconnect");
            btnConnect.setBounds(txtPassword.getX()+txtPassword.getWidth()+HS,lblPassword.getY(),btnConnect.getPreferredSize().width,btnConnect.getPreferredSize().height);
            cards.setVisible(true);
        }

    }

    private void setAllOptionsInvisible()
    {
        lblOldPNC.setVisible(false);
        txtOldPNC.setVisible(false);
        lblName.setVisible(false);
        txtName.setVisible(false);
        lblICN.setVisible(false);
        txtICN.setVisible(false);
        lblPNC.setVisible(false);
        txtPNC.setVisible(false);
        lblAddress.setVisible(false);
        txtAddress.setVisible(false);
        btnAddClient.setVisible(false);
        btnUpdateClient.setVisible(false);
        if (scrollPane!=null) scrollPane.setVisible(false);
        lblOldID.setVisible(false);
        txtOldID.setVisible(false);
        lblID.setVisible(false);
        txtID.setVisible(false);
        lblType.setVisible(false);
        cbType.setVisible(false);
        lblFunds.setVisible(false);
        txtFunds.setVisible(false);
        lblOwnerPNC.setVisible(false);
        txtOwnerPNC.setVisible(false);
        btnAddAccount.setVisible(false);
        btnUpdateAccount.setVisible(false);
        lblDestinationID.setVisible(false);
        txtDestinationID.setVisible(false);
        btnTransferFunds.setVisible(false);
        lblUtility.setVisible(false);
        cbUtilityType.setVisible(false);
        btnPay.setVisible(false);
        lblID.setVisible(false);
        txtID.setVisible(false);
        lblName.setVisible(false);
        txtName.setVisible(false);
        lblEmployeeOldID.setVisible(false);
        txtEmployeeOldID.setVisible(false);
        lblEmployeeID.setVisible(false);
        txtEmployeeID.setVisible(false);
        lblEmployeeName.setVisible(false);
        txtEmployeeName.setVisible(false);
        lblEmployeeUsername.setVisible(false);
        txtEmployeeUsername.setVisible(false);
        lblEmployeePassword.setVisible(false);
        txtEmployeePassword.setVisible(false);
        checkAdmin.setVisible(false);
        lblAdmin.setVisible(false);
        btnAddEmployee.setVisible(false);
        btnUpdateEmployee.setVisible(false);
        lblFromDate.setVisible(false);
        txtFromDate.setVisible(false);
        lblToDate.setVisible(false);
        txtToDate.setVisible(false);
       // btnGenerate.setVisible(false);
    }

    private void setClientComponentsPositions() {
        txtName.setBounds(lblName.getX()+lblName.getWidth()+HS,lblOldPNC.getY(),txtName.getPreferredSize().width,txtName.getPreferredSize().height);
        lblPNC.setBounds(txtName.getX()+txtName.getWidth()+HS,lblOldPNC.getY(),lblPNC.getPreferredSize().width,lblPNC.getPreferredSize().height);
        txtPNC.setBounds(lblPNC.getX()+lblPNC.getWidth()+HS,lblOldPNC.getY(),txtPNC.getPreferredSize().width,txtPNC.getPreferredSize().height);
        lblAddress.setBounds(txtPNC.getX()+txtPNC.getWidth()+HS,lblOldPNC.getY(),lblAddress.getPreferredSize().width,lblAddress.getPreferredSize().height);
        txtAddress.setBounds(lblAddress.getX()+lblAddress.getWidth()+HS,lblOldPNC.getY(),txtAddress.getPreferredSize().width,txtAddress.getPreferredSize().height);
        lblICN.setBounds(txtAddress.getX() + txtAddress.getWidth() + HS, lblOldPNC.getY(), lblICN.getPreferredSize().width, lblICN.getPreferredSize().height);
        txtICN.setBounds(lblICN.getX() + lblICN.getWidth() + HS, lblOldPNC.getY(), txtICN.getPreferredSize().width, txtICN.getPreferredSize().height);
        btnAddClient.setBounds(txtICN.getX() + txtICN.getWidth() + HS, lblOldPNC.getY(), btnAddClient.getPreferredSize().width, btnAddClient.getPreferredSize().height);
        btnUpdateClient.setBounds(txtICN.getX() + txtICN.getWidth() + HS, lblOldPNC.getY(), btnUpdateClient.getPreferredSize().width, btnUpdateClient.getPreferredSize().height);
    }

    private void setAccountComponentsPositions() {
        txtID.setBounds(lblID.getX()+lblID.getWidth()+HS,lblOldID.getY(),txtID.getPreferredSize().width,txtID.getPreferredSize().height);
        lblType.setBounds(txtID.getX() + txtID.getWidth() + HS, lblOldID.getY(), lblType.getPreferredSize().width,  lblType.getPreferredSize().height);
        cbType.setBounds(lblType.getX()+lblType.getWidth()+HS,lblOldID.getY(),cbType.getPreferredSize().width,cbType.getPreferredSize().height);
        lblFunds.setBounds(cbType.getX() + cbType.getWidth() + HS, lblOldID.getY(), lblFunds.getPreferredSize().width, lblFunds.getPreferredSize().height);
        txtFunds.setBounds(lblFunds.getX() + lblFunds.getWidth() + HS, lblOldID.getY(), txtFunds.getPreferredSize().width, txtFunds.getPreferredSize().height);
        lblOwnerPNC.setBounds(txtFunds.getX() + txtFunds.getWidth() + HS, lblOldID.getY(), lblOwnerPNC.getPreferredSize().width, lblOwnerPNC.getPreferredSize().height);
        txtOwnerPNC.setBounds(lblOwnerPNC.getX() + lblOwnerPNC.getWidth() + HS, lblOldID.getY(), txtOwnerPNC.getPreferredSize().width, txtOwnerPNC.getPreferredSize().height);
        btnAddAccount.setBounds(txtOwnerPNC.getX() +  txtOwnerPNC.getWidth() + HS, lblOldID.getY(), btnAddAccount.getPreferredSize().width, btnAddAccount.getPreferredSize().height);
        btnUpdateAccount.setBounds(txtOwnerPNC.getX() +  txtOwnerPNC.getWidth() + HS, lblOldID.getY(), btnUpdateAccount.getPreferredSize().width, btnUpdateAccount.getPreferredSize().height);
    }

    private void setTransferMoneyComponentsPositions() {
        lblID.setBounds(employeePanel.getInsets().left+HS,employeePanel.getInsets().top+VS,lblID.getPreferredSize().width,lblID.getPreferredSize().height);
        txtID.setBounds(lblID.getX()+lblID.getWidth()+HS,lblID.getY(),txtID.getPreferredSize().width,txtID.getPreferredSize().height);
        lblDestinationID.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),lblDestinationID.getPreferredSize().width,lblDestinationID.getPreferredSize().height);
        txtDestinationID.setBounds(lblDestinationID.getX() + lblDestinationID.getWidth() + HS, lblID.getY(), txtDestinationID.getPreferredSize().width, txtDestinationID.getPreferredSize().height);
        lblFunds.setBounds(txtDestinationID.getX()+txtDestinationID.getWidth()+HS,lblID.getY(), lblFunds.getPreferredSize().width, lblFunds.getPreferredSize().height);
        txtFunds.setBounds(lblFunds.getX() + lblFunds.getWidth() + HS, lblID.getY(),txtFunds.getPreferredSize().width, txtFunds.getPreferredSize().height);
        btnTransferFunds.setBounds(txtFunds.getX() + txtFunds.getWidth() + HS, lblID.getY(),btnTransferFunds.getPreferredSize().width,btnTransferFunds.getPreferredSize().height);
    }

    private void setPayUtilityBillComponentsPositions() {
        lblID.setBounds(employeePanel.getInsets().left+HS,employeePanel.getInsets().top+VS,lblID.getPreferredSize().width,lblID.getPreferredSize().height);
        txtID.setBounds(lblID.getX()+lblID.getWidth()+HS,lblID.getY(),txtID.getPreferredSize().width,txtID.getPreferredSize().height);
        lblFunds.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(), lblFunds.getPreferredSize().width, lblFunds.getPreferredSize().height);
        txtFunds.setBounds(lblFunds.getX() + lblFunds.getWidth() + HS, lblID.getY(),txtFunds.getPreferredSize().width, txtFunds.getPreferredSize().height);
        lblUtility.setBounds(txtFunds.getX() + txtFunds.getWidth() + HS, lblID.getY(),lblUtility.getPreferredSize().width,lblUtility.getPreferredSize().height);
        cbUtilityType.setBounds(lblUtility.getX()+lblUtility.getWidth()+HS, lblID.getY(),cbUtilityType.getPreferredSize().width,cbUtilityType.getPreferredSize().height);
        btnPay.setBounds(cbUtilityType.getX() + cbUtilityType.getWidth() + HS, lblID.getY(),btnTransferFunds.getPreferredSize().width,btnTransferFunds.getPreferredSize().height);

    }

    private void setEmployeeComponentsPositions() {
        txtEmployeeID.setBounds(lblEmployeeID.getX()+lblEmployeeID.getWidth()+HS,lblEmployeeID.getY(),txtEmployeeID.getPreferredSize().width,txtEmployeeID.getPreferredSize().height);
        lblEmployeeName.setBounds(txtEmployeeID.getX()+txtEmployeeID.getWidth()+HS,lblID.getY(),lblEmployeeName.getPreferredSize().width,lblEmployeeName.getPreferredSize().height);
        txtEmployeeName.setBounds(lblEmployeeName.getX()+lblEmployeeName.getWidth()+HS,lblID.getY(),txtEmployeeName.getPreferredSize().width,txtEmployeeName.getPreferredSize().height);
        lblEmployeeUsername.setBounds(txtEmployeeName.getX()+txtEmployeeName.getWidth()+HS,lblID.getY(),lblEmployeeUsername.getPreferredSize().width,lblEmployeeUsername.getPreferredSize().height);
        txtEmployeeUsername.setBounds(lblEmployeeUsername.getX()+lblEmployeeUsername.getWidth()+HS,lblID.getY(),txtEmployeeUsername.getPreferredSize().width,txtEmployeeUsername.getPreferredSize().height);
        lblEmployeePassword.setBounds(txtEmployeeUsername.getX()+txtEmployeeUsername.getWidth()+HS,lblID.getY(),lblEmployeePassword.getPreferredSize().width,lblEmployeePassword.getPreferredSize().height);
        txtEmployeePassword.setBounds(lblEmployeePassword.getX()+lblEmployeePassword.getWidth()+HS,lblID.getY(),txtEmployeePassword.getPreferredSize().width,txtEmployeePassword.getPreferredSize().height);
        checkAdmin.setBounds(txtEmployeePassword.getX()+txtEmployeePassword.getWidth()+HS,lblID.getY(),checkAdmin.getPreferredSize().width,checkAdmin.getPreferredSize().height);
        lblAdmin.setBounds(checkAdmin.getX()+checkAdmin.getWidth()+HS,lblID.getY(), lblAdmin.getPreferredSize().width, lblAdmin.getPreferredSize().height);
        btnAddEmployee.setBounds(lblAdmin.getX()+lblAdmin.getWidth()+HS,lblID.getY(),btnAddEmployee.getPreferredSize().width,btnAddEmployee.getPreferredSize().height);
        btnUpdateEmployee.setBounds(lblAdmin.getX()+lblAdmin.getWidth()+HS,lblID.getY(),btnUpdateEmployee.getPreferredSize().width,btnUpdateEmployee.getPreferredSize().height);
    }

    private void setGenerateComponentsPositions() {
        txtEmployeeID.setBounds(lblEmployeeID.getX()+lblEmployeeID.getWidth()+HS,lblEmployeeID.getY(),txtEmployeeID.getPreferredSize().width,txtEmployeeID.getPreferredSize().height);
        lblFromDate.setBounds(txtEmployeeID.getX() + txtEmployeeID.getWidth() + HS, lblEmployeeID.getY(), lblFromDate.getPreferredSize().width, lblFromDate.getPreferredSize().height);
        txtFromDate.setBounds(lblFromDate.getX() + lblFromDate.getWidth() + HS, lblEmployeeID.getY(), txtFromDate.getPreferredSize().width, txtFromDate.getPreferredSize().height);
        lblToDate.setBounds(txtFromDate.getX() + txtFromDate.getWidth() + HS, lblEmployeeID.getY(), lblToDate.getPreferredSize().width,lblToDate.getPreferredSize().height);
        txtToDate.setBounds(lblToDate.getX() + lblToDate.getWidth() + HS, lblEmployeeID.getY(), txtToDate.getPreferredSize().width, txtToDate.getPreferredSize().height);
       // btnGenerate.setBounds(txtToDate.getX() +  txtToDate.getWidth() + HS, lblEmployeeID.getY(), btnGenerate.getPreferredSize().width, btnGenerate.getPreferredSize().height);
    }


    private void setGenerateOptions(boolean visible) {
        lblEmployeeID.setBounds(lblOldID.getX(),lblOldID.getY(), lblEmployeeID.getPreferredSize().width, lblEmployeeID.getPreferredSize().height);
        setGenerateComponentsPositions();
        lblEmployeeID.setVisible(visible);
        txtEmployeeID.setVisible(visible);
        lblFromDate.setVisible(visible);
        txtFromDate.setVisible(visible);
        lblToDate.setVisible(visible);
        txtToDate.setVisible(visible);
      //  btnGenerate.setVisible(visible);
    }

    private void setAddEmployeeOptions(boolean visible) {
        lblEmployeeID.setBounds(lblEmployeeOldID.getX(),lblEmployeeOldID.getY(),lblEmployeeID.getPreferredSize().width,lblEmployeeID.getPreferredSize().height);
        setEmployeeComponentsPositions();
        lblEmployeeID.setVisible(visible);
        txtEmployeeID.setVisible(visible);
        lblEmployeeName.setVisible(visible);
        txtEmployeeName.setVisible(visible);
        lblEmployeeUsername.setVisible(visible);
        txtEmployeeUsername.setVisible(visible);
        lblEmployeePassword.setVisible(visible);
        txtEmployeePassword.setVisible(visible);
        checkAdmin.setVisible(visible);
        lblAdmin.setVisible(visible);
        btnAddEmployee.setVisible(visible);
    }

    private void setUpdateEmployeeOptions(boolean visible) {
        lblEmployeeID.setBounds(txtEmployeeOldID.getX()+txtEmployeeOldID.getWidth()+HS,lblEmployeeOldID.getY(),lblEmployeeID.getPreferredSize().width,lblEmployeeID.getPreferredSize().height);
        setEmployeeComponentsPositions();
        lblEmployeeOldID.setVisible(visible);
        txtEmployeeOldID.setVisible(visible);
        lblEmployeeID.setVisible(visible);
        txtEmployeeID.setVisible(visible);
        lblEmployeeName.setVisible(visible);
        txtEmployeeName.setVisible(visible);
        lblEmployeeUsername.setVisible(visible);
        txtEmployeeUsername.setVisible(visible);
        lblEmployeePassword.setVisible(visible);
        txtEmployeePassword.setVisible(visible);
        checkAdmin.setVisible(visible);
        lblAdmin.setVisible(visible);
        btnUpdateEmployee.setVisible(visible);
    }

    private void setPayUtilityBillOptions(boolean visible) {
        setPayUtilityBillComponentsPositions();
        lblID.setVisible(visible);
        txtID.setVisible(visible);
        lblFunds.setVisible(visible);
        txtFunds.setVisible(visible);
        lblUtility.setVisible(visible);
        cbUtilityType.setVisible(visible);
        btnPay.setVisible(visible);
    }

    private void setTransferMoneyOptions(boolean visible) {

        setTransferMoneyComponentsPositions();
        lblID.setVisible(visible);
        txtID.setVisible(visible);
        lblDestinationID.setVisible(visible);
        txtDestinationID.setVisible(visible);
        lblFunds.setVisible(visible);
        txtFunds.setVisible(visible);
        btnTransferFunds.setVisible(visible);
    }

    private void setAddClientOptions(boolean visible)
    {
        lblName.setBounds(lblOldPNC.getX(),lblOldPNC.getY(),lblName.getPreferredSize().width,lblName.getPreferredSize().height);
        setClientComponentsPositions();
        lblName.setVisible(visible);
        txtName.setVisible(visible);
        lblICN.setVisible(visible);
        txtICN.setVisible(visible);
        lblPNC.setVisible(visible);
        txtPNC.setVisible(visible);
        lblAddress.setVisible(visible);
        txtAddress.setVisible(visible);
        btnAddClient.setVisible(visible);
    }

    private void setUpdateClientOptions(boolean visible)
    {
        lblOldPNC.setVisible(visible);
        txtOldPNC.setVisible(visible);
        lblName.setBounds(txtOldPNC.getX()+txtOldPNC.getWidth()+HS,lblOldPNC.getY(),lblName.getPreferredSize().width,lblName.getPreferredSize().height);
        setClientComponentsPositions();
        lblName.setVisible(visible);
        txtName.setVisible(visible);
        lblICN.setVisible(visible);
        txtICN.setVisible(visible);
        lblPNC.setVisible(visible);
        txtPNC.setVisible(visible);
        lblAddress.setVisible(visible);
        txtAddress.setVisible(visible);
        btnUpdateClient.setVisible(visible);
    }

    private void setAddAccountOptions(boolean visible)
    {
        lblID.setBounds(lblOldID.getX(),lblOldID.getY(),lblID.getPreferredSize().width,lblID.getPreferredSize().height);
        setAccountComponentsPositions();
        lblID.setVisible(visible);
        txtID.setVisible(visible);
        lblType.setVisible(visible);
        cbType.setVisible(visible);
        lblFunds.setVisible(visible);
        txtFunds.setVisible(visible);
        lblOwnerPNC.setVisible(visible);
        txtOwnerPNC.setVisible(visible);
        btnAddAccount.setVisible(visible);
    }

    private void setUpdateAccountOptions(boolean visible)
    {
        lblOldID.setVisible(visible);
        txtOldID.setVisible(visible);
        lblID.setBounds(txtOldID.getX()+txtOldID.getWidth()+HS,lblOldID.getY(),lblID.getPreferredSize().width,lblID.getPreferredSize().height);
        setAccountComponentsPositions();
        lblID.setVisible(visible);
        txtID.setVisible(visible);
        lblType.setVisible(visible);
        cbType.setVisible(visible);
        lblFunds.setVisible(visible);
        txtFunds.setVisible(visible);
        lblOwnerPNC.setVisible(visible);
        txtOwnerPNC.setVisible(visible);
        btnUpdateAccount.setVisible(visible);
    }

    
    private void showMessage(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
}