package com.kjh.hojak.repository;

import com.kjh.hojak.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 모든 User 가져오기
     * @param pageable
     * @return
     */
    Page<User> findAll(Pageable pageable);
}
