package book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.pojo.Cart;
import book.pojo.User;
import book.service.OrderService;
import book.service.impl.OrderServiceImpl;

public class OrderServlet extends BaseServlet {
  protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    OrderService orderService = new OrderServiceImpl();
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    User user = (User) request.getSession().getAttribute("user");
    if(user==null) {
      request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
      return;
    }
    int userid = user.getId();
    String orderid = orderService.createOrder(cart, userid);
    request.getSession().setAttribute("orderid", orderid);
    response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
  }

}
