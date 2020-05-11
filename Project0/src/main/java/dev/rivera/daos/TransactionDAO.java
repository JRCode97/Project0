package dev.rivera.daos;

import java.util.ArrayList;
import java.util.List;

import dev.rivera.utils.*;

public interface TransactionDAO {
	
	
	Transaction getTransactionById(int id);
	List<Transaction> getAllTransactions(BankAccount ba);

	Transaction createTransaction(BankAccount ba, String type, double amount);
	boolean deleteTransaction(Transaction t);

}
