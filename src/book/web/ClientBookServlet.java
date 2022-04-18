package book.web;

import java.io.IOException;

import book.pojo.Book;
import book.pojo.Page;
import book.service.BookService;
import book.service.impl.BookServiceImpl;
import book.util.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ClientBookServlet extends BaseServlet {
  private BookService bookService = new BookServiceImpl();
  /**
   * This is for handling the paging request.
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Get the parameters(pageNumber,pageSize) from request
    System.out.println("here");
    int pageNumber = WebUtils.parseInt(request.getParameter("pageNumber"),1);
    int pageSize = WebUtils.parseInt(request.getParameter("pageSize"),Page.PAGE_SIZE);
    //Call page method in bookServlet to get a page object
    Page<Book> page = bookService.page(pageNumber,pageSize);
    //Save the page object to request scope.
    request.setAttribute("page", page);
    //forward request to book_manager.jsp
    request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    doPost(request,response);
  }
}
