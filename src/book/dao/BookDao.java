package book.dao;

import java.util.List;

import book.pojo.Book;

public interface BookDao {
	/**
	 * Used for save a book to database
	 * @param book
	 * @return -1 means failed
	 */
	public int saveBook(Book book);
	
	/**
	 * Query a book by the book id
	 * @param id
	 * @return the related book
	 */
	public Book queryBookById(Integer id);
	
	/**
	 * Delete a book by the book id
	 * @param id
	 * @return -1 means failed
	 */
	public int deleteBookById(Integer id);
	
	/**
	 * Update the info of a book
	 * @param book
	 * @return -1 means failed
	 */
	public int updateBook(Book book);
	
	/**
	 * Query all the book in the database
	 * @return the book list
	 */
	public List<Book> queryBooks();
	

}
