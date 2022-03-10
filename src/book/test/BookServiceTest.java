package book.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import book.pojo.Book;
import book.service.impl.BookServiceImpl;

class BookServiceTest {
	
	BookServiceImpl bookServiceImpl = new BookServiceImpl();
	
	@Test
	void testAddBook() {
		bookServiceImpl.addBook(new Book(null,"魔道祖师",new BigDecimal(100),"墨香铜臭",3000,1000,""));
		bookServiceImpl.queryBooks().forEach(System.out::println);
	}

	@Test
	void testDeleteBook() {
		bookServiceImpl.deleteBook(20);
		bookServiceImpl.queryBooks().forEach(System.out::println);
	}

	@Test
	void testUpdateBook() {
		bookServiceImpl.updateBook(new Book(25,"魔道祖师3",new BigDecimal(100),"墨香铜臭3",3000,1000,""));
		bookServiceImpl.queryBooks().forEach(System.out::println);
	}

	@Test
	void testQueryBookById() {
		bookServiceImpl.queryBookById(1);
		bookServiceImpl.queryBooks().forEach(System.out::println);
	}

	@Test
	void testQueryBooks() {
		bookServiceImpl.queryBooks().forEach(System.out::println);
	}
	
	@Test
	void testPage() {
		System.out.println(bookServiceImpl.page(2, 4));
	}

}
