package dev.rivera.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.rivera.utils.BankAccount;
import dev.rivera.utils.User;

public class UserDAOlocal implements UserDAO{
	private static Map<Integer,User> UserTable = new HashMap<Integer,User>();
	private static int idGenerator = 101;
	public User createUser(User u) {
		u.setUserId(idGenerator);
		idGenerator++;
		return u;
	}

	public User getUserById(int id) {
		UserTable.get(id);
		return null;
	}

	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>(UserTable.values());
		return null;
	}

	public User updateUser(User u) {
		UserTable.put(u.getUserId(),u);
		return null;
	}

	public boolean deleteUser(User u) {
		UserTable.remove(u.getUserId());
		return false;
	}

}
