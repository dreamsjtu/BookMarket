package book.service.impl;

import java.util.List;

import book.dao.impl.BookDaoImpl;
import book.pojo.Book;
import book.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDaoImpl bookDaoImpl = new BookDaoImpl();

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

}
