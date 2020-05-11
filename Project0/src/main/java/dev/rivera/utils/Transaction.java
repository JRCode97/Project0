package dev.rivera.utils;

public class Transaction {
	private int id;
	private String type;
	private int bankAccountId;
	private double amount;
	public Transaction() {
		super();
	}
	public Transaction(int id, String type, int bankAccountId, double amount) {
		super();
		this.id = id;
		this.type = type;
		this.bankAccountId = bankAccountId;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", type=" + type + ", bankAccountId=" + bankAccountId + ", amount=" + amount
				+ "]";
	}
	
}
