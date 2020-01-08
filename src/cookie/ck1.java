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

		// 判断是否第一次登陆
		// 获取用户提交的表单 如果表单数据为空，则为第一次登陆。
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		System.out.println("表单数据" + user + ":" + pwd);

		//添加cookie
		Cookie c = new Cookie("uid", "111");
		c.setPath("/login1");


		// 获取cookie，判断cookie是否为空
		Cookie[] cs = req.getCookies();
		String value = null;

		if (cs != null) {//cookie不为空
			for (Cookie cookie :cs) { 
				if (cookie.getName().equals("uid")) { 
					value = cookie.getValue(); 
					if(value.equals("111")) {//cookie正确到main，错误回到login
						res.sendRedirect("main1");
						return;
					}else {
						res.addCookie(c);
						res.sendRedirect("login1");
						return;
					}
				}
			}
				 
		} else {// cookie为空
				// 表单为空
			res.addCookie(c);
			if (user == null || pwd == null || user.equals("") || pwd.equals("")) {
				res.sendRedirect("login1");
				return;
			} else {
				// 表单不为空  表单数据正确到main  不正确到page
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
