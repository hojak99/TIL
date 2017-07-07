import java.sql.Connection;

public class DaoFactory {
	public UserDao userDaoD(){
		return new UserDao(connectionMaker());
	}
	
	public UserDao userDaoN(){
		return new UserDao(connectionMaker());
	}
	
	public AccountDao accountDao(){
		return new AccountDao(connectionMaker());
	}
	
	public MessageDao messageDao(){
		return new MessageDao(connectionMaker());
	}
	
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
}
