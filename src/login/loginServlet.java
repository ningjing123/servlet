package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//������Ӧ�����ʽ  post����
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		//��ȡ��Ӧ����
		String name = req.getParameter("name");
		//������������ʽ �÷�ʽ����get��post����ͨ��
		//name = new String(name.getBytes("iso8859-1"),"utf-8");
		String pwd = req.getParameter("pwd");
		System.out.println(name+":"+pwd);
		
		if(name != null ) {
			Cookie c = new Cookie("name",name);
			//c.setPath("main");//����ָ������·�� ���ܻ�ȡcookie
			//c.setMaxAge(2*24*3600);
			//res.addCookie(c);
		}
		//����cookie
		
		//��������
		if(name.equals("����") && pwd.equals("111")) {
			res.getWriter().write("��½�ɹ�");
			//req.getRequestDispatcher("main").forward(req, res);
			
			
			
			res.sendRedirect("/servlet/main");
		}else {
			//res.getWriter().write("��½ʧ��");
			req.setAttribute("str", "�û������������");
			
		
			req.getRequestDispatcher("pageServlet").forward(req, res);
			//System.out.println("hello");
			return;
		}
		//���ؽ��
		
		
		
		
	}

}
