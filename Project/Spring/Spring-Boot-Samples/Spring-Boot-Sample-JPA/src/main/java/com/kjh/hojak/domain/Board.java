package com.kjh.hojak.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Table		// 테이블에 관한 정보를 기술한 어노테이션
@Entity		// 해당 클래스의 인스턴스가 엔티티임을 명시해주는 어노테이션
public class Board {
	
	/**
	 * @Id : Primary Key 로 매핑된다.
	 * @Column : 말 그대로 table column 이다.
	 * @GenerateValue : 해당 column 을 자동 관리한다. 
	 * 					GenerationType.AUTO 로 설정하면 JPA 가 알아서 DB 에 맞는 증가 방식을 붙여준다.
	 * 					GenerationType.IDENTITY : mysql 지원, oracle 미지원
	 * 					GenerationType.SEQUENCE : mysql 미지원, oracle 지원
	 * 					
	 * 
	 */
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;		
	
	@Column
	private String title;
	
	@Column(length=100, nullable=false)
	private String content;
	
	@Column
	private String writerId;
	
	@CreatedDate
	@Column
	private LocalDateTime create_dt = LocalDateTime.now();
	
	@CreatedDate
	@LastModifiedDate
	@Column
	private LocalDateTime update_dt = LocalDateTime.now();

	
	public Board() {}
	
	public Board(String writerId, String title, String content){
		this.writerId = writerId;
		this.content = content;
		this.title = title;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public LocalDateTime getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(LocalDateTime create_dt) {
		this.create_dt = create_dt;
	}

	public LocalDateTime getUpdate_dt() {
		return update_dt;
	}

	public void setUpdate_dt(LocalDateTime update_dt) {
		this.update_dt = update_dt;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", writerId=" + writerId
				+ ", create_dt=" + create_dt + ", update_dt=" + update_dt + "]";
	}
}
