package book.dao;

import book.pojo.OrderItem;

public interface OrderItemDao {

  /**
   * This method will save the orderItem into database.
   *
   * @param orderItem
   * @return 
   */
  public int saveOrderItem(OrderItem orderItem);
}
