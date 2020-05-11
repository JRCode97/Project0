import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.rivera.daos.*;
import dev.rivera.utils.BankAccount;
import dev.rivera.utils.User;

public class BankAccountdbtest {
	private static BankAccountDAO bad = new BankAccountDAOdb();
	private static UserDAO ud = new UserDAOdb();

	@Test
	public void createBankAccount() {
		User u = new User();
		u.setUserId(2);
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
		bad.createBankAccount(u);
	}
	@Test
	public void getBankAccount() {
		bad.getBankAccountById(1);
	}
	@Test
	public void getAllAccounts() {
		User u = ud.getUserById(2);
		List<BankAccount> bankAccounts = bad.getAllAccounts(u);
		System.out.println(bankAccounts);
	}

}
