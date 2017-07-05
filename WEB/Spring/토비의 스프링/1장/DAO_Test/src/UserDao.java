import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker){
		this.connectionMaker = connectionMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection connection = connectionMaker.makeConnection();
		
		PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO users(id, name, password) values(?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeQuery();
		ps.close();
		connection.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection connection = connectionMaker.makeConnection();
		
		PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM users WHERE id = ?"
		);
		ps.setString(1, id);
	
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		
		User user = new User();
		user.setId(resultSet.getString("id"));
		user.setName(resultSet.getString("name"));
		user.setPassword(resultSet.getString("password"));
		
		resultSet.close();
		ps.close();
		connection.close();
		
		return user;
	}
}

