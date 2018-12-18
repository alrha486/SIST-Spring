package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class myController {
	
	@RequestMapping("/demo")
	public ModelAndView demo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userid","javaexpert");
		mav.addObject("userpasswd","123456");
		mav.setViewName("/demo"); 
		return mav;
	}
}
