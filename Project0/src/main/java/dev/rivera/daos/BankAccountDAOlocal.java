package dev.rivera.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JList;

import dev.rivera.backend.Properties;
import dev.rivera.utils.BankAccount;
import dev.rivera.utils.User;

public class BankAccountDAOlocal implements BankAccountDAO {
	private static Map<Integer,BankAccount> bankAccountTable = new HashMap<Integer,BankAccount>();
	private int idGenerator = 101;
	
	public BankAccount createBankAccount(BankAccount ba) {
		ba.setAccountId(idGenerator);
		idGenerator++;
		
		bankAccountTable.put(ba.getAccountId(),ba);
		return null;
	}

	public BankAccount getBankAccountById(int id) {
		
		return bankAccountTable.get(id);
	}

	public ArrayList<BankAccount> getAllAccounts(User u) {
		/*ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();	
try {
		
			Connection con = Properties.getConnection();
		String Query = "SELECT ID,accountBalance,userID FROM bankaccount,User WHERE userID = User.ID AND userID='"+u.getUserId()+"'";
		PreparedStatement recieve = con.prepareStatement(Query);
		ResultSet rs = recieve.executeQuery(Query);
		
		while(rs.next()) {
			System.out.println("found an account");
			BankAccount currentBankAccount = new BankAccount(rs.getInt(1),rs.getDouble(2),rs.getInt(3));
			System.out.println(currentBankAccount);
			bankAccounts.add(currentBankAccount);
		}if(!rs.next())
			System.out.println("no account linked to user");
}catch(Exception e){
	System.out.println(e);
}*/
		/*JList<Object> accountList = new JList<Object>(bankAccounts.toArray());
		accountList.setBounds(665, 331, -560, -205);
		regUserPanel.add(accountList);
		
		*/
		

		ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>(bankAccountTable.values());
		
		return bankAccounts;
	}

	public BankAccount updateBankAccount(BankAccount ba) {
		bankAccountTable.put(ba.getAccountId(),ba);
		return ba;
	}

	public boolean deleteBankAccount(BankAccount ba) {
		bankAccountTable.remove(ba.getAccountId());
		return true;
	}

	@Override
	public BankAccount createBankAccount(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
