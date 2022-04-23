package book.service;

import java.util.List;

import book.pojo.Cart;
import book.pojo.Order;
import book.pojo.OrderItem;

public interface OrderService {
  /**
   * This method will use the items in cart as order item and userid to create an
   * order.
   *
   * @param cart
   * @param userid
   * @return the order id.
   */
  public String createOrder(Cart cart, int userid);

  /**
   * Show all the orders in database.
   * @return 
   */
  public List<Order> showAllOrders();
  
  /**
   * Send out the order.
   *
   * @param orderId
   */
  public void shipOrder(String orderId);

  /**
   * Show the order items of each order.
   *
   * @return a list of the orderItems
   */
  public List<OrderItem> showOrderDetails(String orderId);

  /**
   * Show all the order of current user.
   * @param userId
   * @return
   */
  public List<Order> showMyOrders(Integer userId);
  
}
