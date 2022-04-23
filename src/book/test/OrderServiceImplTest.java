package book.test;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import book.pojo.Cart;
import book.pojo.CartItem;
import book.service.OrderService;
import book.service.impl.OrderServiceImpl;

class OrderServiceImplTest {

  private OrderService os = new OrderServiceImpl();
  
  @Test
  void testCreateOrder() {
    Cart cart = new Cart();
    cart.addItem(new CartItem(1,"java从入门到放",new BigDecimal(10.0),new BigDecimal(30.0),3));
    cart.addItem(new CartItem(5,"C++编程思想",new BigDecimal(15.0),new BigDecimal(15.0),1));
    cart.addItem(new CartItem(6,"蛋炒饭",new BigDecimal(20.0),new BigDecimal(40.0),2));
    
    os.createOrder(cart, 1);
  }
  
  @Test
  void testShowAllOrders() {
    System.out.println(os.showAllOrders());
  }

  @Test
  void testShipOrder() {
    Cart cart = new Cart();
    cart.addItem(new CartItem(1,"java从入门到放",new BigDecimal(10.0),new BigDecimal(30.0),3));
    cart.addItem(new CartItem(5,"C++编程思想",new BigDecimal(15.0),new BigDecimal(15.0),1));
    cart.addItem(new CartItem(6,"蛋炒饭",new BigDecimal(20.0),new BigDecimal(40.0),2));
    
    String orderId = os.createOrder(cart, 1);
    os.shipOrder(orderId);
  }
  
  @Test
  void testShowOrderDetails() {
    System.out.println(os.showOrderDetails("test2"));
  }
  
  @Test
  void testShowMyOrders() {
    System.out.println(os.showMyOrders(1));
  }
}
