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
		
		
		//获取提交的用户名和密码
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		System.out.println("用户输入的用户名和密码---"+user +":"+pwd);
		
		String name = null;
		String value = null;
		Cookie[] c =req.getCookies();
		
		//若cookie不为空，则取出键值对
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
	
				//判断键值对 的值是否正确
				//判断用户名密码是否正确
				if((c[0].getValue()).equals("ningjing") && (c[1].getValue()).equals("123")) {
					res.sendRedirect("/servlet/mainPage");
					return;
				}else {
					System.out.println("用户名或者密码错误");
					res.sendRedirect("/servlet/page");
					return;
				}
			}
		}else {
			//cookie为空即第一次登陆，则回到page页面输入用户名密码
			
			res.sendRedirect("/servlet/mainPage");
			return;
			
		}
		
		
	}

}
