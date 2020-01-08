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

		// 取出提交的表单数据
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		System.out.println("表单数据" + user + ":" + pwd);

		Cookie[] cs = req.getCookies();

		// cookie为空，表单有数据/无数据
		if (cs == null) {
			if (user == null || pwd == null || user.equals("") || pwd.equals("")) {
				res.getWriter().write("请输入用户名和密码");
				res.sendRedirect("login1");
				return;
			} else {
				// 表单不为空 表单数据正确到main，第一次登陆，将用户名和密码放到cookie中
				if (user.equals("ningjing") && pwd.equals("111")) {
					Cookie cc = new Cookie("user", user);
					Cookie dd = new Cookie("pwd", pwd);
					res.addCookie(cc);
					res.addCookie(dd);

					res.sendRedirect("main1");
					return;
				} else {// 表单数据 不正确到page
					res.getWriter().write("用户名或密码错误");
					res.sendRedirect("page1");
					return;
				}
			}

		} else {// cookie不为空，验证cookie知是否正确，正确跳main1，不正确跳login1
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
					res.getWriter().write("cookie失效");
					res.sendRedirect("login1");
				}

			}

		}

	}
}
