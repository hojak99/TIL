import java.sql.SQLException;
import java.util.Date;

import dao.NoticeDao;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeDao dao = new NoticeDao();
		//dao.addNotice("writer", new Date(System.currentTimeMillis()), "title", "body", 0);
		dao.deleteNotice(3);
		
	}
}
