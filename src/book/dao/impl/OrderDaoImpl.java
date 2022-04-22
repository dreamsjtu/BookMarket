package book.dao.impl;

import book.dao.OrderDao;
import book.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

  @Override
  public int saveOrder(Order order) {
    String sql = "insert into t_order(`orderid`,`createDate`,`userid`,`price`,`status`) values (?,?,?,?,?)";
    return update(sql,order.getOrderId(),order.getCreateDate(),order.getUserId(),order.getPrice(),order.getStatus());
  }

}
