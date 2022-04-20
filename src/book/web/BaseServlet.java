package book.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet{

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
			try {
				//Get the related method of the action.
				Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class, HttpServletResponse.class);
				//Invoke the related method.
				method.invoke(this,request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
