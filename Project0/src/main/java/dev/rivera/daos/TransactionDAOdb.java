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

public class TransactionDAOdb implements TransactionDAO {
	private BankAccountDAO bad = new BankAccountDAOdb();
	@Override
	public Transaction createTransaction(BankAccount ba,String type,double amount) {
		Transaction tran = new Transaction(0,type,ba.getAccountId(),amount);
		if(type.equals("withdrawl")) {
			double amountleft = ba.getAccountBalance() - amount;
			if(amountleft>0) {
				ba.setAccountBalance(amountleft);
				bad.updateBankAccount(ba);
				try(Connection con = ConnectionUtils.createConnection()) {
					
					
					String Query = "INSERT into TRANSACTION_TABLE (ID,TRANSACTION_TYPE,AMOUNT,ACCOUNT_ID) VALUES (0,?,?,?)";
					PreparedStatement post = con.prepareStatement(Query,Statement.RETURN_GENERATED_KEYS);
					post.setString(1,type);
					post.setDouble(2, amount);
					post.setInt(3, ba.getAccountId());
					post.execute();
					ResultSet rs = post.getGeneratedKeys();
					rs.next();
					int key = rs.getInt("ID");
					tran.setId(key);
					return tran;
					
			}catch(Exception e){
				System.out.println(e);
			}
			}else {
				System.out.println("inadequate funds");
			}
		}
		if(type.equals("deposit")) {
			double newBalance = ba.getAccountBalance() + amount;
		
				ba.setAccountBalance(newBalance);
				bad.updateBankAccount(ba);
				try(Connection con = ConnectionUtils.createConnection()) {
					
					
					String Query = "INSERT into TRANSACTION_TABLE (ID,TRANSACTION_TYPE,AMOUNT,ACCOUNT_ID) VALUES (0,?,?,?)";
					PreparedStatement post = con.prepareStatement(Query,Statement.RETURN_GENERATED_KEYS);
					post.setString(1,type);
					post.setDouble(2, amount);
					post.setInt(3, ba.getAccountId());
					post.execute();
					ResultSet rs = post.getGeneratedKeys();
					rs.next();
					int key = rs.getInt("ID");
					tran.setId(key);
					return tran;
					
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
		return tran;
	}
	@Override
	public Transaction getTransactionById(int id) {
		Transaction tran = null;
		try (Connection con = ConnectionUtils.createConnection())
		
		{
			
			
			String Query = "SELECT * FROM TRANSACTION_TABLE WHERE ID=?";
			PreparedStatement recieve = con.prepareStatement(Query);
			recieve.setInt(1, id);
			ResultSet rs = recieve.executeQuery();
			
			if(rs.next()) {
				System.out.println("transaction found");
				tran= new Transaction(rs.getInt(1),rs.getString(2),rs.getInt(4),rs.getDouble(3));
				return tran;
			}if(!rs.next()) {
				System.out.println("transaction not found");
				return null;
			}
			
	}catch(Exception e){
		System.out.println(e);
	}
		return tran;
	}

	@Override
	public List<Transaction> getAllTransactions(BankAccount ba) {
		List<Transaction> trans = new ArrayList<Transaction>();
		Transaction tran = null;
try (Connection con = ConnectionUtils.createConnection())
		
		{
			
			
			String Query = "SELECT * FROM TRANSACTION_TABLE WHERE ACCOUNT_ID=?";
			PreparedStatement recieve = con.prepareStatement(Query);
			recieve.setInt(1, ba.getAccountId());
			ResultSet rs = recieve.executeQuery();
			
			while(rs.next()) {
				System.out.println("transaction found");
				tran= new Transaction(rs.getInt(1),rs.getString(2),rs.getInt(4),rs.getDouble(3));
				trans.add(tran);
				
			}if(!rs.next()) {
				System.out.println("transaction not found");
				
			}
			
	}catch(Exception e){
		System.out.println(e);
	}
		return trans;
	}
	@Override
	public boolean deleteTransaction(Transaction t) {
		try (Connection con = ConnectionUtils.createConnection()){
			String Query = "DELETE FROM TRANSACTION_TABLE WHERE ID = ?";
			PreparedStatement post = con.prepareStatement(Query);
			post.setInt(1, t.getId());
			boolean success = post.execute();
			return success;
		}catch(Exception e){
			System.out.println(e);
		}
			return true;
	}
	}


