package book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import com.google.code.kaptcha.*;
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

import book.pojo.User;
import book.service.impl.UserServiceImpl;
import book.util.WebUtils;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Implement the functionalities of login servlet, redirect to different pages
   * based on the login details.
   * 
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  protected void login(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Get the request parameters
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    // Create a UserServiceImpl
    UserServiceImpl userServiceImpl = new UserServiceImpl();
    //Create a user
    User loginUser = userServiceImpl.login(new User(null, username, password, null));
    // Try login with username and password
    if (loginUser != null) {
      // If success
      // Save user's info in session
      request.getSession().setAttribute("user", loginUser);
      // Go to login_success page
      request.getRequestDispatcher("pages/user/login_success.jsp").forward(request, response);
      System.out.println("Login successfully");
    } else {
      // If failed
      // Back to login page
      request.setAttribute("msg", "Wrong username or password");
      request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
      System.out.println("Login failed");
    }
  }

  /**
   * Implement the functionality of logout a user, redirect to home page
   * 
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  protected void logout(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getSession().invalidate();
    response.sendRedirect(request.getContextPath());
  }

  /**
   * Implement the functionalities of register servlet, redirect to different
   * pages based on the register details.
   * 
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  protected void register(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Get the parameters of request
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String code = request.getParameter("code");
    // Create a new user object
    User user = WebUtils.copyParamToBean(new User(), request.getParameterMap());
    // Create UserServiceImpl
    UserServiceImpl userServiceImpl = new UserServiceImpl();
    // Get the verify code
    String kaptchaCode = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
    // Delete the verify code
    request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
    // Check if verification code correct
    if (kaptchaCode != null && code.equalsIgnoreCase(kaptchaCode)) {
      // If Correct
      // Check if username exist
      if (userServiceImpl.existUsername(username)) {
        // If exist
        // Back to register page
        request.setAttribute("msg", "Username already exists");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("email", email);
        request.setAttribute("code", code);
        request.getRequestDispatcher("pages/user/regist.jsp").forward(request, response);
        System.out.println("username already exists");
      } else {
        // If not exist
        // Go to register success page
        // use service to save user to database
        request.getRequestDispatcher("pages/user/regist_success.jsp").forward(request, response);
        userServiceImpl.registerUser(new User(null, username, password, email));
        System.out.println("register successfully");
      }
    } else {
      // If incorrect
      // Back to register page
      request.setAttribute("msg", "Wrong verification code");
      request.setAttribute("username", username);
      request.setAttribute("password", password);
      request.setAttribute("email", email);
      request.setAttribute("code", code);
      request.getRequestDispatcher("pages/user/regist.jsp").forward(request, response);
      System.out.println("wrong verification code");
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
