package com.example.service;

import java.util.Map;

import com.example.vo.MemberVO;

public interface MemberService {
	void insertMember(MemberVO memberVo);
	void selectMember(Map map);
	void select(Map map);
	void updateMember(MemberVO memberVo);
	void deleteMember(String userid);
}
