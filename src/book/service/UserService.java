package book.service;

import book.pojo.User;

public interface UserService {
	/**
	 * Register user
	 * @param user
	 */
	public void registerUser(User user);
	
	/**
	 * Log user into system
	 * @param user
	 */
	public User login(User user);
	
	/**
	 * Return true if the username already exist.
	 * @param username
	 * @return true if username exist, false if username not exist
	 */
	public boolean existUsername(String username);
}
