package book.service.impl;

import book.dao.UserDao;
import book.dao.impl.UserDaoImpl;
import book.pojo.User;
import book.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	@Override
	public void registerUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public User login(User user) {
		return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	@Override
	public boolean existUsername(String username) {
		return userDao.queryUserByUsername(username)!=null;
	}

}
