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
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		
		//������Ӧ�����ʽ
		res.setContentType("text/html;charset= utf-8");
		String str = (String) req.getAttribute("str") == null ? "" :(String) req.getAttribute("str") ;
		//str == null ? "" :(String) req.getAttribute("str") ;
		//System.out.println(str);
	//��ȡ��������
	//��������
	//���ؽ��
		res.getWriter().write("<html>");
		res.getWriter().write("<head>");
		res.getWriter().write("<body>");
		res.getWriter().write("<p>"+str+"</p><br />");
		res.getWriter().write("<form action='loginServlet' method = 'POST'>");
		res.getWriter().write("�û�����<input type = 'text' name = 'name' value = ''/><br />");
		res.getWriter().write("���룺<input type = 'text' name = 'pwd' value = ''/><br />");
		res.getWriter().write("<button type = 'submit' >��½</button>");
		res.getWriter().write("</body>");
		res.getWriter().write("</head>");
		res.getWriter().write("</html>");
	
	
	}

}
