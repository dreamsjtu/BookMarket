package book.dao.impl;

import java.util.List;

import book.dao.OrderDao;
import book.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

  @Override
  public int saveOrder(Order order) {
    String sql = "insert into t_order(`orderId`,`createDate`,`userId`,`price`,`status`) values (?,?,?,?,?)";
    return update(sql,order.getOrderId(),order.getCreateDate(),order.getUserId(),order.getPrice(),order.getStatus());
  }

  @Override
  public List<Order> queryOrders() {
    String sql = "select `orderId`,`createDate`,`userId`,`price`,`status` from t_order";
    return queryForList(Order.class,sql);
  }

  @Override
  public int changeOrderStatus(String orderId, int status) {
    String sql = "update t_order set `status`=? where orderId=?";
    return update(sql,status,orderId);
  }

  @Override
  public List<Order> queryOrdersByUserId(Integer userId) {
    String sql = "select `orderId`,`createDate`,`userId`,`price`,`status` from t_order where userId=?";
    return queryForList(Order.class,sql,userId);
  }

}
