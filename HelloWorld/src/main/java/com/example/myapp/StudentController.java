package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bbs")
public class StudentController {
	@RequestMapping("/get")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("hakbun", "1101");
		mav.addObject("name", "«—º€¿Ã");
		mav.setViewName("/get");
		return mav;
	}
	@RequestMapping("/insert")
	public ModelAndView insertStudent() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Insert Success");
		mav.setViewName("/insert");
		return mav;
	}
	@RequestMapping("/update")
	public ModelAndView updateStudent() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Update Success");
		mav.setViewName("/update");
		return mav;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteStudent() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Delete Success");
		mav.setViewName("/delete");
		return mav;
	}
}
