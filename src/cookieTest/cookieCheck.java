package cookieTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCheck")
public class cookieCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		
		//��ȡ�ύ���û���������
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		System.out.println("�û�������û���������---"+user +":"+pwd);
		
		String name = null;
		String value = null;
		Cookie[] c =req.getCookies();
		
		//��cookie��Ϊ�գ���ȡ����ֵ��
		if(c != null) {
			Cookie name1= new Cookie("name",user);
			Cookie pwd1 = new Cookie("pwd", pwd);
			name1.setPath("page");
			pwd1.setPath("page");
			res.addCookie(name1);
			res.addCookie(pwd1);

			for (Cookie cookie : c) {
				name = cookie.getName();
				value = cookie.getValue();
	
				//�жϼ�ֵ�� ��ֵ�Ƿ���ȷ
				//�ж��û��������Ƿ���ȷ
				if((c[0].getValue()).equals("ningjing") && (c[1].getValue()).equals("123")) {
					res.sendRedirect("/servlet/mainPage");
					return;
				}else {
					System.out.println("�û��������������");
					res.sendRedirect("/servlet/page");
					return;
				}
			}
		}else {
			//cookieΪ�ռ���һ�ε�½����ص�pageҳ�������û�������
			
			res.sendRedirect("/servlet/mainPage");
			return;
			
		}
		
		
	}

}
