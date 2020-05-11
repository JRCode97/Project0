package dev.rivera.daos;

import java.util.*;

import dev.rivera.utils.BankAccount;
import dev.rivera.utils.User;

public interface BankAccountDAO {
	BankAccount createBankAccount(User u); 
	
	BankAccount getBankAccountById(int id);
	ArrayList<BankAccount> getAllAccounts(User u);
	
	BankAccount updateBankAccount(BankAccount ba);
	
	boolean deleteBankAccount(BankAccount ba);
	
}
