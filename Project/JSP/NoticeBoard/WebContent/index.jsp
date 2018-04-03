<%@page import="model.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.NoticeDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
	NoticeDao noticeDao = new NoticeDao();
	ArrayList<Notice> noticeList = noticeDao.getNoticeList();
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notice Board</title>
</head>
<body>
	<h1>게시글 리스트</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<% for(Notice tempNotice : noticeList) { %>
		<tr>
			<td><%= tempNotice.getNumber() %></td>
			<td><%= tempNotice.getTitle() %></td>
			<td><%= tempNotice.getWriter() %></td>
			<td><%= tempNotice.getDate() %></td>
			<td><%= tempNotice.getCount() %></td>
		</tr>
		<%} %>
	</table>
	<a href="writer.jsp">글쓰기</a>
</body>
</html>