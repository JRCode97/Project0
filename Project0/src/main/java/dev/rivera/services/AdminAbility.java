package dev.rivera.services;

import java.util.*;

import dev.rivera.utils.*;

public interface AdminAbility {
	public User getUserById(int id);
	public List<User> getAllUsers();
	public User updateUser(int id,int bankAccountId,double balance);
	public boolean deleteUser(int id);
	public boolean deleteAllUsers();
	

}
