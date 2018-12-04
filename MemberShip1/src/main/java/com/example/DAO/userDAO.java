package com.example.DAO;

import java.util.List;

import com.oracle.vo.UserVO;

public interface userDAO {
	void create(UserVO uservo);
	UserVO read(String userid);
	List<UserVO> readAll();
	void update(String userid);
	void delete(String userid);
}
