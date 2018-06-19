package com.kjh.hojak.service;

import com.kjh.hojak.domain.User;
import com.kjh.hojak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void create(User user) throws Exception {
        Optional.ofNullable(user)
                .orElseThrow(() -> new Exception("UserService create error"));

        userRepository.save(user);
    }

    public List<User> getAllUser(Pageable pageable) throws Exception {
        return userRepository.findAll(pageable).stream().collect(Collectors.toList());
    }

    public List<User> findAll() throws Exception {
        return userRepository.findAll();
    }
}
