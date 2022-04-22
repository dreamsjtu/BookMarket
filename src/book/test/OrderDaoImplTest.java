package book.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;

import book.dao.OrderDao;
import book.dao.impl.OrderDaoImpl;
import book.pojo.Order;

class OrderDaoImplTest {

  @Test
  void testSaveOrder() {
    OrderDao od = new OrderDaoImpl();
    Order o = new Order("23872938792",new Date(),1,new BigDecimal(50.0),0);
    od.saveOrder(o);
  }

}
