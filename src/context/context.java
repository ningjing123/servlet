package context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/context")
public class context extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext servletContext;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc= this.getServletContext();
		ServletContext sc1= this.getServletConfig().getServletContext();
		ServletContext sc2 = req.getServletContext();
		System.out.println(sc == sc1);
		System.out.println(sc == sc2);
		//System.out.println(sc.toString());
		System.out.println();
		sc.setAttribute("name", "ning");
		String path = sc.getRealPath("/doc/1.txt");//��ȡ��Class�ļ��ľ���·��
		System.out.println(path);
		
		String name = sc.getInitParameter("name");//��ȡweb.xml��contxt-params���õĲ���ֵ
		System.out.println(name);
		
	
	}

}
