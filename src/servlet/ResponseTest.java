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
		response.setContentType("text/html; charset=UTF-8");//֪ͨ�������utf-8����
		response.getWriter().write("���ѽ");//��������������
		response.setHeader("keyboard", "mac");//key��ͬʱ����һ��key��Ӧ��valueֵ�Ḳ��ǰһ��ֵ��
		response.addHeader("hi", "hello");//keyֵ����ͬ
		//response.sendError(405, "post��ƥ��");
	
	
	
	}

}
