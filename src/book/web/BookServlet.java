package book.web;

import java.io.IOException;
import java.util.List;

import book.pojo.Book;
import book.pojo.Page;
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
		//Get the total pages
		int totalPages=WebUtils.parseInt(request.getParameter("totalPages"), 0);
		//Add one to the totalPages.
		totalPages+=1;
		//Get all the request parameters, encapsulate them into Book object.
		Book book = WebUtils.copyParamToBean(new Book(),request.getParameterMap());
		//Call addBook method in BookService
		bookService.addBook(book);
		//Jump to the updated book list page.
//		request.getRequestDispatcher("/Manager/BookServlet?action=list").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/Manager/BookServlet?action=page&pageNumber="+totalPages);
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
		Integer bookId = WebUtils.parseInt(request.getParameter("id"),0);
		//Delete the book according to the id
		bookService.deleteBook(bookId);
		//Jump to the book list page
		response.sendRedirect(request.getContextPath()+"/Manager/BookServlet?action=page&pageNumber="+request.getParameter("pageNumber"));
	}
	
	/**
	 * This would handle the update book action
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get all the request parameters
		//Encapsulate the parameters into a book object
		Book book = WebUtils.copyParamToBean(new Book(), request.getParameterMap());
		System.out.println(book);
		//Call the updateBook in BookService to update the book info in database
		bookService.updateBook(book);
		//Jump to updated book list page
		response.sendRedirect(request.getContextPath()+"/Manager/BookServlet?action=page");
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
	
	/**
	 * This would query the book in database with the id from the request and add the data to request and forward the request to target page.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the book id from request
		Integer bookId = WebUtils.parseInt(request.getParameter("id"),0);
		//Call queryBookById to get the related book
		Book book = bookService.queryBookById(bookId);
		//Set the book as an attribute of the request
		request.setAttribute("book", book);
		//Forward the request to book_edit.jsp
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	
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
		//Save the page object to request scope.
		request.setAttribute("page", page);
		//forward request to book_manager.jsp
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	

}
