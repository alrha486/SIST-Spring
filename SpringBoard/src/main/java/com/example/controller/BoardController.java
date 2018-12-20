package com.example.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.BoardService;
import com.example.vo.BoardVO;

@Controller
public class BoardController {
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
		contents = contents.replaceAll("<", "&lt;");
		contents = contents.replaceAll(">", "&gt;");
		contents = contents.replaceAll("'", "''");
		contents = contents.replaceAll("\r\n", "<br />");
		board.setContents(contents);
		this.boardService.insertBoard(board);
		result.put("code", "Insert success");
		return result;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "write"; // webapp/static/write.jsp
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}

}
