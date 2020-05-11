package dev.rivera.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.rivera.backend.ConnectionUtils;
import dev.rivera.utils.BankAccount;
import dev.rivera.utils.Transaction;
import dev.rivera.utils.User;

public class BankAccountDAOdb implements BankAccountDAO {
	private static TransactionDAO td = new TransactionDAOdb();
	@Override
	public BankAccount createBankAccount(User u) {
		BankAccount currentBankAccount = new BankAccount(u.getUserId());
		try(Connection con = ConnectionUtils.createConnection()) {
			
			
			String Query = "INSERT into bankaccount (ID,accountBalance,userID) VALUES (0,0,?)";
			PreparedStatement post = con.prepareStatement(Query,Statement.RETURN_GENERATED_KEYS);
			post.setInt(1, u.getUserId());
			post.execute();
			ResultSet rs = post.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("ID");
			currentBankAccount.setAccountId(key);
			return currentBankAccount;
			
	}catch(Exception e){
		System.out.println(e);
	}
		return currentBankAccount;

	}

	@Override
	public BankAccount getBankAccountById(int id) {
		BankAccount currentBankAccount = null;
		try (Connection con = ConnectionUtils.createConnection())
		
		{
			
			
			String Query = "SELECT * FROM bankaccount,USER_TABLE WHERE bankaccount.userID = USER_TABLE.ID AND bankaccount.userID=?";
			PreparedStatement recieve = con.prepareStatement(Query);
			recieve.setInt(1, id);
			ResultSet rs = recieve.executeQuery();
			
			if(rs.next()) {
				System.out.println("found an account");
				currentBankAccount= new BankAccount(rs.getInt(1),rs.getDouble(2),rs.getInt(3));
				System.out.println(currentBankAccount);
				return currentBankAccount;
			}if(!rs.next()) {
				System.out.println("no account linked to user");
				return null;
			}
			
	}catch(Exception e){
		System.out.println(e);
	}
		return currentBankAccount;
	}

	@Override
	public ArrayList<BankAccount> getAllAccounts(User u) {
		ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();	
		try(Connection con = ConnectionUtils.createConnection()) {
				
				
				String Query = "SELECT bankaccount.ID,accountBalance,userID FROM bankaccount,USER_TABLE WHERE userID = USER_TABLE.ID AND userID=?";
				PreparedStatement recieve = con.prepareStatement(Query);
				recieve.setInt(1, u.getUserId());
				ResultSet rs = recieve.executeQuery();
				
				while(rs.next()) {
					System.out.println("found an account");
					BankAccount currentBankAccount = new BankAccount(rs.getInt(1),rs.getDouble(2),rs.getInt(3));
					System.out.println(currentBankAccount);
					bankAccounts.add(currentBankAccount);
				}if(!rs.next())
					System.out.println("no account linked to user");
		}catch(Exception e){
			System.out.println(e);
		}
		return bankAccounts;
	}

	@Override
	public BankAccount updateBankAccount(BankAccount ba) {
		try (Connection con = ConnectionUtils.createConnection()){
		String Query = "UPDATE bankaccount SET ID=?,accountBalance=?,userID=? WHERE ID =?";
		PreparedStatement post = con.prepareStatement(Query);
		post.setInt(1, ba.getAccountId());
		post.setDouble(2, ba.getAccountBalance());
		post.setInt(3, ba.getUserId());
		post.setInt(4, ba.getAccountId());
		post.executeUpdate();
		return ba;
	}catch(Exception e){
		System.out.println(e);
	}
		return ba;
	}

	@Override
	public boolean deleteBankAccount(BankAccount ba) {
		List<Transaction> trans = td.getAllTransactions(ba) ;
		if(trans != null) {
		for(Transaction tran:trans) {
			td.deleteTransaction(tran);
		}}
		try (Connection con = ConnectionUtils.createConnection()){
			String Query = "DELETE FROM bankaccount WHERE ID = ?";
			PreparedStatement post = con.prepareStatement(Query);
			post.setInt(1, ba.getAccountId());
			boolean success = post.execute();
			return success;
		}catch(Exception e){
			System.out.println(e);
		}
			return true;
	}



}
