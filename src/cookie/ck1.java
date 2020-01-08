package cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ck1")
public class ck1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// �ж��Ƿ��һ�ε�½
		// ��ȡ�û��ύ�ı� ���������Ϊ�գ���Ϊ��һ�ε�½��
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		System.out.println("������" + user + ":" + pwd);

		//���cookie
		Cookie c = new Cookie("uid", "111");
		c.setPath("/login1");


		// ��ȡcookie���ж�cookie�Ƿ�Ϊ��
		Cookie[] cs = req.getCookies();
		String value = null;

		if (cs != null) {//cookie��Ϊ��
			for (Cookie cookie :cs) { 
				if (cookie.getName().equals("uid")) { 
					value = cookie.getValue(); 
					if(value.equals("111")) {//cookie��ȷ��main������ص�login
						res.sendRedirect("main1");
						return;
					}else {
						res.addCookie(c);
						res.sendRedirect("login1");
						return;
					}
				}
			}
				 
		} else {// cookieΪ��
				// ��Ϊ��
			res.addCookie(c);
			if (user == null || pwd == null || user.equals("") || pwd.equals("")) {
				res.sendRedirect("login1");
				return;
			} else {
				// ����Ϊ��  ��������ȷ��main  ����ȷ��page
				if (user.equals("ningjing") && pwd.equals("111")) {
					res.sendRedirect("main1");
					return;
				}else {
					res.sendRedirect("page1");
					return;
				}

			}

		}
	}
}
