package book.pojo;

import java.math.BigDecimal;

public class CartItem {

  private int id;
  private String name;
  private BigDecimal price;
  private BigDecimal totalPrice;
  private int count;
  
  public int getId() {
    return id;
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
  public void setId(int id) {
    this.id = id;
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
  @Override
  public String toString() {
    return "CartItem [id=" + id + ", name=" + name + ", price=" + price + ", totalPrice="
        + totalPrice + ", count=" + count + "]";
  }
  public CartItem(int id, String name, BigDecimal price, BigDecimal totalPrice, int count) {
    super();
    this.id = id;
    this.name = name;
    this.price = price;
    this.totalPrice = totalPrice;
    this.count = count;
  }
  public CartItem() {
    super();
  }
  
}
