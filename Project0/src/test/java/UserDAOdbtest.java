import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.rivera.daos.*;
import dev.rivera.utils.*;

public class UserDAOdbtest {
	UserDAO ud = new UserDAOdb();
	@Test
	public void createUser() {
		User u = new User();
		u.setFirstName("fake");
		u.setLastName("user");
		u.setUserName("dummy");
		u.setPassWord("dummypass");
		u.setEmail("fakeemail@nowhere.com");
		u.setPhone("0000000000");
		u.setAddress("123 beaver st");
		u.setCity("tulsa");
		u.setState("oklahoma");
		u.setZip(12345);
		u.setAdmin(false);
		ud.createUser(u);
	}@Test
	public void getUserById() {
		ud.getUserById(2);
	}
	@Test
	public void loginUser() {
		User u = ud.signinUser("dummy", "dummypass");
		System.out.println(u);
	}
	@Test
	public void getAllUsers() {
		List<User> users = ud.getAllUser();
		System.out.println(users);
	}
	@Test
	public void updateUser() {
		User u = new User();
		u.setUserId(1);
		u.setFirstName("really fake");
		u.setLastName("user");
		u.setUserName("dummy");
		u.setPassWord("dummypass");
		u.setEmail("fakeemail@nowhere.com");
		u.setPhone("0000000000");
		u.setAddress("123 beaver st");
		u.setCity("tulsa");
		u.setState("oklahoma");
		u.setZip(12345);
		u.setAdmin(false);
		ud.updateUser(u);
	}
	@Test
	public void deleteUser() {
		User u = new User();
		u.setUserId(1);
		ud.deleteUser(u);
	}

}
