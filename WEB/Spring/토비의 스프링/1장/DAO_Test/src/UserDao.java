import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDao();
		
		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPassword("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + ": 등록 성공");
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + ": 조회 성공");
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
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
		Connection connection = getConnection();
		
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
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hojak99", "0430");
		
		return connection;
	}
}
