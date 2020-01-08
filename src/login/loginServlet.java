package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//设置响应编码格式  post方法
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		//获取相应数据
		String name = req.getParameter("name");
		//设置请求编码格式 该方式对于get和post方法通用
		//name = new String(name.getBytes("iso8859-1"),"utf-8");
		String pwd = req.getParameter("pwd");
		System.out.println(name+":"+pwd);
		
		if(name != null ) {
			Cookie c = new Cookie("name",name);
			//c.setPath("main");//设置指定访问路径 才能获取cookie
			//c.setMaxAge(2*24*3600);
			//res.addCookie(c);
		}
		//设置cookie
		
		//处理数据
		if(name.equals("宁静") && pwd.equals("111")) {
			res.getWriter().write("登陆成功");
			//req.getRequestDispatcher("main").forward(req, res);
			
			
			
			res.sendRedirect("/servlet/main");
		}else {
			//res.getWriter().write("登陆失败");
			req.setAttribute("str", "用户名或密码错误");
			
		
			req.getRequestDispatcher("pageServlet").forward(req, res);
			//System.out.println("hello");
			return;
		}
		//返回结果
		
		
		
		
	}

}
