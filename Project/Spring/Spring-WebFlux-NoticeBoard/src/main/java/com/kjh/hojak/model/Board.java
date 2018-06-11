package com.kjh.hojak.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@ToString
@Data
@Document(collection="boards")
public class Board {
	
	@Id
	private String id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	private Date dt_create = new Date();
	
	@NotNull
	private String writer_id;

}
