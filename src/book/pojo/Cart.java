package book.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

  private int totalCount = 0;
  private BigDecimal totalPrice = new BigDecimal(0);
  private Map<Integer,CartItem> items  = new HashMap<>();
  
  /**
   * Add an item to cart.
   * @param item 
   */
  public void addItem(CartItem item) {
    CartItem c =  items.get(item.getId());
    this.totalCount = this.totalCount+item.getCount();
    this.totalPrice = this.totalPrice.add(item.getTotalPrice());
   if(c!=null) {
     c.setCount(c.getCount()+item.getCount());
     c.setTotalPrice(c.getPrice().multiply(new BigDecimal(c.getCount())));
   }else {
     c = item;
   }
   items.put(item.getId(), c);
   
  }
  
  /**
   * Delete an item from cart.
   * @param id id of the item for adding to cart
   */
  public void deleteItem(int id) {
    if(items.get(id)!=null) {
    this.totalCount = this.totalCount-items.get(id).getCount();
    this.totalPrice = this.totalPrice.subtract(items.get(id).getTotalPrice());
    items.remove(id);
    }
  }
  
  /**
   * Update the quantity of an item in cart
   * @param id
   * @param count
   */
  public void updateCount(int id, int count) {
    CartItem c = items.get(id);
    assert c!=null;
    assert count>=0;
    this.totalCount = this.totalCount+(count-c.getCount());
    this.totalPrice = this.totalPrice.add((c.getPrice().multiply(new BigDecimal(count)).subtract(c.getTotalPrice())));
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
    this.totalCount = 0;
    this.totalPrice = new BigDecimal(0);
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
  public void setItems(Map<Integer, CartItem> items) {
    this.items = items;
  }
  @Override
  public String toString() {
    return "Cart [totalCount=" + totalCount + ", totalPrice=" + totalPrice + ", items=" + items
        + "]";
  }
  public Cart(int totalCount, BigDecimal totalPrice, Map<Integer, CartItem> items) {
    
    this.totalCount = totalCount;
    this.totalPrice = totalPrice;
    this.items = items;
  }

  public Cart() {
    super();
  }
  
}
