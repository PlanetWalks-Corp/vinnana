package com.ksush;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {
	private final Logger log = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")
	public String home(){
		return "home.jsp";
	}

	@GetMapping("/login")
	public String loginPage(){
		log.debug("Opening login page");
		return "login.jsp";
	}

	@GetMapping("/logout-success")
	public String logoutPage(){
		return "logout.jsp";
	}

	@GetMapping("user")
	@ResponseBody
	public Principal user(Principal principal){
		return principal;
	}
}
