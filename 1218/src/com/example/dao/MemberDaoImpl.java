package com.example.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void create(MemberVO memberVo) {
		this.sqlSession.insert("Member.insertSP",memberVo);		
	}

	@Override
	public void read(Map map) {
		this.sqlSession.selectOne("Member.selectOneSP",map);
		
	}

	@Override
	public void readAll(Map map) {
		this.sqlSession.selectList("Member.selectAllSP",map);
	}

	@Override
	public void update(MemberVO memberVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String userid) {
		// TODO Auto-generated method stub
		
	}
}
