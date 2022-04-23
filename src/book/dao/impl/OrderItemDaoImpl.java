package book.dao.impl;

import java.util.List;

import book.dao.OrderItemDao;
import book.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

  @Override
  public int saveOrderItem(OrderItem orderItem) {
    String sql = "insert into t_order_item(`id`,`itemId`,`name`,`price`,`totalPrice`,`count`,`orderId`) values (?,?,?,?,?,?,?)";
    return update(sql, null,orderItem.getItemId(), orderItem.getName(), orderItem.getPrice(),
        orderItem.getTotalPrice(), orderItem.getCount(), orderItem.getOrderId());
  }

  @Override
  public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
    String sql = "select `id`,`itemId`,`name`,`price`,`totalPrice`,`count`,`orderId` from t_order_item where orderId=?";
    return queryForList(OrderItem.class,sql,orderId);
  }

}
