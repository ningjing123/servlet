package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pageServlet")
public class pageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		
		//设置响应编码格式
		res.setContentType("text/html;charset= utf-8");
		String str = (String) req.getAttribute("str") == null ? "" :(String) req.getAttribute("str") ;
		//str == null ? "" :(String) req.getAttribute("str") ;
		//System.out.println(str);
	//获取请求数据
	//处理数据
	//返回结果
		res.getWriter().write("<html>");
		res.getWriter().write("<head>");
		res.getWriter().write("<body>");
		res.getWriter().write("<p>"+str+"</p><br />");
		res.getWriter().write("<form action='loginServlet' method = 'POST'>");
		res.getWriter().write("用户名：<input type = 'text' name = 'name' value = ''/><br />");
		res.getWriter().write("密码：<input type = 'text' name = 'pwd' value = ''/><br />");
		res.getWriter().write("<button type = 'submit' >登陆</button>");
		res.getWriter().write("</body>");
		res.getWriter().write("</head>");
		res.getWriter().write("</html>");
	
	
	}

}
