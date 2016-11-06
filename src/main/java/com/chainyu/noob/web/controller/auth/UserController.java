package com.chainyu.noob.web.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chainyu.noob.web.controller.BaseController;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@RequestMapping("/userManage.htm")
	public String showUserInfo(Model model){
		model.addAttribute("name", "zhangsan");
		return "/showInfo";
	}
	
}
