package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.userDAO;
import com.oracle.vo.UserVO;

@Service("UserService")
public class userServiceImpl implements UserService{ // UserService 인터페이스를 상속받음. 메소드 재정의

	@Autowired // 자동 바인딩
	userDAO userDAO; 
	
	@Override
	public void createUser(UserVO uservo) {
		this.userDAO.create(uservo);
		
	}

	@Override
	public UserVO readUser(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> selectAllUser() {
			return this.userDAO.readAll();
	}

	@Override
	public void updateUser(String userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String userid) {
		this.userDAO.delete(userid);
		
	}

}
