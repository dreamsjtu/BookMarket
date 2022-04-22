package book.web;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.pojo.Book;
import book.pojo.Cart;
import book.pojo.CartItem;
import book.service.BookService;
import book.service.impl.BookServiceImpl;
import book.util.WebUtils;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    doPost(request,response);
  }
  
  /**
   * Get the cart from session and add item to it.
   * @param item
   * @throws IOException 
   */
  protected void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //Get the shopping cart from session
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    //If cart is null, create a new cart and add the cart to session.
    if(cart==null) {
      cart = new Cart();
      request.getSession().setAttribute("cart", cart);
    }
    //Get the item id
    int itemid = WebUtils.parseInt(request.getParameter("itemid"), -1);
    //Create the cartitem
    BookService bs =  new BookServiceImpl();
    Book book = bs.queryBookById(itemid);
    //add item to cart
    cart.addItem(new CartItem(book.getId(),book.getName(),book.getPrice(),book.getPrice(),1));
    //Add a lastAddedItem attribute to session.
    request.getSession().setAttribute("lastAddedItem", book.getName());
    //redirect to the page it comes from
    response.sendRedirect(request.getHeader("referer"));
  }
  
  /**
   * Delete the item from cart stored in session.
   * @param request
   * @param response
   * @throws IOException
   */
  protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
  //Get the item id
    int itemid = WebUtils.parseInt(request.getParameter("itemid"), -1);
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    if(cart==null) {
     throw new RuntimeException("cart can't be null");
    }
    cart.deleteItem(itemid);
    response.sendRedirect(request.getHeader("referer"));
  }
  
  /**
   * Clear the cart stored in session.
   * @param request
   * @param response
   * @throws IOException 
   */
  protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    if(cart==null) {
     throw new RuntimeException("cart can't be null");
    }
    cart.clearCart();
    response.sendRedirect(request.getHeader("referer"));
  }
  
  protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
    int itemid = WebUtils.parseInt(request.getParameter("itemid"), -1);
    int count = WebUtils.parseInt(request.getParameter("count"), -1);
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    if(cart==null) {
     throw new RuntimeException("cart can't be null");
    }
    cart.updateCount(itemid, count);
    response.sendRedirect(request.getHeader("referer"));
  }
  
}

