package book.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import book.util.JdbcUtils;

public abstract class BaseDao {
	private QueryRunner queryRunner = new QueryRunner();
	
	/**
	 * used for execute insert/update/delete sql statements
	 * @param sql
	 * @param args
	 * @return -1 means failed
	 */
	public int update(String sql, Object ... args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.update(conn,sql,args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return -1;
	}
	
	/**
	 * Query and return a javaBean
	 * @param <T>
	 * @param type
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T>T queryForOne(Class<T> type, String sql,Object... args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return null;
	}
	
	/**
	 * Query and return a list of javabean.
	 * @param <T>
	 * @param type
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T>List<T> queryForList(Class<T> type, String sql,Object... args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return null;
	}
	
	/**
	 * Query and return a single row or column
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object queryForSingleValue(String sql,Object... args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.query(conn, sql, new ScalarHandler(), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

}
