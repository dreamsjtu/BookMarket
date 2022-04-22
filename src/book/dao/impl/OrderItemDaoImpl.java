package book.dao.impl;

import book.dao.OrderItemDao;
import book.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao{

  @Override
  public int saveOrderItem(OrderItem orderItem) {
    String sql = "insert into t_order_item(`id`,`itemid`,`name`,`price`,`totalPrice`,`count`,`orderid`) values (?,?,?,?,?,?,?)";
    return update(sql,orderItem.getId(),orderItem.getItemid(),orderItem.getName(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getCount(),orderItem.getOrderid());
  }

}
