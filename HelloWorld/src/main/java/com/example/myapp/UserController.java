package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/view")
	public String view(Model model){
		model.addAttribute("currentDate", new java.util.Date());
		return "view"; // /WEB-INF/views/view + .jsp
	}
	@RequestMapping("/view1")
	public String view1(Model model) {
		model.addAttribute("username","วัม๖นฮ");
		model.addAttribute("userage","15");
		model.addAttribute("userclass","3");
		model.addAttribute("usergrade","5");
		return "view1"; // /WEB-INF/views/view1.jsp 
				
	}
	
	@RequestMapping("/bbs/view")
	public String view2(Model model) {
		String [] array = {"mango","apple","banana","grape"};
		model.addAttribute("fruits",array);
		return "view2";  
				
	}
}
