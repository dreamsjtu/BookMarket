package book.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import book.pojo.User;

public class ManagerFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    User user = (User) request.getSession().getAttribute("user");
    if(user==null) {
      request.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest, servletResponse);
    }
      filterChain.doFilter(servletRequest, servletResponse);
  }

}
