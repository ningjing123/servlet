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
		System.out.println("����services����");
		System.out.println(req.getMethod());//����ʽ
		System.out.println(req.getScheme());//����Э��
		System.out.println(req.getRequestURL());//�����URL
		System.out.println("----------------");
		//����ͷ
		System.out.println(req.getHeader("aa"));
		Enumeration<String> e = req.getHeaderNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			String value = req.getHeader(name);
			System.out.println(name+":"+value);
		}
		System.out.println("--------------------------------------");
		//��ȡ�û�����
		System.out.println(req.getParameter("name"));//name��Ӧ����jsp�ļ��е�name���Զ�Ӧ��ֵ����nameֵΪ���ġ��������������null����Ҫ��Ӣ�ı�ʾ
		Enumeration<String> ee = req.getParameterNames();//��ȡ�û��ύ��
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
		System.out.println("����post����");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("����get����");
	}

}
