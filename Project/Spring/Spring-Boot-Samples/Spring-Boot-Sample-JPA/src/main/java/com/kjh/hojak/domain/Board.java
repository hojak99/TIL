package com.kjh.hojak.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
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
	private String writer_id;
	
	@CreatedDate
	@Column
	private LocalDate create_dt;
	
	@CreatedDate
	@LastModifiedDate
	@Column
	private LocalDate update_dt;
}
