package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.BoardService;
import com.example.vo.BoardVO;
import com.sun.istack.internal.logging.Logger;

@Controller
public class BoardController {
	private static Logger logger = Logger.getLogger(BoardController.class);
	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	@ResponseBody
	public Map insert(@RequestBody BoardVO board) {
		Map<String, Object> result = new HashMap<String, Object>();
		String title = board.getTitle();
		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		title = title.replaceAll("'", "''");
		board.setTitle(title);
		
		String contents = board.getContents();
		contents = contents.replaceAll("\r\n", "<br />");
		contents = contents.replaceAll("<", "&lt;");
		contents = contents.replaceAll(">", "&gt;");
		contents = contents.replaceAll("'", "''");
		board.setContents(contents);
		this.boardService.insertBoard(board);
 		result.put("code", Boolean.TRUE);
		return result;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "write"; // webapp/static/write.jsp
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Map list() {
		Map<String, Object> map = new HashMap<String, Object>();
		this.boardService.select(map);
		List<BoardVO> list = (List<BoardVO>)map.get("results");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("code", Boolean.TRUE);
		data.put("data", list);
		return data;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/{idx}",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView read(@PathVariable int idx) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idx", idx);
		this.boardService.selectBoard(map);
		List<BoardVO> list = (List<BoardVO>)map.get("result");
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list.get(0)); // 행이 하나밖에 없기때문에 0번째임
		mav.setViewName("view"); //static/view.jsp
		return mav;
	}
	
	@RequestMapping(value="/{idx}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable int idx) {
		this.boardService.deleteBoard(idx);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("code", Boolean.TRUE);
		return map;
	}
	
	@RequestMapping(value="/{idx}",method=RequestMethod.PUT)
	@ResponseBody
	public Map update(@PathVariable int idx, @RequestBody BoardVO board) {
		board.setIdx(idx);
		this.boardService.updateBoard(board);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("code", Boolean.TRUE);
		return map;
	}
	
	
/*	@RequestMapping(value = "/test", method=RequestMethod.GET)
	public void test() {
		for(int i = 1 ; i <= 1000 ; i++) {
			BoardVO board = new BoardVO();
			board.setName("호날두");
			board.setEmail("ronaldo@aaa.com");
			board.setTitle(i + "번째 글입니다.");
			board.setContents(i + "번째 글입니다.");
			this.boardService.insertBoard(board);
		}
	}*/
	
}



