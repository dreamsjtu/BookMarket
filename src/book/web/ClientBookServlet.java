package book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.pojo.Book;
import book.pojo.Page;
import book.service.BookService;
import book.service.impl.BookServiceImpl;
import book.util.WebUtils;

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
    int pageNumber = WebUtils.parseInt(request.getParameter("pageNumber"),1);
    int pageSize = WebUtils.parseInt(request.getParameter("pageSize"),Page.PAGE_SIZE);
    //Call page method in bookServlet to get a page object
    Page<Book> page = bookService.page(pageNumber,pageSize);
    //set the url of page
    page.setUrl("Client/ClientBookServlet?action=page");
    //Save the page object to request scope.
    request.setAttribute("page", page);
    //forward request to book_manager.jsp
    request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
  }
  
  /**
   * This is for handling the paging request.
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Get the parameters(pageNumber,pageSize) from request
    int pageNumber = WebUtils.parseInt(request.getParameter("pageNumber"),1);
    int pageSize = WebUtils.parseInt(request.getParameter("pageSize"),Page.PAGE_SIZE);
    int min = WebUtils.parseInt(request.getParameter("min"),0);
    int max = WebUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);
    //Call pageByService method in bookServlet to get a page object
    Page<Book> page = bookService.pageByPrice(pageNumber,pageSize,min,max);
    StringBuilder sb = new StringBuilder("Client/ClientBookServlet?action=pageByPrice");
    if(request.getParameter("min")!=null) {
      sb.append("&min=").append(request.getParameter("min"));
    }
    if(request.getParameter("max")!=null) {
      sb.append("&max=").append(request.getParameter("max"));
    }
    //set the url of page
    page.setUrl(sb.toString());
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
