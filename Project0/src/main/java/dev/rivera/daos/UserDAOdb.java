package dev.rivera.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.rivera.backend.ConnectionUtils;
import dev.rivera.utils.BankAccount;
import dev.rivera.utils.User;

public class UserDAOdb implements UserDAO {
	private static BankAccountDAO bad = new BankAccountDAOdb();
	@Override
	public User createUser(User u) {
		
		try (Connection con = ConnectionUtils.createConnection()){
			
			
			String Query = "INSERT INTO USER_TABLE (ID, userName, passWord, firstName, lastName, email, phone, address, city, state, zip, Admin) VALUES (0,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement post = con.prepareStatement(Query,Statement.RETURN_GENERATED_KEYS);
			post.setString(1, u.getUserName());
			post.setString(2, u.getPassWord());
			post.setString(3, u.getFirstName());
			post.setString(4, u.getLastName());
			post.setString(5, u.getEmail());
			post.setString(6, u.getPhone());
			post.setString(7, u.getAddress());
			post.setString(8, u.getCity());
			post.setString(9, u.getState());
			post.setInt(10, u.getZip());
			post.setBoolean(11, u.isAdmin());
			post.executeUpdate();
			ResultSet rs = post.getGeneratedKeys();
			int key = 0; 
			if(rs.next())
				key = rs.getInt("ID");
			return u;
			
	}catch(Exception e){
		System.out.println(e);
	}
		return u;
	}
	@Override
	public User signinUser(String un,String pw) {
		User u = null;
		try  (Connection con = ConnectionUtils.createConnection()){
			boolean validUser = false;
			String Query = "SELECT * FROM USER_TABLE WHERE userName = ? AND passWord = ? ";
			PreparedStatement recieve = con.prepareStatement(Query);
			recieve.setString(1, un);
			recieve.setString(2,pw);
			ResultSet rs = recieve.executeQuery();
			if(rs.next()) {
				
				validUser= true;
				u= new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getBoolean(12));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public User signupUser(User u) {
		
		try(Connection con = ConnectionUtils.createConnection()){
			String CheckQuery = "SELECT FirstName FROM USER_TABLE WHERE userName = ? ";
			PreparedStatement recieve = con.prepareStatement(CheckQuery);
			recieve.setString(1, u.getUserName());
			//creates a list of results 
			ResultSet rs = recieve.executeQuery();
			//check the list to see if there are matches for email
			if (rs.next())
			{
				System.out.println("That username is already in use.");
				
			}
			else {
				//if email nonexistent in  database it stores all the textfields to the driver table in database

//			String Query = "INSERT INTO User (ID,userName,passWord,firstName,lastName,email,phone,address,city,state,zip,Admin) VALUES('0',?,?,?,?,?,?,?,?,?,?,?) ";
//			PreparedStatement post = con.prepareStatement(Query);
//			post.setString(1, u.getUserName());
//			post.setString(2, u.getPassWord());
//			post.setString(3, u.getFirstName());
//			post.setString(4, u.getLastName());
//			post.setString(5, u.getEmail());
//			post.setString(6, u.getPhone());
//			post.setString(7, u.getAddress());
//			post.setString(8, u.getCity());
//			post.setString(9, u.getState());
//			post.setInt(10, u.getZip());
//			post.setBoolean(11, u.isAdmin());
//			post.executeUpdate();
				this.createUser(u);
			System.out.println("Signed Up Successfully");}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return u;
	}
	
	@Override
	public User getUserById(int id) {
		User u = null;
		try  (Connection con = ConnectionUtils.createConnection()){
			
			
			String Query = "SELECT * FROM USER_TABLE WHERE ID = ? ";
			PreparedStatement recieve = con.prepareStatement(Query);
			recieve.setInt(1, id);
			ResultSet rs = recieve.executeQuery();
			
			if(rs.next()) {
				System.out.println("found user");
				u= new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getBoolean(12));
				System.out.println(u);
				return u;
			}if(!rs.next()) {
				System.out.println("no account linked to user");
				return null;
			}
			
	}catch(Exception e){
		System.out.println(e);
	}
		return u;
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();	
		try  (Connection con = ConnectionUtils.createConnection()){
				
				
				String Query = "SELECT * FROM USER_TABLE";
				PreparedStatement recieve = con.prepareStatement(Query);
				ResultSet rs = recieve.executeQuery();
				
				while(rs.next()) {
					System.out.println("found user");
					User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getBoolean(12));
					System.out.println(u);
					users.add(u);
				}if(!rs.next())
					System.out.println("no users");
		}catch(Exception e){
			System.out.println(e);
		}
		return users;
	}

	@Override
	public User updateUser(User u) {
		try (Connection con = ConnectionUtils.createConnection()){
		String Query = "UPDATE USER_TABLE SET ID=?,userName=?,passWord=?,firstName=?,lastName=?,email=?,phone=?,address=?,city=?,state=?,zip=?,Admin=? WHERE ID = ?";
		PreparedStatement post = con.prepareStatement(Query);
		post.setInt(1,u.getUserId());
		post.setString(2,u.getUserName());
		post.setString(3,u.getPassWord());
		post.setString(4,u.getFirstName());
		post.setString(5,u.getLastName());
		post.setString(6,u.getEmail());
		post.setString(7,u.getPhone());
		post.setString(8,u.getAddress());
		post.setString(9,u.getCity());
		post.setString(10,u.getState());
		post.setInt(11,u.getZip());
		post.setBoolean(12,u.isAdmin());
		post.setInt(13, u.getUserId());
		post.executeUpdate();
	}catch(Exception e){
		System.out.println(e);
	}
		return u;
	}

	@Override
	public boolean deleteUser(User u) {
		List<BankAccount> accounts = bad.getAllAccounts(u);
		for(BankAccount acc:accounts) {
			bad.deleteBankAccount(acc);
		}
		try(Connection con = ConnectionUtils.createConnection()) {
			String Query = "DELETE FROM USER_TABLE WHERE ID = ?";
			PreparedStatement post = con.prepareStatement(Query);
			post.setInt(1, u.getUserId());
			post.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
			return true;
	}

}
