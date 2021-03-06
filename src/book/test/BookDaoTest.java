package book.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

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
		bookDao.deleteBookById(20);
		if(bookDao.queryBookById(20)==null){
			System.out.println("Delete successful");
		}else {
			System.out.println("Delete failed");
		}
	}

	@Test
	void testUpdateBook() {
		bookDao.updateBook(new Book(2,"天官赐福",new BigDecimal(100),"墨香铜臭",3000,2000,""));
		if(bookDao.queryBookById(2).getName().equalsIgnoreCase("天官赐福")) {
			System.out.println("Correct book");
		}else {
			System.out.println("Wrong book");
		}
	}

	@Test
	void testQueryBooks() {
		for(Book queryBook:bookDao.queryBooks()) {
			System.out.println(queryBook);
		}
	}
	
	@Test
	void testQueryForItemsNumber() {
		System.out.println(bookDao.queryForItemsNumber());
	}

	@Test
	void testQueryForPageItems() {
		bookDao.queryForPageItems(8, 4).forEach(System.out::println);
	}
	
	 @Test
	  void testQueryForItemsNumberByPrice() {
	    System.out.println(bookDao.queryForItemsNumberByPrice(10,50));
	  }

	  @Test
	  void testQueryForPageItemsByPrice() {
	    bookDao.queryForPageItemsByPrice(0, 30,10,50).forEach(System.out::println);
	  }

}
