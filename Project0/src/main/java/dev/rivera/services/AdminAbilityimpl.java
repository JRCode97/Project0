package dev.rivera.services;

import java.util.*;

import dev.rivera.daos.*;
import dev.rivera.utils.*;

public class AdminAbilityimpl implements AdminAbility {
	private BankAccountDAO bad = new BankAccountDAOdb();
	private UserDAO ud = new UserDAOdb();
	public User getUserById(int id) {
		User u = ud.getUserById(id);
		return u;
	}

	public List<User> getAllUsers() {
		List<User> users = new LinkedList<User>();
		users = ud.getAllUser();
		return users;
	}

	public User updateUser(int id, int bankAccountId, double balance) {
		User u = ud.getUserById(id);
		BankAccount ba = bad.getBankAccountById(bankAccountId);
		ba.setAccountBalance(balance);
		bad.updateBankAccount(ba);
		return u;
	}

	public boolean deleteUser(int id) {
		ud.deleteUser(ud.getUserById(id));
		return true;
	}

	public boolean deleteAllUsers() {
		List<User> users = this.getAllUsers();
		for(User u:users)
			ud.deleteUser(u);
		return true;
	}

}
