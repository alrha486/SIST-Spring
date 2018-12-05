package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public void createUser(UserVO userVo) {
		this.userDao.create(userVo);
	}

	@Override
	public UserVO readUser(String userid) {
		return this.userDao.read(userid);
	}

	@Override
	public List<UserVO> selectAllUsers() {
		return this.userDao.readAll();
	}

	@Override
	public void updateUser(String userid, String city) {
		this.userDao.update(userid, city);
	}

	@Override
	public void deleteUser(String userid) {
		this.userDao.delete(userid);
	}

}
