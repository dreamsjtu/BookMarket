package book.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import book.pojo.User;
import book.service.UserService;
import book.service.impl.UserServiceImpl;

class UserServiceTest {
	
	UserService userService = new UserServiceImpl();
	@Test
	void testRegisterUser() {
		userService.registerUser(new User(null,"huacheng","xielian","baiwujinji@gmail.com"));
		userService.registerUser(new User(null,"nanfeng","fuyao","nanfu@gmail.com"));
	}

	@Test
	void testLogin() {
		System.out.println(userService.login(new User(null,"xielian2","huacheng","xielian@gmail.com")));
	}

	@Test
	void testExistUsername() {
		if(userService.existUsername("huacheng2")) {
			System.out.println("exist username");
		}else {
			System.out.println("username not exist");
		}
	}

}
