package book.dao.impl;

import java.util.List;

import book.dao.OrderDao;
import book.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

  @Override
  public int saveOrder(Order order) {
    String sql = "insert into t_order(`orderid`,`createDate`,`userid`,`price`,`status`) values (?,?,?,?,?)";
    return update(sql,order.getOrderId(),order.getCreateDate(),order.getUserId(),order.getPrice(),order.getStatus());
  }

  @Override
  public List<Order> queryOrders() {
    String sql = "select `orderId`,`createDate`,`userId`,`price`,`status` from t_order";
    return queryForList(Order.class,sql);
  }

  @Override
  public void changeOrderStatus(String orderid, int status) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Order queryOrderByUserid(Integer userid) {
    // TODO Auto-generated method stub
    return null;
  }

}
