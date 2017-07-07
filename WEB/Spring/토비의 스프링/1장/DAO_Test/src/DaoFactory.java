import java.sql.Connection;

public class DaoFactory {
	public UserDao userDaoD(){
		ConnectionMaker connectionMakerD = new DConnectionMaker();
		UserDao userDaoD = new UserDao(connectionMakerD);
		
		return userDaoD;
	}
	
	public UserDao userDaoN(){
		ConnectionMaker connectionMakerN = new NConnectionMaker();
		UserDao userDaoN = new UserDao(connectionMakerN);
		
		return userDaoN;
	}
}
