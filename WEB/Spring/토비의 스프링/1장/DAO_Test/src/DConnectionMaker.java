import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {
	
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver"); 		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hojak99", "0430");
		
		return connection;
	}
}
