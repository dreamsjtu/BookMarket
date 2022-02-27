package book.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtils {

	private static DruidDataSource dataSource;

	static {
		try {
			Properties properties = new Properties();
			//Read the jdbc.properties config file.
			InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//Load data from inputStream
			properties.load(inputStream);
			//Create a database connection pool
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
			//For testing
//			System.out.println(dataSource.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Get a connection from the database connections pool.
	 * 
	 * @return a connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Close the connection
	 */
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	//for testing
//	public static void main(String[] args) {
//		
//	}

}
