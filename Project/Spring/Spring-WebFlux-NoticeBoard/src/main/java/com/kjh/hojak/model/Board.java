package com.kjh.hojak.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Document(collection="boards")
public class Board {
	
	@Id
	private String id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	@NotNull
	private Date dt_create = new Date();
	
	@NotNull
	private String writer_id;
	
	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", dt_create=" + dt_create
				+ ", writer_id=" + writer_id + "]";
	}
}
