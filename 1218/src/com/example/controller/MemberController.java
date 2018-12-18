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

import com.example.service.MemberService;
import com.example.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "users/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public Map read(@PathVariable String userid) {
		Map<String, Object> map = new HashMap<String, Object>();
		//map은 뒤로 가는 객체
		map.put("userid", userid);
		this.memberService.selectMember(map);
		List<MemberVO> list = (List<MemberVO>)map.get("result");
		MemberVO memberVo = list.get(0);
		Map<String, Object> map1 = new HashMap<String, Object>();
		//map1은 사용자에게 전달될 객체
		map1.put("code", "success");
		map1.put("data", memberVo);
		return map1;
	}
	
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public Map create(@RequestBody MemberVO memberVo) {
		this.memberService.insertMember(memberVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		map.put("data", memberVo);
		return map;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public Map list() {
		Map<String, Object> map = new HashMap<String, Object>();
		this.memberService.select(map);
		List<MemberVO> list = (List<MemberVO>)map.get("results");
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("code", "success");
		map1.put("data", list);
		return map1;
	}
}
