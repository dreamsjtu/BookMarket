package book.test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import book.dao.OrderItemDao;
import book.dao.impl.OrderItemDaoImpl;
import book.pojo.OrderItem;

class OrderItemDaoImplTest {
  OrderItemDao oid = new OrderItemDaoImpl();
  
  @Test
  void testSaveOrderItem() {
    Random ran = new Random();
    OrderItem oi = new OrderItem(null,1,"hahaha",new BigDecimal(10.0),new BigDecimal(30.0),3,"23872938792");
    oid.saveOrderItem(oi);
  }
  
  @Test
  void testQueryOrderItemsByOrderId() {
   System.out.println(Arrays.toString(oid.queryOrderItemsByOrderId("test2").toArray()));
  }

}
