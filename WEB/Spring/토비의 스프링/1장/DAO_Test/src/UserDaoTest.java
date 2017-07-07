import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao daoD = new DaoFactory().userDaoD();
		UserDao daoN = new DaoFactory().userDaoN();
	}

}
