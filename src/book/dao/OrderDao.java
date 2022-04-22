package book.dao;

import java.util.List;

import book.pojo.Order;

public interface OrderDao {
  /**
   * Save the order into database.
   * 
   * @param order
   * @return
   */
  public int saveOrder(Order order);

  /**
   * Show all the orders. (admin)
   * 
   * @return
   */
  public List<Order> queryOrders();

  /**
   * Change the order status, 0 means waiting for shipping,1 means shipped, 2
   * means received.
   *
   * @param orderid
   * @param status
   */
  public void changeOrderStatus(String orderid, int status);
  
  /**
   * Query the order in database by userid.
   *
   * @param userid
   * @return
   */
  public Order queryOrderByUserid(Integer userid);
}
