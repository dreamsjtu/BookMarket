package book.dao;

import book.pojo.Order;

public interface OrderDao {
  /**
   * This method will save the order into database.
   * @param order
   */
  public void saveOrder(Order order);
}
