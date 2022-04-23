package book.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtils {

	private static DruidDataSource dataSource;
	private static ThreadLocal<Connection> conns = new ThreadLocal<>();

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
		Connection conn = conns.get();
		if(conn==null) {
		  try {
        conn = dataSource.getConnection();
        conns.set(conn);
        conn.setAutoCommit(false);
      } catch (SQLException e) {
        e.printStackTrace();
      }
		}
		return conn;
	}

}
