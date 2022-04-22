package book.service;

import book.pojo.Cart;

public interface OrderService {
  /**
   * This method will use the items in cart as order item and userid to create an order.
   *
   * @param cart
   * @param userid
   * @return the order id.
   */
public String createOrder(Cart cart,int userid);
}
