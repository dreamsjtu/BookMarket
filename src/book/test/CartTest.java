package book.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import book.pojo.Cart;
import book.pojo.CartItem;

class CartTest {

  @Test
  void testAddItem() {
    Cart cart = new Cart();
    cart.addItem(new CartItem(1, "MoDaoZuShi", new BigDecimal(10.0), new BigDecimal(20.0), 2));
    cart.addItem(new CartItem(1, "MoDaoZuShi", new BigDecimal(10.0), new BigDecimal(30.0), 3));
    cart.addItem(new CartItem(3, "MoDaoZuShi2", new BigDecimal(30.0), new BigDecimal(30.0), 1));
    Assert.assertNotNull(cart.getItems().get(1));
    Assert.assertNotNull(cart.getItems().get(3));
    
    Assert.assertEquals("MoDaoZuShi",cart.getItems().get(1).getName());
    Assert.assertEquals( new BigDecimal(10.0),cart.getItems().get(1).getPrice());
    Assert.assertEquals(new BigDecimal(50.0),cart.getItems().get(1).getTotalPrice());
    Assert.assertEquals(5,cart.getItems().get(1).getCount());
    
    Assert.assertEquals("MoDaoZuShi2",cart.getItems().get(3).getName());
    Assert.assertEquals(new BigDecimal(30.0),cart.getItems().get(3).getPrice());
    Assert.assertEquals (new BigDecimal(30.0), cart.getItems().get(3).getTotalPrice());
    Assert.assertEquals(1,cart.getItems().get(3).getCount());
    
    Assert.assertEquals(6, cart.getTotalCount());
    Assert.assertEquals(new BigDecimal(80.0),cart.getTotalPrice());
  }

  @Test
  void testDeleteItem() {
    Cart cart = new Cart();
    cart.addItem(new CartItem(1, "MoDaoZuShi", new BigDecimal(10.0), new BigDecimal(20.0), 2));
    cart.addItem(new CartItem(1, "MoDaoZuShi", new BigDecimal(10.0), new BigDecimal(30.0), 3));
    cart.addItem(new CartItem(3, "MoDaoZuShi2", new BigDecimal(30.0), new BigDecimal(30.0), 1));
    cart.deleteItem(1);
    Assert.assertNull(cart.getItems().get(1));
    Assert.assertEquals(1, cart.getTotalCount());
    Assert.assertEquals(new BigDecimal(30.0), cart.getTotalPrice());
  }

  @Test
  void testUpdateCount() {
    Cart cart = new Cart();
    cart.addItem(new CartItem(1, "MoDaoZuShi", new BigDecimal(10.0), new BigDecimal(20.0), 2));
    cart.addItem(new CartItem(1, "MoDaoZuShi", new BigDecimal(10.0), new BigDecimal(30.0), 3));
    cart.addItem(new CartItem(3, "MoDaoZuShi2", new BigDecimal(30.0), new BigDecimal(30.0), 1));
    cart.updateCount(1, 4);
    cart.updateCount(1, 2);
    Assert.assertEquals(2, cart.getItems().get(1).getCount());
    Assert.assertEquals(3, cart.getTotalCount());
    Assert.assertEquals(new BigDecimal(50.0), cart.getTotalPrice());
  }

  @Test
  void testClearCart() {
    Cart cart = new Cart();
    cart.addItem(new CartItem(1, "MoDaoZuShi", new BigDecimal(10.0), new BigDecimal(20.0), 2));
    cart.addItem(new CartItem(1, "MoDaoZuShi", new BigDecimal(10.0), new BigDecimal(30.0), 3));
    cart.addItem(new CartItem(3, "MoDaoZuShi2", new BigDecimal(30.0), new BigDecimal(30.0), 1));
    cart.updateCount(1, 4);
    cart.updateCount(1, 2);
    cart.clearCart();
    Assert.assertEquals(cart.getItems().size(), 0);
  }
  
  @Test
  public void addItem() {
      Cart cart = new Cart();

      cart.addItem(new CartItem(1, "java从入门到精通",new BigDecimal(1000),new BigDecimal(1000),1));
      cart.addItem(new CartItem(1, "java从入门到精通",new BigDecimal(1000),new BigDecimal(1000),1));
      cart.addItem(new CartItem(2, "数据结构与算法",new BigDecimal(100),new BigDecimal(100),1));

      System.out.println(cart);

  }

  @Test
  public void deleteItem() {

      Cart cart = new Cart();

      cart.addItem(new CartItem(1, "java从入门到精通", new BigDecimal(1000),new BigDecimal(1000),1));
      cart.addItem(new CartItem(1, "java从入门到精通",new BigDecimal(1000),new BigDecimal(1000),1));
      cart.addItem(new CartItem(2, "数据结构与算法", new BigDecimal(100),new BigDecimal(100),1));

      cart.deleteItem(1);

      System.out.println(cart);

  }

  @Test
  public void clear() {
      Cart cart = new Cart();

      cart.addItem(new CartItem(1, "java从入门到精通", new BigDecimal(1000),new BigDecimal(1000),1));
      cart.addItem(new CartItem(1, "java从入门到精通", new BigDecimal(1000),new BigDecimal(1000),1));
      cart.addItem(new CartItem(2, "数据结构与算法", new BigDecimal(100),new BigDecimal(100),1));

      cart.deleteItem(1);

      cart.clearCart();

      System.out.println(cart);
  }

  @Test
  public void updateCount() {

      Cart cart = new Cart();

      cart.addItem(new CartItem(1, "java从入门到精通", new BigDecimal(1000),new BigDecimal(1000),1));
      cart.addItem(new CartItem(1, "java从入门到精通", new BigDecimal(1000),new BigDecimal(1000),1));
      cart.addItem(new CartItem(2, "数据结构与算法", new BigDecimal(100),new BigDecimal(100),1));

      cart.deleteItem(1);

      cart.clearCart();

      cart.addItem(new CartItem(1, "java从入门到精通", new BigDecimal(1000),new BigDecimal(1000),1));

      cart.updateCount(1, 10);


      System.out.println(cart);

  }

}
