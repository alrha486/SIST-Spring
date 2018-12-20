package com.example.service;

import java.util.Map;

import com.example.vo.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO board);
	void selectBoard(Map map);
	void select(Map map);
	void updateBoard(BoardVO board);
	void deleteBoard(int idx);
	void answerBoard(BoardVO board);
	void getTotalCount(Map map);
}