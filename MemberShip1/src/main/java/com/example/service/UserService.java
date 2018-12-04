package com.example.service;

import java.util.List;

import com.oracle.vo.UserVO;

public interface UserService {
	void createUser(UserVO uservo);
	UserVO readUser(String userid);
	List<UserVO> selectAllUser();
	void updateUser(String userid);
	void deleteUser(String userid);
}
