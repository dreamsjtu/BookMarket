package book.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

  private int totalCount;
  private BigDecimal totalPrice;
  private Map<Integer,CartItem> items  = new HashMap<>();
  
  /**
   * Add an item to cart.
   * @param item 
   */
  public void addItem(CartItem item) {
    CartItem c =  items.get(item.getId());
   if(c!=null) {
     c.setCount(c.getCount()+1);
     c.setTotalPrice(c.getPrice().multiply(new BigDecimal(c.getCount())));
     items.put(item.getId(),c );
   }else {
     items.put(item.getId(), item);
   }
  }
  
  /**
   * Delete an item from cart.
   * @param id id of the item for adding to cart
   */
  public void deleteItem(int id) {
    items.remove(id);
  }
  
  /**
   * Update the quantity of an item in cart
   * @param id
   * @param count
   */
  public void updateCount(int id, int count) {
    CartItem c = items.get(id);
    if(c!=null) {
      c.setCount(count);
      c.setTotalPrice(c.getPrice().multiply(new BigDecimal(c.getCount())));
    }  
  }
  
  /**
   * Clear the cart
   */
  public void clearCart() {
    items.clear();
  }
  public int getTotalCount() {
    return totalCount;
  }
  public BigDecimal getTotalPrice() {
    return totalPrice;
  }
  public Map<Integer, CartItem> getItems() {
    return items;
  }
  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }
  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }
  public void setItems(Map<Integer, CartItem> items) {
    this.items = items;
  }
  @Override
  public String toString() {
    return "Cart [totalCount=" + totalCount + ", totalPrice=" + totalPrice + ", items=" + items
        + "]";
  }
  public Cart(int totalCount, BigDecimal totalPrice, Map<Integer, CartItem> items) {
    super();
    this.totalCount = totalCount;
    this.totalPrice = totalPrice;
    this.items = items;
  }
  
}
