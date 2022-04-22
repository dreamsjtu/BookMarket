package book.test;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import book.dao.OrderItemDao;
import book.dao.impl.OrderItemDaoImpl;
import book.pojo.OrderItem;

class OrderItemDaoImplTest {

  @Test
  void testSaveOrderItem() {
    OrderItemDao oid = new OrderItemDaoImpl();
    OrderItem oi = new OrderItem(7968765,1,"hahaha",new BigDecimal(10.0),new BigDecimal(30.0),3,"23872938792");
    oid.saveOrderItem(oi);
  }

}
