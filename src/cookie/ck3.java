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
		System.out.println("表单数据" + user + ":" + pwd);
		
		//判断第一次登陆，存储用户名和密码在cookie
		Cookie[] cookie = req.getCookies();
		
		if(cookie == null) {
			// 第一次登陆 用户名密码正确，跳转到main页面
			if (user == null || pwd == null || user.equals("") || pwd.equals("")) {
				res.getWriter().write("请输入用户名和密码");
				res.sendRedirect("login1");
				return;
			} else {
				if (user.equals("ningjing") && pwd.equals("111")) {
					
					HttpSession hs = req.getSession();
					hs.setAttribute("user", user);
					hs.setAttribute("pwd", pwd);
					
					//跳转main页面之前 创建计数器 计数器存储在context中
					
					
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
					res.getWriter().write("用户名或密码错误");
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
