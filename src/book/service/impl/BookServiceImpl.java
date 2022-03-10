package book.service.impl;

import java.util.List;

import book.dao.BookDao;
import book.dao.impl.BookDaoImpl;
import book.pojo.Book;
import book.pojo.Page;
import book.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDaoImpl = new BookDaoImpl();

	@Override
	public void addBook(Book book) {
		bookDaoImpl.saveBook(book);

	}

	@Override
	public void deleteBook(Integer id) {
		bookDaoImpl.deleteBookById(id);

	}

	@Override
	public void updateBook(Book book) {
		bookDaoImpl.updateBook(book);

	}

	@Override
	public Book queryBookById(Integer id) {
		return bookDaoImpl.queryBookById(id);

	}

	@Override
	public List<Book> queryBooks() {
		return bookDaoImpl.queryBooks();
	}

	@Override
	public Page<Book> page(int pageNumber, int pageSize) {
		//Create a new Page object
		Page<Book> page = new Page();
		page.setPageSize(pageSize);
		//Call method in Dao layer to get the total amount of items
		int itemsNumber = bookDaoImpl.queryForItemsNumber();
		//Calculate the total pages by amount of items and pageSize
		int totalPages = itemsNumber%pageSize==0?(int)itemsNumber/pageSize:(int)itemsNumber/pageSize+1;
		page.setTotalPages(totalPages);
		page.setPageNumber(pageNumber);
		//Calculate the begin index of current page
		int begin  = (page.getPageNumber()-1)*pageSize;
		//Call method in Dao layer to get the items on current page
		List<Book> items = bookDaoImpl.queryForPageItems(begin,pageSize);
		page.setItemsNumber(itemsNumber);
		page.setItems(items);
		return page;
	}

}
