package book.pojo;

import java.math.BigDecimal;

public class OrderItem {
  private int id;
  private int itemid;
  private String name;
  private BigDecimal price;
  private BigDecimal totalPrice;
  private int count;
  private String orderid;

  public OrderItem(int id, int itemid, String name, BigDecimal price, BigDecimal totalPrice,
      int count, String orderid) {
    super();
    this.id = id;
    this.itemid = itemid;
    this.name = name;
    this.price = price;
    this.totalPrice = totalPrice;
    this.count = count;
    this.orderid = orderid;
  }

  public int getId() {
    return id;
  }

  public int getItemid() {
    return itemid;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public int getCount() {
    return count;
  }

  public String getOrderid() {
    return orderid;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setItemid(int itemid) {
    this.itemid = itemid;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public void setOrderid(String orderid) {
    this.orderid = orderid;
  }

  @Override
  public String toString() {
    return "OrderItem [id=" + id + ", itemid=" + itemid + ", name=" + name + ", price=" + price
        + ", totalPrice=" + totalPrice + ", count=" + count + ", orderid=" + orderid + "]";
  }

}
