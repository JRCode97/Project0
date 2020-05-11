
package dev.rivera.services;

import java.util.List;

import dev.rivera.utils.*;

public interface UserService {
	public BankAccount openAccount(User u);
	public boolean deleteAccount(BankAccount ba);
	public List<BankAccount> getBankAccounts(User u);
	public Transaction addFunds(BankAccount ba,double amount);
	public Transaction withdrawFunds(BankAccount ba,double amount);
	public List<Transaction> getTransactions(BankAccount ba);
}
