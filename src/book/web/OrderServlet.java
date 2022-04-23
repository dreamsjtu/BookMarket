package book.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.pojo.Cart;
import book.pojo.Order;
import book.pojo.OrderItem;
import book.pojo.User;
import book.service.OrderService;
import book.service.impl.OrderServiceImpl;

public class OrderServlet extends BaseServlet {
  private OrderService orderService = new OrderServiceImpl();
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    doPost(request,response);
  }
  
  protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    User user = (User) request.getSession().getAttribute("user");
    if(user==null) {
      request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
      return;
    }
    int userid = user.getId();
    String orderid = orderService.createOrder(cart, userid);
    cart.clearCart();
    request.getSession().setAttribute("orderid", orderid);
    response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
  }
  
  protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Order> allOrders = orderService.showAllOrders();
    request.setAttribute("allOrders", allOrders);
    request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
  }
  
  protected void shipOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String orderId = (String) request.getParameter("orderId");
    orderService.shipOrder(orderId);
    response.sendRedirect(request.getHeader("referer"));
  }
  
  protected void showOrderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String orderId = (String) request.getParameter("orderId");
    request.setAttribute("orderItems", orderService.showOrderDetails(orderId));
    request.getRequestDispatcher("/pages/order/order_details.jsp").forward(request, response);
  }
  
  protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = (User) request.getSession().getAttribute("user");
    Integer userId = user.getId();
    List<Order> myOrders = orderService.showMyOrders(userId);
    request.setAttribute("myOrders", myOrders);
    request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
  }
  
  protected void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String orderId = (String) request.getParameter("orderId");
    orderService.receiveOrder(orderId);
    response.sendRedirect(request.getHeader("referer"));
  }
}
