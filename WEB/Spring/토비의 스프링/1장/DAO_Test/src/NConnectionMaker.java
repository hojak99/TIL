import java.sql.Connection;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker {
	
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		// N사의 독자적인 방법으로 Connection 을 생성하는 코드
		return null;
	}
}
