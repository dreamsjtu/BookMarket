package book.web;

import java.io.IOException;
import java.util.List;

import book.pojo.Book;
import book.service.BookService;
import book.service.impl.BookServiceImpl;
import book.util.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	/**
	 * This would handle the add book action
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get all the request parameters, encapsulate them into Book object.
		Book book = WebUtils.copyParamToBean(new Book(),request.getParameterMap());
		//Call addBook method in BookService
		bookService.addBook(book);
		//Jump to the updated book list page.
//		request.getRequestDispatcher("/Manager/BookServlet?action=list").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/Manager/BookServlet?action=list");
	}
	
	/**
	 * This would handle the delete book action
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get all the request parameters
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		//Delete the book according to the id
		bookService.deleteBook(bookId);
		//Jump to the book list page
		response.sendRedirect(request.getContextPath()+"/Manager/BookServlet?action=list");
		
	}
	
	/**
	 * This would handle the update book action
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * This would handle the list book action
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Enquirying all the books by using BookService
		List<Book> books = bookService.queryBooks();
		//Save all the books to request
		request.setAttribute("books", books);
		//Request forward to book_manager.jsp
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

}
