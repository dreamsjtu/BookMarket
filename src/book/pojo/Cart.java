package book.pojo;

import java.math.BigDecimal;
import java.util.List;

public class Cart {

  private int totalCount;
  private BigDecimal totalPrice;
  private List<CartItem> items;
  
  public void addItem(CartItem item) {
    
  }
  
  public void deleteItem(int id) {
    
  }
  
  public void updateCount(int id, int count) {
    
  }
  
  public void clearCart() {
    
  }
  public int getTotalCount() {
    return totalCount;
  }
  public BigDecimal getTotalPrice() {
    return totalPrice;
  }
  public List<CartItem> getItems() {
    return items;
  }
  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }
  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }
  public void setItems(List<CartItem> items) {
    this.items = items;
  }
  @Override
  public String toString() {
    return "Cart [totalCount=" + totalCount + ", totalPrice=" + totalPrice + ", items=" + items
        + "]";
  }
  public Cart(int totalCount, BigDecimal totalPrice, List<CartItem> items) {
    super();
    this.totalCount = totalCount;
    this.totalPrice = totalPrice;
    this.items = items;
  }
  
}
