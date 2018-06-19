package com.kjh.hojak.domain;

import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table
@Entity
@ToString
public class User {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @CreatedDate
    @Column
    private LocalDateTime dt_create;
}
