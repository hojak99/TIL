import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionMaker connectionMakerD = new DConnectionMaker();
		ConnectionMaker connectionMakerN = new NConnectionMaker();
		
		UserDao daoD = new UserDao(connectionMakerD);
		UserDao daoN = new UserDao(connectionMakerN);
	}

}
