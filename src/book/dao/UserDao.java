package book.dao;

import book.pojo.User;

public interface UserDao {
	
	/**
	 * Query user by username
	 * @param username
	 * @return user
	 */
	public User queryUserByUsername(String username);
	
	/**
	 * Query user by username and password
	 * @param username
	 * @param password
	 * @return user
	 */
	public User queryUserByUsernameAndPassword(String username, String password);
	
	/**
	 * Save the user's information
	 * @param user
	 * @return -1 means failed
	 */
	public int saveUser(User user);
	
}
