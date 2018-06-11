package com.kjh.hojak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kjh.hojak.domain.User;

public interface UserRepository extends JpaRepository<User, String>{

}
