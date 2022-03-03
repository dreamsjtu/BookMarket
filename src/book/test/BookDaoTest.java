package book.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import book.dao.BookDao;
import book.dao.impl.BookDaoImpl;
import book.pojo.Book;

class BookDaoTest {
	BookDao bookDao = new BookDaoImpl();
	@Test
	void testSaveBook() {
		System.out.println(bookDao.saveBook(new Book(null,"huacheng",new BigDecimal(100),"xielian",200,300,"")));
	}

	@Test
	void testQueryBookById() {
		if(bookDao.queryBookById(1).getName().equalsIgnoreCase("java从入门到放弃")) {
			System.out.println("Correct book");
		}else {
			System.out.println("Wrong book");
		}
	}

	@Test
	void testDeleteBookById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBook() {
		fail("Not yet implemented");
	}

	@Test
	void testQueryBooks() {
		fail("Not yet implemented");
	}

}
