package book.service;

import java.util.List;

import book.pojo.Book;
import book.pojo.Page;

public interface BookService {
	/**
	 * Add a book to the database
	 * @param book
	 */
	public void addBook(Book book);
	
	/**
	 * Delete a book from the database
	 * @param book
	 */
	public void deleteBook(Integer id);
	
	/**
	 * Update a book in the database
	 * @param book
	 */
	public void updateBook(Book book);
	
	/**
	 * Query a book in the database by ID
	 * @param id
	 */
	public Book queryBookById(Integer id);
	
	/**
	 * Get a list of book from the database
	 * @return the book list
	 */
	public List<Book> queryBooks();

	public Page<Book> page(int pageNumber, int pageSize);

  public Page<Book> pageByPrice(int pageNumber, int pageSize, int min, int max);
	
}
