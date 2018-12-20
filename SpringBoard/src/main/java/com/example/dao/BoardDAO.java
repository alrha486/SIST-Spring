package com.example.dao;

import java.util.Map;

import com.example.vo.BoardVO;

public interface BoardDAO {
	void create(BoardVO board);
	void read(Map map);
	void readAll(Map map);
	void update(BoardVO board);
	void delete(int idx);
	void answer(BoardVO board);
	void getTotalCount(Map map);
}
