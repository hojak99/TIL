package model;

import java.util.Date;

public class Notice {
	
	private int number;
	private int count;
	private String writer;
	private String title;
	private String body;
	private Date date;

	public Notice(int number, String writer, Date date, String title, String body, int count) {
		this.number = number;
		this.count = count;
		this.writer = writer;
		this.title = title;
		this.body = body;
		this.date = date;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
