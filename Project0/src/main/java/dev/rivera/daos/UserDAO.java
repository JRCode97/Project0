package dev.rivera.daos;

import java.util.List;

import dev.rivera.utils.User;

public interface UserDAO {
	User createUser(User u); 
	
	User getUserById(int id);
	List<User> getAllUser();
	
	User updateUser(User u);
	User signinUser(String un,String pw);
	
	boolean deleteUser(User u);

	User signupUser(User u);
	
}
