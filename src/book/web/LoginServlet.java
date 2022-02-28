package book.web;

import java.io.IOException;

import book.pojo.User;
import book.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * Handle the post request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the request parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//Create a UserServiceImpl
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		//Try login with username and password
		if(userServiceImpl.login(new User(null, username, password,null))!=null) {
			//If success
			//Go to login_success page
			request.getRequestDispatcher("pages/user/login_success.html").forward(request, response);
			System.out.println("Login successfully");
		}else {
			//If failed
			//Back to login page
			request.getRequestDispatcher("pages/user/login.html").forward(request, response);
			System.out.println("Login failed");
		}
		
		
	}

}
