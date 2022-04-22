package book.service.impl;

import java.util.Date;
import java.util.List;

import book.dao.BookDao;
import book.dao.OrderDao;
import book.dao.OrderItemDao;
import book.dao.impl.BookDaoImpl;
import book.dao.impl.OrderDaoImpl;
import book.dao.impl.OrderItemDaoImpl;
import book.pojo.Book;
import book.pojo.Cart;
import book.pojo.CartItem;
import book.pojo.Order;
import book.pojo.OrderItem;
import book.service.OrderService;

public class OrderServiceImpl implements OrderService {

  OrderDao orderDao = new OrderDaoImpl();
  OrderItemDao orderItemDao = new OrderItemDaoImpl();
  BookDao bookDao = new BookDaoImpl();

  @Override
  public String createOrder(Cart cart, int userid) {
    String orderid = new Date() + "" + userid;
    Order order = new Order(orderid, new Date(), userid, cart.getTotalPrice(), 0);
    orderDao.saveOrder(order);
    for (CartItem ci : cart.getItems().values()) {
      OrderItem orderItem = new OrderItem(null, ci.getId(), ci.getName(), ci.getPrice(),
          ci.getTotalPrice(), ci.getCount(), orderid);
      orderItemDao.saveOrderItem(orderItem);
      Book book = bookDao.queryBookById(ci.getId());
      book.setSales(book.getSales()+ci.getCount());
      book.setStock(book.getStock()-ci.getCount());
      bookDao.updateBook(book);
    }
    return orderid;
  }

  @Override
  public List<Order> showAllOrders() {
    return orderDao.queryOrders();
  }

}
