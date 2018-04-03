package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import model.Notice;

public class NoticeDao {
	
	private static int noticeCount  = 1;
	
	public void addNotice(String writer, Date date, String title, String body, int count)
			throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();
		PreparedStatement ps = connection
				.prepareStatement("INSERT INTO notice(number, writer, date, title, body, count) values (?,?,?,?,?,?)");

		ps.setInt(1, noticeCount);
		ps.setString(2, writer);
		ps.setTimestamp(3, new Timestamp(date.getTime()));
		ps.setString(4, title);
		ps.setString(5, body);
		ps.setInt(6, count);

		ps.executeUpdate();
		ps.close();
		connection.close();

		noticeCount += 1;
	}

	public ArrayList<Notice> getNoticeList() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM notice");

		ArrayList<Notice> noticeList = new ArrayList<Notice>();

		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			int number = rs.getInt("number");
			int count = rs.getInt("count");
			String writer = rs.getString("writer");
			String title = rs.getString("title");
			String body = rs.getString("body");
			Date date = rs.getTimestamp("date");

			Notice notice = new Notice(number, writer, date, title, body, count);
			noticeList.add(notice);
		}

		ps.executeQuery();
		ps.close();
		connection.close();

		return noticeList;
	}

	public ArrayList<Notice> getNoticeList(String writer) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM notice WHERE writer = ?");

		ps.setString(1, writer);

		ArrayList<Notice> noticeList = new ArrayList<Notice>();

		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			int number = rs.getInt("number");
			int count = rs.getInt("count");
			String title = rs.getString("title");
			String body = rs.getString("body");
			Date date = rs.getTimestamp("date");

			Notice notice = new Notice(number, writer, date, title, body, count);
			noticeList.add(notice);
		}

		ps.executeQuery();
		ps.close();
		connection.close();

		return noticeList;
	}

	public ArrayList<Notice> getNoticeList(int number) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM notice WHERE writer = ?");

		ps.setInt(1, number);

		ArrayList<Notice> noticeList = new ArrayList<Notice>();

		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			int count = rs.getInt("count");
			String writer = rs.getString("writer");
			String title = rs.getString("title");
			String body = rs.getString("body");
			Date date = rs.getTimestamp("date");

			Notice notice = new Notice(number, writer, date, title, body, count);
			noticeList.add(notice);
		}

		ps.executeQuery();
		ps.close();
		connection.close();

		return noticeList;
	}

	public void deleteNotice(Notice notice) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM notice WHERE number = ?");

		ps.setInt(1, notice.getNumber());
		ps.executeUpdate();
		ps.close();
		connection.close();
	}

	public void deleteNotice(int number) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM notice WHERE number = ?");

		ps.setInt(1, number);
		ps.executeUpdate();
		ps.close();
		connection.close();
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:5036/noticeboard", "root", "0430");

		return connection;
	}
}
