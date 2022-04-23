package book.dao;

import java.util.List;

import book.pojo.OrderItem;

public interface OrderItemDao {

  /**
   * This method will save the orderItem into database.
   *
   * @param orderItem
   * @return 
   */
  public int saveOrderItem(OrderItem orderItem);
  
  /**
   * This method will return a list of orders belong to the orderid.
   * @param orderId
   * @return a list of orders
   */
  public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
