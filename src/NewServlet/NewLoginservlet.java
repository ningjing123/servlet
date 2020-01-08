package NewServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newProm.User;
import newservice.LoginServiceImple;
import newservice.NewLoginService;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class NewLoginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charsetUTF-8");
		
		String uname = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		System.out.println(uname+":"+pwd);
	
		//获取业务层对象
		NewLoginService ls = new LoginServiceImple();
		User u = ls.checkLoginService(uname, pwd);
		System.out.println(u);
	
	}

}
