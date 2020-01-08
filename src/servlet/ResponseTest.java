package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseTest
 */
@WebServlet("/ResponseTest")
public class ResponseTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");//通知浏览器用utf-8解析
		response.getWriter().write("你好呀");//向浏览器输出内容
		response.setHeader("keyboard", "mac");//key相同时，后一个key对应的value值会覆盖前一个值。
		response.addHeader("hi", "hello");//key值可相同
		//response.sendError(405, "post不匹配");
	
	
	
	}

}
