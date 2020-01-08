package NewDao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import newProm.User;

public class NewLoginDaoImple implements NewLoginDao{

	@Override
	public User checkLoginDao(String uname, String pwd) {
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/tx711:3306","root","2838559");
			String sql = "select * from t_user where uname=? and upwd =?";
			ps.getConnection().prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			
			while(rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		return u;
	}

}
