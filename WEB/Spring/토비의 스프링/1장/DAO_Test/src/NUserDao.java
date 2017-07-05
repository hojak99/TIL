import java.sql.Connection;
import java.sql.SQLException;

public class NUserDao extends UserDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		return null;
	}
}