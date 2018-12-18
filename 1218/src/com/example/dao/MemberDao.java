package com.example.dao;

import java.util.Map;

import com.example.vo.MemberVO;

public interface MemberDao {
	void create(MemberVO memberVo);
	void read(Map map);
	void readAll(Map map);
	void update(MemberVO memberVo);
	void delete(String userid);
}
