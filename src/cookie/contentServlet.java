package cookie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/contentServlet")
public class contentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path = this.getServletContext().getRealPath("/doc/1.txt");
	
	public void init(ServletConfig config) throws ServletException {
		//重启时，从文件中读取num    读进来  写出去
		
		FileReader reader = null;
		BufferedReader bf = null;
		
		
		try {
			 reader = new FileReader(path);
			 bf = new BufferedReader(reader);
			 String num =bf.readLine();
			 System.out.println(num);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

	
	public void destroy() {
		//关闭时，将num保存在文件中
		FileWriter fw = null;
		BufferedWriter bf = null;
		
		try {
			fw = new FileWriter(path);
			bf = new BufferedWriter(fw);
			int num = (int)this.getServletContext().getAttribute("num");
			bf.write(num);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	

}
