package book.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import book.util.JdbcUtils;

public class TransactionFilter implements Filter{

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    try {
      JdbcUtils.commitAndClose();
      chain.doFilter(request, response);
    } catch (Exception e) {
      JdbcUtils.rollbackAndClose();
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

}
