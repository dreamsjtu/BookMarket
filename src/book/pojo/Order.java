package book.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
  private String orderId;
  private Date createDate;
  private int userId;
  private BigDecimal price;
  private int status;

  public Order(String orderId, Date createDate, int userId, BigDecimal price, int status) {
    super();
    this.orderId = orderId;
    this.createDate = createDate;
    this.userId = userId;
    this.price = price;
    this.status = status;
  }

  public String getOrderId() {
    return orderId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public int getUserId() {
    return userId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public int getStatus() {
    return status;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Order [orderId=" + orderId + ", createDate=" + createDate + ", userId=" + userId
        + ", price=" + price + ", status=" + status + "]";
  }

}
