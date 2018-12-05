package com.example.dao;

import java.util.List;

import com.example.vo.UserVO;

public interface UserDao {
	void create(UserVO userVo);
	UserVO read(String userid);
	List<UserVO> readAll();
	void update(String userid, String city);
	void delete(String userid);
}
