package com.kjh.hojak.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;

@ToString
@Data
public class User {

    @Id
    private String id;

    private String writerId;

    private Date dt_create = new Date();
}
