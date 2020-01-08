package cookieTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mainPage")
public class mainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset = utf-8");
		
		//取出cookie
		String value = null ;
		Cookie[] c =req.getCookies();
		for (Cookie cookie : c) {
			String name = cookie.getName();
			value = cookie.getValue();
			System.out.println(name+":"+value);
		}
		
		
		res.getWriter().write("<html>");
		res.getWriter().write("<head>");
		res.getWriter().write("<h1>欢迎"+c[0].getValue()+"来到上海理工大学</h1>");
		res.getWriter().write("</head>");
		res.getWriter().write("<html>");
		
		
	
	}

}
