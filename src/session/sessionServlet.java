package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionServlet")
public class sessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		String name = "ning";
		HttpSession ss = req.getSession();
		ss.setAttribute("name", name);
		//ss.setMaxInactiveInterval(50);//设置session有效期为50秒
		//ss.invalidate();//强制消除session
		System.out.println(ss.getId());
		
	
	
	}

}
