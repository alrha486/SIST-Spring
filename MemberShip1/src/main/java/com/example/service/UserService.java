package com.example.service;

import java.util.List;

import com.example.vo.UserVO;

public interface UserService {
	void createUser(UserVO userVo);
	UserVO readUser(String userid);
	List<UserVO> selectAllUsers();
	void updateUser(String userid, String city);
	void deleteUser(String userid);
}
