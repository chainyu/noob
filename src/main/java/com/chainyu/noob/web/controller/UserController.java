package com.chainyu.noob.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/info.htm")
	public String showUserInfo(Model model){
		model.addAttribute("name", "zhangsan");
		return "/showInfo";
	}
	
	@RequestMapping("/index.htm")
	public String Index(){
		return "/index";
	}
	
	@RequestMapping("/login.htm")
	public String Login(){
		return "/login";
	}
}
