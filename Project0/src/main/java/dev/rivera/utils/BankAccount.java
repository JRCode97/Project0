package dev.rivera.utils;

public class BankAccount {
	private int accountId;
	private double accountBalance = 0;
	private int userId;

	public BankAccount() {
		super();
		
	}
	public BankAccount(int userId) {
		this.userId = userId;
	}
	public BankAccount(int accountId, double accountBalance, int userId) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.userId = userId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", accountBalance=" + accountBalance + ", userId=" + userId
				+ "]";
	}
	
	
}
