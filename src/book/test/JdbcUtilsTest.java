package book.test;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import book.util.JdbcUtils;

public class JdbcUtilsTest {
	@Test
	public void testJdbcUtils() {
		for (int i = 0; i < 100; i++) {
			Connection conn = JdbcUtils.getConnection();
			System.out.println(conn);
		}
	}
}
