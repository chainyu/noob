package com.chainyu.noob.web.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chainyu.noob.model.constant.ErrorCodes;
import com.chainyu.noob.web.controller.BaseController;

@Controller
public class SecurityController extends BaseController {
	
	@RequestMapping({ "/", "/index.htm" })
	public String dashboard() {
		return "index";
	}
	
	@RequestMapping("/login.htm")
	public String Login(){
		return "/login";
	}
	
	
	@RequestMapping("/access-denied.htm")
	public String denie(Model model) {
		model.addAttribute("noRight", getMessage(ErrorCodes.ACCESS_DENIED));
		return "errors/403";
	}

}
