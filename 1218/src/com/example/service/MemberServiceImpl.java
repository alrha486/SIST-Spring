package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDao;
import com.example.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;

	@Override
	public void insertMember(MemberVO memberVo) {
		this.memberDao.create(memberVo);		
	}

	@Override
	public void selectMember(Map map) {
		this.memberDao.read(map);
		
	}

	@Override
	public void select(Map map) {
		this.memberDao.readAll(map);		
	}

	@Override
	public void updateMember(MemberVO memberVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub
		
	}
	
}
