package cookieTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page")
public class page extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		res.getWriter().write("<html>");
		res.getWriter().write("<head>");
		res.getWriter().write("<body>");
		//res.getWriter().write("<p>"+str+"</p><br />");
		res.getWriter().write("<form action='cookieCheck' method = 'POST'>");
		res.getWriter().write("ÓÃ»§Ãû£º<input type = 'text' name = 'user' value = ''/><br />");
		res.getWriter().write("ÃÜÂë£º<input type = 'text' name = 'pwd' value = ''/><br />");
		res.getWriter().write("<button type = 'submit' >µÇÂ½</button>");
		res.getWriter().write("</body>");
		res.getWriter().write("</head>");
		res.getWriter().write("</html>");
		
		
	}

}
