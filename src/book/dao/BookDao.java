package book.dao;

import java.util.List;

import book.pojo.Book;

public interface BookDao {
  /**
   * Used for save a book to database
   * 
   * @param book
   * @return -1 means failed
   */
  public int saveBook(Book book);

  /**
   * Query a book by the book id
   * 
   * @param id
   * @return the related book
   */
  public Book queryBookById(Integer id);

  /**
   * Delete a book by the book id
   * 
   * @param id
   * @return -1 means failed
   */
  public int deleteBookById(Integer id);

  /**
   * Update the info of a book
   * 
   * @param book
   * @return -1 means failed
   */
  public int updateBook(Book book);

  /**
   * Query all the book in the database
   * 
   * @return the book list
   */
  public List<Book> queryBooks();

  /**
   * This is query the database for the amount of book items.
   * 
   * @return the amount of book items.
   */
  public int queryForItemsNumber();

  /**
   * This is for query the database for book items index start with begin and the
   * maximum amounts is pageSize.
   * 
   * @param begin
   * @param pageSize
   * @return a list of books on current page
   */
  public List<Book> queryForPageItems(int begin, int pageSize);

  /**
   * This is query the database for the amount of book items within the min and
   * max price range.
   * 
   * @param min the minimum price
   * @param max the maximum price
   * @return the amount of book items within this rage.
   */
  public int queryForItemsNumberByPrice(int min, int max);

  /**
   * This is for query the database for book items index start with begin and the
   * maximum amounts is pageSize, and price within min and max.
   * 
   * @param begin
   * @param pageSize
   * @param min
   * @param max
   * @return a list of books on current page
   */
  public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);

}
