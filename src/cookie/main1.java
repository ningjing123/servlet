package cookie;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main1")
public class main1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		//获取cookie值
		String username = "";
	/*	Cookie[] cookie = req.getCookies();
		for (Cookie cookie2 : cookie) {
			if(cookie2.getName().equals("user")) {
				username = cookie2.getValue();
			}
		}*/
		
		//获取context中的num值
		ServletContext sc1 = this.getServletContext();
		System.out.println(sc1.getAttribute("num"));
		int num = (int) sc1.getAttribute("num");
		
		res.getWriter().write("welcome "+req.getSession().getAttribute("user")+" to China");
		res.getWriter().write("网站的访问次数为"+num);
	
	
	}

}
