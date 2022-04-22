package book.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;

import book.dao.OrderDao;
import book.dao.impl.OrderDaoImpl;
import book.pojo.Order;

class OrderDaoImplTest {

  private OrderDao od = new OrderDaoImpl();

  @Test
  void testSaveOrder() {
    String orderId = new Date()+"";
    Order o = new Order(orderId, new Date(), 1, new BigDecimal(50.0), 0);
    od.saveOrder(o);
  }

  @Test
  void testQueryOrders() {
    System.out.println(od.queryOrders());
  }

  @Test
  void testChangeOrderStatus() {
    String orderId = new Date()+"";
    Order o = new Order(orderId.toString(), new Date(), 1, new BigDecimal(50.0), 0);
    od.saveOrder(o);
    od.changeOrderStatus(orderId.toString(), 2);
  }

  @Test
  void testQueryOrderByUserid() {

  }
}
