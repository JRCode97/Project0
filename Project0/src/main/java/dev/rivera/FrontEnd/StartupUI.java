package dev.rivera.FrontEnd;



import javax.swing.*;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.LinkedList;

import javax.swing.event.*;

import dev.rivera.daos.*;
import dev.rivera.services.*;
import dev.rivera.utils.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartupUI {
	//private BankAccountDAO bad = new BankAccountDAOdb();
	private UserDAO ud = new UserDAOdb();

	private JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;
	private JPanel container;
	private CardLayout cl;
	private JPanel regUserPanel = new JPanel();
	private JPanel superUserPanel = new JPanel();
	private JPanel startupPanel = new JPanel();
	private JPanel signupPanel= new JPanel();
	private JPanel TransactionPanel= new JPanel();
	private JPanel EditUserPanel= new JPanel();
	private JPanel AddUserPanel= new JPanel();
	
	private User selectedUser = null;
	
	private JButton signUp;
	private JLabel newUserLbl;
	private JLabel lblNewLabel;
	private JLabel unsuLbl;
	private JTextField unTF;
	private JLabel lblNewLabel_2;
	private JLabel pwsuLbl;
	private JTextField fnTF;
	private JPasswordField pwTF;
	private JTextField lnTF;
	private JTextField emTF;
	private JTextField pnTF;
	private JTextField addressTF;
	private JTextField stateTF;
	private JTextField zipTF;
	private JTextField cTF;
	private JLabel lblAreYouAn;
	private JLabel lblNewLabel_4;
	private User currentUser = null;
	private BankAccount currentBankAccount;
	private ArrayList<BankAccount> bankAccounts;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
	private JLabel lblNewLabel_6;
	private JList<User> UserList;
	private JList<BankAccount> bankAccountList;
	
	private UserService us = new UserServiceimpl();
	private AdminAbility aa = new AdminAbilityimpl();
	private JLabel lblNewLabel_7;
	private JButton DeleteAccountBtn;
	private JButton TransactionBtn;
	private JButton regSignOut;
	private JButton superSignOut;
	
	DefaultListModel<User>sudlm = new DefaultListModel<User>();
	
	
	private JLabel lblNewLabel_8;
	private JList<Transaction> list_1;
	private JButton backToDashBtn;
	private JTextField dwAmount;
	private JLabel lblNewLabel_10;
	private JLabel unsuLbl_1;
	private JTextField addUsernameTF;
	private JLabel lblNewLabel_11;
	private JLabel pwsuLbl_1;
	private JTextField AddFirstNameTF;
	private JLabel firstNameLbl_1;
	private JPasswordField addPasswordTF;
	private JTextField addLastNameTF;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_3_2;
	private JTextField addEmailTF;
	private JTextField addPhoneTF;
	private JLabel lblNewLabel_3_1_2;
	private JLabel lblNewLabel_2_2;
	private JLabel aLbl_1;
	private JTextField addAddressTF;
	private JLabel cLbl_1;
	private JLabel sLbl_1;
	private JTextField addStateTF;
	private JLabel Zip_1;
	private JTextField addZipTF;
	private JTextField addCityTF;
	private JLabel lblNewLabel_2_1_2;
	private JLabel lblAreYouAn_1;
	private JRadioButton rdbtnYes_1;
	private JRadioButton rdbtnNo_1;
	private JButton superUseraddBtn;
	private JLabel lblNewLabel_13;
	private JLabel unsuLbl_2;
	private JTextField editUsernameTF;
	private JLabel lblNewLabel_14;
	private JLabel pwsuLbl_2;
	private JTextField editFirstNameTF;
	private JLabel firstNameLbl_2;
	private JPasswordField editPasswordTF;
	private JTextField editLastNameTF;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_3_3;
	private JTextField editEmailTF;
	private JTextField editPhoneTF;
	private JLabel lblNewLabel_3_1_3;
	private JLabel lblNewLabel_2_3;
	private JLabel aLbl_2;
	private JTextField editAddressTF;
	private JLabel cLbl_2;
	private JLabel sLbl_2;
	private JTextField editStateTF;
	private JLabel Zip_2;
	private JTextField editZipTF;
	private JTextField editCityTF;
	private JLabel lblNewLabel_2_1_3;
	private JLabel lblAreYouAn_2;
	private JRadioButton rdbtnYes_2;
	private JRadioButton rdbtnNo_2;
	private JButton editUpdateBtn;
	private JButton edittodashBtn;
	private JButton addtodashBtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartupUI window = new StartupUI();
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
	public StartupUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(800,600);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = new JPanel();
		container.setSize(794, 565);
		container.setLocation(0, 0);
		cl = new CardLayout();
		container.setLayout(cl);
		startupPanel.setLayout(null);
		
		startupPanel.setBackground(Color.black);
		frame.getContentPane().add(container);
		
		
		JLabel unLbl = new JLabel("Username");
		unLbl.setForeground(Color.WHITE);
		unLbl.setFont(new Font("Consolas", Font.PLAIN, 18));
		unLbl.setBounds(224, 177, 87, 16);
		//frame.getContentPane().add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(364, 177, 186, 22);
		//frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel pwLbl = new JLabel("Password");
		pwLbl.setForeground(Color.WHITE);
		pwLbl.setFont(new Font("Consolas", Font.PLAIN, 18));
		pwLbl.setBounds(224, 254, 87, 16);
		//frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(364, 250, 186, 22);
		//frame.getContentPane().add(passwordField);
		
		JButton signinBtn = new JButton("Sign In");
		signinBtn.addActionListener(e ->{
			String un = username.getText();
			String pw = new String(passwordField.getPassword());
			currentUser = ud.signinUser(un, pw);
			if(currentUser == null) {
				System.out.println("Wrong login credentials");
			}
			else {
				if(!currentUser.isAdmin()) {
				this.loadupRegUserDash();
				cl.show(container,"3");}
				else {sudlm.removeAllElements();
					this.loadSuperUserDash();
					cl.show(container, "4");}
			}
			

		});
		signinBtn.setBounds(420, 309, 130, 35);
		//frame.getContentPane().add(signinBtn);
		startupPanel.add(unLbl);
		startupPanel.add(username);
		startupPanel.add(passwordField);
		startupPanel.add(pwLbl);
		startupPanel.add(signinBtn);
		
		container.add(startupPanel,"1");
		container.add(signupPanel,"2");
		container.add(regUserPanel,"3");
		container.add(superUserPanel,"4");
		container.add(TransactionPanel,"5");
		container.add(AddUserPanel,"6");

		container.add(EditUserPanel,"7");

		regUserPanel.setLayout(null);
		

		container.add(superUserPanel,"4");

		signUp = new JButton("Sign Up");
		signUp.addActionListener(e->{
			this.loadSignUpPanel();
			cl.show(container, "2");
		});
		signUp.setBounds(330, 493, 97, 25);
		startupPanel.add(signUp);
		
		newUserLbl = new JLabel("New User?");
		newUserLbl.setForeground(Color.WHITE);
		newUserLbl.setFont(new Font("Consolas", Font.PLAIN, 18));
		newUserLbl.setBounds(329, 438, 124, 29);
		startupPanel.add(newUserLbl);
		
		JLabel lblNewLabel_1 = new JLabel("Log in");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_1.setBounds(350, 13, 77, 22);
		startupPanel.add(lblNewLabel_1);
		
	

		cl.show(container, "1");
		AddUserPanel.setLayout(null);

	}
	public void signUp() {
		
		signupPanel.setLayout(null);
		cl.show(container,"2");
		
	}
	public void loadupRegUserDash() {
		regUserPanel.setLayout(null);
		regUserPanel.setBackground(Color.black);
		lblNewLabel_4 = new JLabel("User Dashboard");
		lblNewLabel_4.setForeground(Color.blue);
		lblNewLabel_4.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_4.setBounds(305, 13, 160, 16);
		regUserPanel.add(lblNewLabel_4);
		lblNewLabel_5 = new JLabel("Add Bank Account");
		lblNewLabel_5.setForeground(Color.white);
		lblNewLabel_5.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(123, 405, 177, 16);
		regUserPanel.add(lblNewLabel_5);
		DefaultListModel<BankAccount>dlm = new DefaultListModel<BankAccount>();	
		btnNewButton = new JButton("+");
		btnNewButton.setBackground(Color.green);
		btnNewButton.setBounds(176, 434, 50, 50);
		btnNewButton.addActionListener(e->{
			BankAccount openedAcc = us.openAccount(currentUser);
			//dlm.addElement(openedAcc);
		});
		regUserPanel.add(btnNewButton);
		
		
		lblNewLabel_7 = new JLabel("Delete Account");
		lblNewLabel_7.setForeground(Color.white);
		lblNewLabel_7.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(325, 405, 177, 16);
		regUserPanel.add(lblNewLabel_7);


		DeleteAccountBtn = new JButton("-");
		DeleteAccountBtn.setBackground(Color.red);
		DeleteAccountBtn.setBounds(365, 434, 49, 49);
		DeleteAccountBtn.addActionListener(e->{
			int index = bankAccountList.getSelectedIndex();
			currentBankAccount = bankAccountList.getSelectedValue();
			boolean b = us.deleteAccount(currentBankAccount);
			if(b)
				dlm.removeElementAt(index);
			
			currentBankAccount = null;
		});
		regUserPanel.add(DeleteAccountBtn);
		
		TransactionBtn = new JButton("View Transactions");
		TransactionBtn.setBounds(607, 425, 143, 66);
		TransactionBtn.addActionListener(e->{
			currentBankAccount = bankAccountList.getSelectedValue();
			System.out.println(currentBankAccount);
			this.loadTransactionPanel();
			cl.show(container, "5");
		});
		regUserPanel.add(TransactionBtn);
		
		regSignOut = new JButton("Log out");
		regSignOut.setBounds(12, 13, 97, 25);
		regSignOut.addActionListener(e->{
			currentUser = null;
			currentBankAccount = null;
			username.setText("");
			passwordField.setText("");
			cl.show(container, "1");
		});
		regUserPanel.add(regSignOut);
		


		bankAccountList = new JList<BankAccount>(dlm);
		bankAccountList.setBounds(96, 100, 597, 100);
		bankAccountList.setModel(dlm);

		List<BankAccount> accounts = us.getBankAccounts(currentUser);
		for(BankAccount acc:accounts) {
			

			dlm.addElement(acc);

		}

		btnNewButton.addActionListener(e->{
			BankAccount newacc = us.openAccount(currentUser);
			dlm.addElement(newacc);
			
		});
		

		

		
		regUserPanel.add(bankAccountList);
	}
	public void loadAddUser() {
		AddUserPanel.setBackground(Color.black);
		lblNewLabel_10 = new JLabel("Add New User");
		lblNewLabel_10.setForeground(Color.blue);
		lblNewLabel_10.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_10.setBounds(356, 31, 144, 16);
		AddUserPanel.add(lblNewLabel_10);
		
		unsuLbl_1 = new JLabel("Username");
		unsuLbl_1.setForeground(Color.white);
		unsuLbl_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		unsuLbl_1.setBounds(65, 94, 72, 16);
		AddUserPanel.add(unsuLbl_1);
		
		addUsernameTF = new JTextField();
		addUsernameTF.setColumns(10);
		addUsernameTF.setBounds(158, 90, 116, 22);
		AddUserPanel.add(addUsernameTF);
		
		lblNewLabel_11 = new JLabel("Login info:");
		lblNewLabel_11.setForeground(Color.orange);
		lblNewLabel_11.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(42, 48, 138, 16);
		AddUserPanel.add(lblNewLabel_11);
		
		pwsuLbl_1 = new JLabel("Password");
		pwsuLbl_1.setForeground(Color.white);
		pwsuLbl_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		pwsuLbl_1.setBounds(65, 151, 72, 16);
		AddUserPanel.add(pwsuLbl_1);
		
		AddFirstNameTF = new JTextField();
		AddFirstNameTF.setColumns(10);
		AddFirstNameTF.setBounds(158, 203, 116, 22);
		AddUserPanel.add(AddFirstNameTF);
		
		firstNameLbl_1 = new JLabel("First Name");
		firstNameLbl_1.setForeground(Color.white);
		firstNameLbl_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		firstNameLbl_1.setBounds(65, 207, 90, 16);
		AddUserPanel.add(firstNameLbl_1);
		
		addPasswordTF = new JPasswordField();
		addPasswordTF.setBounds(158, 147, 116, 22);
		AddUserPanel.add(addPasswordTF);
		
		addLastNameTF = new JTextField();
		addLastNameTF.setColumns(10);
		addLastNameTF.setBounds(158, 264, 116, 22);
		AddUserPanel.add(addLastNameTF);
		
		lblNewLabel_12 = new JLabel("Address");
		lblNewLabel_12.setForeground(Color.white);
		lblNewLabel_12.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(530, 94, 80, 16);
		AddUserPanel.add(lblNewLabel_12);
		
		lblNewLabel_3_2 = new JLabel("Email ");
		lblNewLabel_3_2.setForeground(Color.white);
		lblNewLabel_3_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(65, 326, 90, 16);
		AddUserPanel.add(lblNewLabel_3_2);
		
		addEmailTF = new JTextField();
		addEmailTF.setColumns(10);
		addEmailTF.setBounds(156, 322, 116, 22);
		AddUserPanel.add(addEmailTF);
		
		addPhoneTF = new JTextField();
		addPhoneTF.setColumns(10);
		addPhoneTF.setBounds(157, 378, 116, 22);
		AddUserPanel.add(addPhoneTF);
		
		lblNewLabel_3_1_2 = new JLabel("Phone");
		lblNewLabel_3_1_2.setForeground(Color.white);
		lblNewLabel_3_1_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(65, 382, 90, 16);
		AddUserPanel.add(lblNewLabel_3_1_2);
		
		lblNewLabel_2_2 = new JLabel("Address info:");
		lblNewLabel_2_2.setForeground(Color.orange);
		lblNewLabel_2_2.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(499, 48, 138, 16);
		AddUserPanel.add(lblNewLabel_2_2);
		
		aLbl_1 = new JLabel("Zip Code");
		aLbl_1.setForeground(Color.white);
		aLbl_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		aLbl_1.setBounds(530, 264, 116, 22);
		AddUserPanel.add(aLbl_1);
		
		addAddressTF = new JTextField();
		addAddressTF.setColumns(10);
		addAddressTF.setBounds(623, 90, 116, 22);
		AddUserPanel.add(addAddressTF);
		
		cLbl_1 = new JLabel("City");
		cLbl_1.setForeground(Color.white);
		cLbl_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		cLbl_1.setBounds(530, 151, 72, 16);
		AddUserPanel.add(cLbl_1);
		
		sLbl_1 = new JLabel("State");
		sLbl_1.setForeground(Color.white);
		sLbl_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		sLbl_1.setBounds(530, 204, 116, 22);
		AddUserPanel.add(sLbl_1);
		
		addStateTF = new JTextField();
		addStateTF.setColumns(10);
		addStateTF.setBounds(623, 203, 116, 22);
		AddUserPanel.add(addStateTF);
		
		Zip_1 = new JLabel("Last Name ");
		Zip_1.setForeground(Color.white);
		Zip_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		Zip_1.setBounds(65, 268, 90, 16);
		AddUserPanel.add(Zip_1);
		
		addZipTF = new JTextField();
		addZipTF.setColumns(10);
		addZipTF.setBounds(623, 264, 116, 22);
		AddUserPanel.add(addZipTF);
		
		addCityTF = new JTextField();
		addCityTF.setColumns(10);
		addCityTF.setBounds(623, 147, 116, 22);
		AddUserPanel.add(addCityTF);
		
		lblNewLabel_2_1_2 = new JLabel("Additional info:");
		lblNewLabel_2_1_2.setForeground(Color.orange);
		lblNewLabel_2_1_2.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(503, 287, 175, 22);
		AddUserPanel.add(lblNewLabel_2_1_2);
		
		lblAreYouAn_1 = new JLabel("Are you an Admin?");
		lblAreYouAn_1.setForeground(Color.white);
		lblAreYouAn_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblAreYouAn_1.setBounds(534, 332, 144, 16);
		AddUserPanel.add(lblAreYouAn_1);
		
		rdbtnYes_1 = new JRadioButton("yes");
		rdbtnYes_1.setForeground(Color.white);
		rdbtnYes_1.setBackground(Color.black);
		rdbtnYes_1.setBounds(534, 370, 61, 25);
		AddUserPanel.add(rdbtnYes_1);
		
		rdbtnNo_1 = new JRadioButton("no");
		rdbtnNo_1.setForeground(Color.white);
		rdbtnNo_1.setBackground(Color.black);
		rdbtnNo_1.setBounds(600, 370, 61, 25);
		AddUserPanel.add(rdbtnNo_1);
		
		superUseraddBtn = new JButton("Add user");
		superUseraddBtn.setBackground(Color.green);
		superUseraddBtn.setBounds(613, 465, 130, 35);
		superUseraddBtn.addActionListener(e->{
			selectedUser = new User();
			selectedUser.setUserName(addUsernameTF.getText());
			selectedUser.setPassWord(new String(addPasswordTF.getPassword()));
			selectedUser.setFirstName(AddFirstNameTF.getText());
			selectedUser.setLastName(addLastNameTF.getText());
			selectedUser.setEmail(addEmailTF.getText());
			selectedUser.setPhone(addPhoneTF.getText());
			selectedUser.setAddress(addAddressTF.getText());
			selectedUser.setCity(addCityTF.getText());
			selectedUser.setState(addStateTF.getText());
			selectedUser.setZip(Integer.parseInt(addZipTF.getText()));
			if(rdbtnYes_1.isSelected())
				selectedUser.setAdmin(true);
			else if(rdbtnNo_1.isSelected())
				selectedUser.setAdmin(false);
			
			selectedUser=ud.createUser(selectedUser);
			addUsernameTF.setText("");
			addPasswordTF.setText("");
			AddFirstNameTF.setText("");
			addLastNameTF.setText("");
			addEmailTF.setText("");
			addPhoneTF.setText("");
			addAddressTF.setText("");
			addCityTF.setText("");
			addStateTF.setText("");
			addZipTF.setText("");
			sudlm.addElement(selectedUser);
//			this.loadSuperUserDash();
//			cl.addLayoutComponent(container, "4");
		});
		AddUserPanel.add(superUseraddBtn);
		
		addtodashBtn = new JButton("< Dashboard");
		addtodashBtn.setBounds(46, 13, 106, 25);
		addtodashBtn.addActionListener(e->{
			sudlm.removeAllElements();
			this.loadSuperUserDash();
			cl.show(container,"4");
		});
		AddUserPanel.add(addtodashBtn);
	}
	public void loadSuperUserDash() {
		superUserPanel.setLayout(null);
		superUserPanel.setBackground(Color.black);
		lblNewLabel_6 = new JLabel("Admin Dashboard");
		lblNewLabel_6.setForeground(Color.blue);
		lblNewLabel_6.setBounds(319, 5, 180, 24);
		lblNewLabel_6.setFont(new Font("Consolas", Font.BOLD, 20));
		superUserPanel.add(lblNewLabel_6);
		
		UserList = new JList<User>();
		
		UserList.setModel(sudlm);
		List<User> users = aa.getAllUsers();
		for(User curr:users) {
			System.out.println(curr);
			sudlm.addElement(curr);
		}
		
		

		UserList.setBounds(100, 63, 600, 250);
		superUserPanel.add(UserList);
		
		JButton deleteUserBtn = new JButton("-");
		deleteUserBtn.setBackground(Color.red);
		deleteUserBtn.setBounds(100, 451, 50, 50);
		deleteUserBtn.addActionListener(e->{
			int index = UserList.getSelectedIndex();
			User u = UserList.getSelectedValue();
			if(u!=null) {
			aa.deleteUser(u.getUserId());
			sudlm.removeElementAt(index);
			currentBankAccount = null;}
		});
		superUserPanel.add(deleteUserBtn);
		
		JLabel lblNewLabel_9 = new JLabel("Delete User");
		lblNewLabel_9.setForeground(Color.white);
		lblNewLabel_9.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(69, 406, 150, 24);
		superUserPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Add User");
		lblNewLabel_9_1.setForeground(Color.white);
		lblNewLabel_9_1.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_9_1.setBounds(312, 406, 100, 24);
		superUserPanel.add(lblNewLabel_9_1);
		
		JButton addUserBtn = new JButton("+");
		addUserBtn.setBackground(Color.green);
		addUserBtn.setBounds(328, 451, 50, 50);
		addUserBtn.addActionListener(e->{
			this.loadAddUser();
			cl.show(container, "6");
		});
		superUserPanel.add(addUserBtn);
		
		JButton editUserBtn = new JButton("Edit User");
		editUserBtn.addActionListener(e->{
			this.EditUserPanel();
			selectedUser = UserList.getSelectedValue();
			System.out.println(UserList.getSelectedValue());
			if(selectedUser!=null) {
			editUsernameTF.setText(selectedUser.getUserName());
			editPasswordTF.setText(selectedUser.getPassWord());
			editFirstNameTF.setText(selectedUser.getFirstName());
			editLastNameTF.setText(selectedUser.getLastName());
			editEmailTF.setText(selectedUser.getEmail());
			editPhoneTF.setText(selectedUser.getPhone());
			editAddressTF.setText(selectedUser.getAddress());
			editCityTF.setText(selectedUser.getCity());
			editStateTF.setText(selectedUser.getState());
			editZipTF.setText(Integer.toString(selectedUser.getZip()));
			if(selectedUser.isAdmin()) {
				rdbtnYes_2.setSelected(true);
			}
			else if(!selectedUser.isAdmin()) {
				rdbtnNo_2.setSelected(true);
			}
			//textField_1.setText("hello");
			//textField_1.setText(u.getUserName());
			

			cl.show(container, "7");
			}
	
				
		}

		);
		editUserBtn.setBounds(535, 451, 165, 50);
		superUserPanel.add(editUserBtn);
		
		
		superSignOut = new JButton("Log out");
		superSignOut.setBounds(12, 13, 97, 25);
		superSignOut.addActionListener(e->{
			currentUser = null;
			currentBankAccount = null;
			username.setText("");
			passwordField.setText("");
			cl.show(container, "1");
		});
		superUserPanel.add(superSignOut);
	}
	public void loadTransactionPanel() {
		TransactionPanel.setBackground(Color.black);
		edittodashBtn = new JButton("< Dashboard");
		edittodashBtn.setBounds(31, 13, 106, 25);
		EditUserPanel.add(edittodashBtn);
		TransactionPanel.setLayout(null);
		
		lblNewLabel_8 = new JLabel("Transactions");
		lblNewLabel_8.setForeground(Color.blue);
		lblNewLabel_8.setBounds(329, 13, 141, 24);
		lblNewLabel_8.setFont(new Font("Consolas", Font.BOLD, 20));
		TransactionPanel.add(lblNewLabel_8);
		DefaultListModel<Transaction>tdlm = new DefaultListModel<Transaction>();
		list_1 = new JList<Transaction>(tdlm);
		list_1.setBounds(201, 106, 400, 200);
		

		list_1.setModel(tdlm);

		List<Transaction> trans = us.getTransactions(currentBankAccount);
		if(trans!=null) {
		for(Transaction tran:trans) {
			
			System.out.println(tran);
			tdlm.addElement(tran);

		}}
		TransactionPanel.add(list_1);
		
		backToDashBtn = new JButton("< Dashboard");
		backToDashBtn.addActionListener(e->{
			cl.show(container, "3");
			currentBankAccount = null;
			tdlm.removeAllElements();
		});
		backToDashBtn.setBounds(34, 13, 124, 38);
		TransactionPanel.add(backToDashBtn);
		
		dwAmount = new JTextField();
		dwAmount.setBounds(354, 358, 116, 22);
		TransactionPanel.add(dwAmount);
		dwAmount.setColumns(10);
		
		JButton depositBtn = new JButton("Deposit");
		depositBtn.setBackground(Color.green);
		depositBtn.setBounds(250, 416, 137, 45);
		depositBtn.addActionListener(e->{
			if(this.isNumber(dwAmount.getText())) {
			if(!dwAmount.getText().equals("")) {
			Transaction tran = us.addFunds(currentBankAccount, Double.parseDouble(dwAmount.getText()));
			tdlm.addElement(tran);
			dwAmount.setText("");}}
		});
		TransactionPanel.add(depositBtn);
		
		JButton WithdrawlBtn = new JButton("Withdraw");
		WithdrawlBtn.setBackground(Color.red);
		WithdrawlBtn.addActionListener(e->{
			if(this.isNumber(dwAmount.getText())) {
			if(!dwAmount.getText().equals("")) {
			Transaction tran = us.withdrawFunds(currentBankAccount, Double.parseDouble(dwAmount.getText()));
			tdlm.addElement(tran);
			dwAmount.setText("");}}
		});
		WithdrawlBtn.setBounds(444, 416, 137, 45);
		TransactionPanel.add(WithdrawlBtn);
	}
	public void loadSignUpPanel() {
		signupPanel.setLayout(null);
		signupPanel.setBackground(Color.black);
		lblNewLabel = new JLabel("Register");
		lblNewLabel.setForeground(Color.blue);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setBounds(326, 13, 90, 16);
		signupPanel.add(lblNewLabel);
		
		unsuLbl = new JLabel("Username");
		unsuLbl.setForeground(Color.white);
		unsuLbl.setFont(new Font("Consolas", Font.PLAIN, 14));
		unsuLbl.setBounds(35, 76, 72, 16);
		signupPanel.add(unsuLbl);
		
		unTF = new JTextField();
		unTF.setBounds(128, 72, 116, 22);
		signupPanel.add(unTF);
		unTF.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Login info:");
		lblNewLabel_2.setForeground(Color.orange);
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(12, 30, 138, 16);
		signupPanel.add(lblNewLabel_2);
		
		pwsuLbl = new JLabel("Password");
		pwsuLbl.setForeground(Color.white);
		pwsuLbl.setFont(new Font("Consolas", Font.PLAIN, 14));
		pwsuLbl.setBounds(35, 133, 72, 16);
		signupPanel.add(pwsuLbl);
		
		fnTF = new JTextField();
		fnTF.setColumns(10);
		fnTF.setBounds(128, 185, 116, 22);
		signupPanel.add(fnTF);
		
		JLabel firstNameLbl = new JLabel("First Name");
		firstNameLbl.setForeground(Color.white);
		firstNameLbl.setFont(new Font("Consolas", Font.PLAIN, 14));
		firstNameLbl.setBounds(35, 189, 90, 16);
		signupPanel.add(firstNameLbl);
		
		pwTF = new JPasswordField();
		pwTF.setBounds(128, 129, 116, 22);
		signupPanel.add(pwTF);
		
		lnTF = new JTextField();
		lnTF.setColumns(10);
		lnTF.setBounds(128, 246, 116, 22);
		signupPanel.add(lnTF);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name ");
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(35, 250, 90, 16);
		signupPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Email ");
		lblNewLabel_3_1.setForeground(Color.white);
		lblNewLabel_3_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(35, 308, 90, 16);
		signupPanel.add(lblNewLabel_3_1);
		
		emTF = new JTextField();
		emTF.setColumns(10);
		emTF.setBounds(126, 304, 116, 22);
		signupPanel.add(emTF);
		
		pnTF = new JTextField();
		pnTF.setColumns(10);
		pnTF.setBounds(127, 360, 116, 22);
		signupPanel.add(pnTF);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Phone");
		lblNewLabel_3_1_1.setForeground(Color.white);
		lblNewLabel_3_1_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(35, 364, 90, 16);
		signupPanel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Address info:");
		lblNewLabel_2_1.setForeground(Color.orange);
		lblNewLabel_2_1.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(469, 30, 138, 16);
		signupPanel.add(lblNewLabel_2_1);
		
		JLabel aLbl = new JLabel("Address");
		aLbl.setForeground(Color.white);
		aLbl.setFont(new Font("Consolas", Font.PLAIN, 14));
		aLbl.setBounds(500, 76, 72, 16);
		signupPanel.add(aLbl);
		
		addressTF = new JTextField();
		addressTF.setColumns(10);
		addressTF.setBounds(593, 72, 116, 22);
		signupPanel.add(addressTF);
		
		JLabel cLbl = new JLabel("City");
		cLbl.setForeground(Color.white);
		cLbl.setFont(new Font("Consolas", Font.PLAIN, 14));
		cLbl.setBounds(500, 133, 72, 16);
		signupPanel.add(cLbl);
		
		JLabel sLbl = new JLabel("State");
		sLbl.setForeground(Color.white);
		sLbl.setFont(new Font("Consolas", Font.PLAIN, 14));
		sLbl.setBounds(500, 189, 90, 16);
		signupPanel.add(sLbl);
		
		stateTF = new JTextField();
		stateTF.setColumns(10);
		stateTF.setBounds(593, 185, 116, 22);
		signupPanel.add(stateTF);
		
		JLabel Zip = new JLabel("Last Name ");
		Zip.setForeground(Color.white);
		Zip.setFont(new Font("Consolas", Font.PLAIN, 14));
		Zip.setBounds(500, 250, 90, 16);
		signupPanel.add(Zip);
		
		zipTF = new JTextField();
		zipTF.setColumns(10);
		zipTF.setBounds(593, 246, 116, 22);
		signupPanel.add(zipTF);
		
		cTF = new JTextField();
		cTF.setColumns(10);
		cTF.setBounds(593, 129, 116, 22);
		signupPanel.add(cTF);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Additional info:");
		lblNewLabel_2_1_1.setForeground(Color.orange);
		lblNewLabel_2_1_1.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(469, 282, 175, 16);
		signupPanel.add(lblNewLabel_2_1_1);
		
		lblAreYouAn = new JLabel("Are you an Admin?");
		lblAreYouAn.setForeground(Color.white);
		lblAreYouAn.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblAreYouAn.setBounds(500, 321, 144, 16);
		signupPanel.add(lblAreYouAn);
		
		JRadioButton rdbtnYes = new JRadioButton("yes");
		rdbtnYes.setForeground(Color.white);
		rdbtnYes.setBackground(Color.black);
		rdbtnYes.setBounds(500, 359, 61, 25);
		signupPanel.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("no");
		rdbtnNo.setForeground(Color.white);
		rdbtnNo.setBackground(Color.black);
		rdbtnNo.setBounds(566, 359, 61, 25);
		signupPanel.add(rdbtnNo);
		
		JButton siBtn = new JButton("Sign In");
		siBtn.addActionListener(e->{
			cl.show(container,"1");
		});
		siBtn.setBounds(116, 464, 97, 25);
		signupPanel.add(siBtn);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("already registered?");
		lblNewLabel_2_1_1_1.setForeground(Color.white);
		lblNewLabel_2_1_1_1.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(64, 429, 201, 22);
		signupPanel.add(lblNewLabel_2_1_1_1);
		
		JButton suBtn = new JButton("Sign Up");
		suBtn.addActionListener(e->{
			String username = unTF.getText();
			String pword = new String(pwTF.getPassword());
			String fn = fnTF.getText();
			String ln = lnTF.getText();
			String email = emTF.getText();
			String pn = pnTF.getText();
			String ad = addressTF.getText();
			String city = cTF.getText();
			String state = stateTF.getText();
			int zip = Integer.parseInt(zipTF.getText());
			boolean isAdmin = rdbtnYes.isSelected();
			boolean notAdmin = rdbtnNo.isSelected();
			User u = new User(0,username,pword,fn,ln,email,pn,ad,city,state,zip,isAdmin);
			currentUser = ud.signupUser(u);
			System.out.println(currentUser);
			if(currentUser!=null) {
				if(!currentUser.isAdmin()) {
				this.loadupRegUserDash();
				cl.show(container,"3");}
				else {this.loadSuperUserDash();
					cl.show(container, "4");}
			}
			
		});
		suBtn.setBounds(579, 454, 130, 35);
		signupPanel.add(suBtn);
	}
	public void EditUserPanel() {
		EditUserPanel.setLayout(null);
		EditUserPanel.setBackground(Color.black);
		lblNewLabel_13 = new JLabel("Edit User");
		lblNewLabel_13.setForeground(Color.blue);
		lblNewLabel_13.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_13.setBounds(356, 31, 108, 16);
		EditUserPanel.add(lblNewLabel_13);
		
		unsuLbl_2 = new JLabel("Username");
		unsuLbl_2.setForeground(Color.white);
		unsuLbl_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		unsuLbl_2.setBounds(65, 94, 72, 16);
		EditUserPanel.add(unsuLbl_2);
		
		editUsernameTF = new JTextField();

		editUsernameTF.setColumns(10);
		editUsernameTF.setBounds(158, 90, 116, 22);
		EditUserPanel.add(editUsernameTF);
		
		lblNewLabel_14 = new JLabel("Login info:");
		lblNewLabel_14.setForeground(Color.orange);
		lblNewLabel_14.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_14.setBounds(42, 48, 138, 16);
		EditUserPanel.add(lblNewLabel_14);
		
		pwsuLbl_2 = new JLabel("Password");
		pwsuLbl_2.setForeground(Color.white);
		pwsuLbl_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		pwsuLbl_2.setBounds(65, 151, 72, 16);
		EditUserPanel.add(pwsuLbl_2);
		
		editFirstNameTF = new JTextField();
		editFirstNameTF.setColumns(10);
		editFirstNameTF.setBounds(158, 203, 116, 22);
		EditUserPanel.add(editFirstNameTF);
		
		firstNameLbl_2 = new JLabel("First Name");
		firstNameLbl_2.setForeground(Color.white);
		firstNameLbl_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		firstNameLbl_2.setBounds(65, 207, 90, 16);
		EditUserPanel.add(firstNameLbl_2);
		
		editPasswordTF = new JPasswordField();
		editPasswordTF.setBounds(158, 147, 116, 22);
		EditUserPanel.add(editPasswordTF);
		
		editLastNameTF = new JTextField();
		editLastNameTF.setColumns(10);
		editLastNameTF.setBounds(158, 264, 116, 22);
		EditUserPanel.add(editLastNameTF);
		
		lblNewLabel_15 = new JLabel("Last Name ");
		lblNewLabel_15.setForeground(Color.white);
		lblNewLabel_15.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(65, 268, 90, 16);
		EditUserPanel.add(lblNewLabel_15);
		
		lblNewLabel_3_3 = new JLabel("Email ");
		lblNewLabel_3_3.setForeground(Color.white);
		lblNewLabel_3_3.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(65, 326, 90, 16);
		EditUserPanel.add(lblNewLabel_3_3);
		
		editEmailTF = new JTextField();
		editEmailTF.setColumns(10);
		editEmailTF.setBounds(156, 322, 116, 22);
		EditUserPanel.add(editEmailTF);
		
		editPhoneTF = new JTextField();
		editPhoneTF.setColumns(10);
		editPhoneTF.setBounds(157, 378, 116, 22);
		EditUserPanel.add(editPhoneTF);
		
		lblNewLabel_3_1_3 = new JLabel("Phone");
		lblNewLabel_3_1_3.setForeground(Color.white);
		lblNewLabel_3_1_3.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_3_1_3.setBounds(65, 382, 90, 16);
		EditUserPanel.add(lblNewLabel_3_1_3);
		
		lblNewLabel_2_3 = new JLabel("Address info:");
		lblNewLabel_2_3.setForeground(Color.orange);
		lblNewLabel_2_3.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(499, 48, 138, 16);
		EditUserPanel.add(lblNewLabel_2_3);
		
		aLbl_2 = new JLabel("Address");
		aLbl_2.setForeground(Color.white);
		aLbl_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		aLbl_2.setBounds(530, 94, 72, 16);
		EditUserPanel.add(aLbl_2);
		
		editAddressTF = new JTextField();
		editAddressTF.setColumns(10);
		editAddressTF.setBounds(623, 90, 116, 22);
		EditUserPanel.add(editAddressTF);
		
		cLbl_2 = new JLabel("City");
		cLbl_2.setForeground(Color.white);
		cLbl_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		cLbl_2.setBounds(530, 151, 72, 16);
		EditUserPanel.add(cLbl_2);
		
		sLbl_2 = new JLabel("State");
		sLbl_2.setForeground(Color.white);
		sLbl_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		sLbl_2.setBounds(530, 207, 90, 16);
		EditUserPanel.add(sLbl_2);
		
		editStateTF = new JTextField();
		editStateTF.setColumns(10);
		editStateTF.setBounds(623, 203, 116, 22);
		EditUserPanel.add(editStateTF);
		
		Zip_2 = new JLabel("Zip Code");
		Zip_2.setForeground(Color.white);
		Zip_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		Zip_2.setBounds(530, 268, 90, 16);
		EditUserPanel.add(Zip_2);
		
		editZipTF = new JTextField();
		editZipTF.setColumns(10);
		editZipTF.setBounds(623, 264, 116, 22);
		EditUserPanel.add(editZipTF);
		
		editCityTF = new JTextField();
		editCityTF.setColumns(10);
		editCityTF.setBounds(623, 147, 116, 22);
		EditUserPanel.add(editCityTF);
		
		lblNewLabel_2_1_3 = new JLabel("Additional info:");
		lblNewLabel_2_1_3.setForeground(Color.orange);
		lblNewLabel_2_1_3.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNewLabel_2_1_3.setBounds(499, 300, 175, 16);
		EditUserPanel.add(lblNewLabel_2_1_3);
		
		lblAreYouAn_2 = new JLabel("Are you an Admin?");
		lblAreYouAn_2.setForeground(Color.white);
		lblAreYouAn_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblAreYouAn_2.setBounds(530, 339, 144, 16);
		EditUserPanel.add(lblAreYouAn_2);
		
		rdbtnYes_2 = new JRadioButton("yes");
		rdbtnYes_2.setForeground(Color.white);
		rdbtnYes_2.setBackground(Color.black);
		rdbtnYes_2.setBounds(530, 377, 61, 25);
		EditUserPanel.add(rdbtnYes_2);
		
		rdbtnNo_2 = new JRadioButton("no");
		rdbtnNo_2.setForeground(Color.white);
		rdbtnNo_2.setBackground(Color.black);
		rdbtnNo_2.setBounds(596, 377, 61, 25);
		EditUserPanel.add(rdbtnNo_2);
		
		editUpdateBtn = new JButton("Update");
		editUpdateBtn.setBounds(609, 472, 130, 35);
		editUpdateBtn.addActionListener(e->{
			selectedUser.setUserName(editUsernameTF.getText());
			selectedUser.setPassWord(new String(editPasswordTF.getPassword()));
			selectedUser.setFirstName(editFirstNameTF.getText());
			selectedUser.setLastName(editLastNameTF.getText());
			selectedUser.setEmail(editEmailTF.getText());
			selectedUser.setPhone(editPhoneTF.getText());
			selectedUser.setAddress(editAddressTF.getText());
			selectedUser.setCity(editCityTF.getText());
			selectedUser.setState(editStateTF.getText());
			selectedUser.setZip(Integer.parseInt(editZipTF.getText()));
			if(rdbtnYes_2.isSelected())
				selectedUser.setAdmin(true);
			else if(rdbtnNo_2.isSelected())
				selectedUser.setAdmin(false);
			
			ud.updateUser(selectedUser);
			editUsernameTF.setText("");
			editPasswordTF.setText("");
			editFirstNameTF.setText("");
			editLastNameTF.setText("");
			editEmailTF.setText("");
			editPhoneTF.setText("");
			editAddressTF.setText("");
			editCityTF.setText("");
			editStateTF.setText("");
			editZipTF.setText("");
			selectedUser=null;
			
//			this.loadSuperUserDash();
//			cl.addLayoutComponent(container, "4");
			
		});
		EditUserPanel.add(editUpdateBtn);
		JButton edittodashBtn = new JButton("< Dashboard");
		edittodashBtn.setBounds(46, 13, 106, 25);
		edittodashBtn.addActionListener(e->{
			editUsernameTF.setText("");
			editPasswordTF.setText("");
			editFirstNameTF.setText("");
			editLastNameTF.setText("");
			editEmailTF.setText("");
			editPhoneTF.setText("");
			editAddressTF.setText("");
			editCityTF.setText("");
			editStateTF.setText("");
			editZipTF.setText("");
			selectedUser = null;
			sudlm.removeAllElements();
			this.loadSuperUserDash();
			cl.show(container,"4");
		});
		EditUserPanel.add(edittodashBtn);
	}
	public boolean isNumber(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
}
