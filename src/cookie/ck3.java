package cookie;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ck3")
public class ck3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");

		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		System.out.println("������" + user + ":" + pwd);
		
		//�жϵ�һ�ε�½���洢�û�����������cookie
		Cookie[] cookie = req.getCookies();
		
		if(cookie == null) {
			// ��һ�ε�½ �û���������ȷ����ת��mainҳ��
			if (user == null || pwd == null || user.equals("") || pwd.equals("")) {
				res.getWriter().write("�������û���������");
				res.sendRedirect("login1");
				return;
			} else {
				if (user.equals("ningjing") && pwd.equals("111")) {
					
					HttpSession hs = req.getSession();
					hs.setAttribute("user", user);
					hs.setAttribute("pwd", pwd);
					
					//��תmainҳ��֮ǰ ���������� �������洢��context��
					
					
					ServletContext sc =  this.getServletContext();
					if(sc.getAttribute("num") == null ){
						this.getServletContext().setAttribute("num", 1);
					}else {
						System.out.println(sc.getAttribute("num"));
						int num = (int) sc.getAttribute("num");
						num++;
						this.getServletContext().setAttribute("num", num);
					}
					
					res.sendRedirect("main1");
				} else {
					res.getWriter().write("�û������������");
				}

			}
		}else {
			
			int num = (int) this.getServletContext().getAttribute("num");
			num++;
			this.getServletContext().setAttribute("num", num);
			res.sendRedirect("main1");
			return;
		}
		
		
		
		}
		

}
