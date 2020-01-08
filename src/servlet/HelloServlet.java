package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1;
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse pon) throws ServletException, IOException {
		System.out.println("我是services方法");
		System.out.println(req.getMethod());//请求方式
		System.out.println(req.getScheme());//请求协议
		System.out.println(req.getRequestURL());//请求的URL
		System.out.println("----------------");
		//请求头
		System.out.println(req.getHeader("aa"));
		Enumeration<String> e = req.getHeaderNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			String value = req.getHeader(name);
			System.out.println(name+":"+value);
		}
		System.out.println("--------------------------------------");
		//获取用户数据
		System.out.println(req.getParameter("name"));//name对应的是jsp文件中的name属性对应的值，若name值为中文“姓名”，则输出null。需要用英文表示
		Enumeration<String> ee = req.getParameterNames();//获取用户提交的
		while(ee.hasMoreElements()) {
			String name = ee.nextElement();
			String value = req.getParameter(name);
			System.out.println(name+":"+value);
			
		}
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("我是post方法");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("我是get方法");
	}

}
