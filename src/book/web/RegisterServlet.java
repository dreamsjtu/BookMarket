package book.web;

import java.io.IOException;

import book.pojo.User;
import book.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	/**
	 * Handle the post request.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the parameters of request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		
		//Create UserServiceImpl
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		//Check if verification code correct
		if(code.equalsIgnoreCase("abcde")) {
			//If Correct
			//Check if username exist
			if(userServiceImpl.existUsername(username)) {
				//If exist
				//Back to register page
				request.setAttribute("msg", "Username already exists");
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.setAttribute("email", email);
				request.setAttribute("code", code);
				request.getRequestDispatcher("pages/user/regist.jsp").forward(request, response);
				System.out.println("username already exists");
			}else {
				//If not exist
				//Go to register success page
				//use service to save user to database
				request.getRequestDispatcher("pages/user/regist_success.jsp").forward(request, response);
				userServiceImpl.registerUser(new User(null,username,password,email));
				System.out.println("register successfully");
			}
		}else {
			//If incorrect
			//Back to register page
			request.setAttribute("msg", "Wrong verification code");
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("email", email);
			request.setAttribute("code", code);
			request.getRequestDispatcher("pages/user/regist.jsp").forward(request, response);
			System.out.println("wrong verification code");
		}
		
		
	}

}
