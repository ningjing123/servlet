package newpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import login.main;

public class jdbc {
	public static void main(String[] args) {
		// ����Connection����
		Connection con;
		// ����������
		String driver = "com.mysql.jdbc.Driver";
		// URLָ��Ҫ���ʵ����ݿ���mydata
		String url = "jdbc:mysql://localhost:3306/tx711";
		// MySQL����ʱ���û���
		String user = "root";
		// MySQL����ʱ������
		String password = "2838559";
		// ������ѯ�����
		try {
			// ������������
			Class.forName(driver);
			System.out.println("�����������ݿ⡣������");
			// 1.getConnection()����������MySQL���ݿ⣡��
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// 2.����statement���������ִ��SQL��䣡��
			Statement statement = con.createStatement();
			
			// Ҫִ�е�SQL���
			String sql = "select * from t_user";
			// 3.ResultSet�࣬������Ż�ȡ�Ľ��������
			ResultSet rs = statement.executeQuery(sql);
			

			String name ;
			int age ;
			String pwd ;
			int sex;
			while (rs.next()) {
				// ��ȡstuname��������
				name = rs.getString("uname");
				// ��ȡstuid��������
				age = rs.getInt("uage");
				sex= rs.getInt("usex");
				pwd = rs.getString("upwd");
				
				// ���ȫ��������Ϣ
				System.out.println(name + " " + age+" "+pwd+" "+sex);
			}
			rs.close();
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// ���ݿ��������쳣����
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// ���ݿ�����ʧ���쳣����
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("���ݿ����ݳɹ���ȡ����");
		}
	}

}
