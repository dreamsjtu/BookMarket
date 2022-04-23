package book.pojo;

import java.math.BigDecimal;

public class OrderItem {
  private Integer id;
  private Integer itemId;
  private String name;
  private BigDecimal price;
  private BigDecimal totalPrice;
  private Integer count;
  private String orderId;

  
  public OrderItem() {
    super();
  }

  public OrderItem(Integer id, Integer itemId, String name, BigDecimal price, BigDecimal totalPrice,
      Integer count, String orderId) {
    super();
    this.id = id;
    this.itemId = itemId;
    this.name = name;
    this.price = price;
    this.totalPrice = totalPrice;
    this.count = count;
    this.orderId = orderId;
  }

  public Integer getId() {
    return id;
  }

  public Integer getItemId() {
    return itemId;
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

  public Integer getCount() {
    return count;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
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

  public void setCount(Integer count) {
    this.count = count;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  @Override
  public String toString() {
    return "OrderItem [id=" + id + ", itemId=" + itemId + ", name=" + name + ", price=" + price
        + ", totalPrice=" + totalPrice + ", count=" + count + ", orderId=" + orderId + "]";
  }

}
