package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;

public class NoticeListController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		NoticeDao noticeDao = new NoticeDao();

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String body = request.getParameter("body");

		if (!(title.isEmpty()) && !(writer.isEmpty()) && !(body.isEmpty())) {
			try {
				noticeDao.addNotice(writer, new Date(System.currentTimeMillis()), title, body, 0);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException c) {
				c.printStackTrace();
			}
		}

		System.out.println(title + "  " + writer);
		response.sendRedirect("index.jsp");
	}
}
