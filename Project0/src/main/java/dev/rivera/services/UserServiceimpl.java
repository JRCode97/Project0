package dev.rivera.services;

import java.util.List;

import dev.rivera.daos.*;
import dev.rivera.utils.*;

public class UserServiceimpl implements UserService {
	private UserDAO ud = new UserDAOlocal();
	private BankAccountDAO bad = new BankAccountDAOdb();
	private TransactionDAO td = new TransactionDAOdb();
	
	public BankAccount openAccount(User u) {
		BankAccount ba = new BankAccount(u.getUserId());
		bad.createBankAccount(u);
		return ba;
	}
	public boolean deleteAccount(BankAccount ba) {
		if(ba.getAccountBalance() == 0)
		{
			bad.deleteBankAccount(ba);
			return true;
		}
		else 
		{
			System.out.println("withdraw funds then try again");
			return false;
		}
		
	}
	public Transaction addFunds(BankAccount ba, double amount) {
		
		return td.createTransaction(ba, "deposit", amount);
	}
	public Transaction withdrawFunds(BankAccount ba, double amount) {
		
		return td.createTransaction(ba, "withdrawl", amount);
	}
	public BankAccount TransferFunds(BankAccount wba,BankAccount dba,double amount) {
		this.withdrawFunds(wba, amount);
		this.addFunds(dba, amount);
		return dba;
	}
	@Override
	public List<BankAccount> getBankAccounts(User u) {
		
		return bad.getAllAccounts(u);
	}
	@Override
	public List<Transaction> getTransactions(BankAccount ba) {
		List<Transaction> trans = td.getAllTransactions(ba);
		if (trans != null)
			return trans;
		else
			return null;
	}

	
	


	
}
