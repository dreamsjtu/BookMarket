package book.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import book.dao.UserDao;
import book.dao.impl.UserDaoImpl;
import book.pojo.User;

class UserDaoTest {

	UserDao userDao = new UserDaoImpl();
	
	@Test
	void testQueryUserByUsername() {
		if(userDao.queryUserByUsername("xielian")==null) {
			System.out.println("valid username");
		}else{
			System.out.println("invalid username");
		};
	}

	@Test
	void testQueryUserByUsernameAndPassword() {
		if(userDao.queryUserByUsernameAndPassword("xielian", "huacheng")==null) {
			System.out.println("wrong password or user not exist");
		}else {
			System.out.println("found user");
		}
	}

	@Test
	void testSaveUser() {
		System.out.println(userDao.saveUser(new User(null,"xielian2","tianguancifu","baiwujinji@gmail.com")));
	}

}
