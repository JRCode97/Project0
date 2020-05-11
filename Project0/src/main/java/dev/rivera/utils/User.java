package dev.rivera.utils;

import java.util.*;

public class User {
	private int userId;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String city;
	private String state;
	private int zip;
	private boolean admin = false;
	@Override
	public String toString() {
		return "User [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", admin=" + admin + "]";
	}
	public User(int userId, String userName, String passWord, String firstName, String lastName, String email,
			String phone, String address, String city, String state, int zip, boolean admin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.admin = admin;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	List<BankAccount> accountList = new LinkedList<BankAccount>();
	public User() {
		super();
	}
	public User(int userId, String userName, String passWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}
	public User(int userId, String userName, String passWord, List<BankAccount> accountList) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.accountList = accountList;
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public List<BankAccount> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<BankAccount> accountList) {
		this.accountList = accountList;
	}
	
}
