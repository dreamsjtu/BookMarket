package book.service;

import java.util.List;

import book.pojo.Cart;
import book.pojo.Order;

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
   */
  public List<Order> showAllOrders();
}
