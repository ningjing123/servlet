package newservice;

import NewDao.NewLoginDao;
import NewDao.NewLoginDaoImple;
import newProm.User;

public class LoginServiceImple implements NewLoginService{

	NewLoginDao dao = new NewLoginDaoImple();
	@Override
	public User checkLoginService(String uname, String pwd) {
		
		return dao.checkLoginDao(uname, pwd);
	}

}
