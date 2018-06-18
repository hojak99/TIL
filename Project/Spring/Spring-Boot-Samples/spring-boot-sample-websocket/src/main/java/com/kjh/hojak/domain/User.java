package com.kjh.hojak.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String email;
}
