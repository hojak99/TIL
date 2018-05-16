package com.kjh.hojak.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjh.hojak.user.dao.UserDao;
import com.kjh.hojak.user.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public void insertUser(UserVO user) {
		userDao.insert(user);
	}

	@Override
	public List<UserVO> getUserList() {
		return userDao.readAll();
	}

	@Override
	public void deleteUser(String id) {
		userDao.delete(id);
	}

	@Override
	public UserVO getUser(String id) {
		return userDao.read(id);
	}

	@Override
	public void updateUser(UserVO user) {
		userDao.update(user);
	}
	
}
