package cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ck2")
public class ck2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");

		// ȡ���ύ�ı�����
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		System.out.println("������" + user + ":" + pwd);

		Cookie[] cs = req.getCookies();

		// cookieΪ�գ���������/������
		if (cs == null) {
			if (user == null || pwd == null || user.equals("") || pwd.equals("")) {
				res.getWriter().write("�������û���������");
				res.sendRedirect("login1");
				return;
			} else {
				// ����Ϊ�� ��������ȷ��main����һ�ε�½�����û���������ŵ�cookie��
				if (user.equals("ningjing") && pwd.equals("111")) {
					Cookie cc = new Cookie("user", user);
					Cookie dd = new Cookie("pwd", pwd);
					res.addCookie(cc);
					res.addCookie(dd);

					res.sendRedirect("main1");
					return;
				} else {// ������ ����ȷ��page
					res.getWriter().write("�û������������");
					res.sendRedirect("page1");
					return;
				}
			}

		} else {// cookie��Ϊ�գ���֤cookie֪�Ƿ���ȷ����ȷ��main1������ȷ��login1
			for (Cookie cookie : cs) {

				String uservalue = "";
				String pwdvalue = "";
				
				if (cookie.getName().equals(user)) {
					uservalue = cookie.getValue();
				}
				if (cookie.getName().equals(pwd)) {
					pwdvalue = cookie.getValue();
				}
				
				if(uservalue.equals("ningjing") && pwdvalue.equals("111")) {
					res.sendRedirect("main1");
					return;
				}else {
					res.getWriter().write("cookieʧЧ");
					res.sendRedirect("login1");
				}

			}

		}

	}
}
