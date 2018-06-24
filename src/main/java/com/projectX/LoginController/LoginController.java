package com.projectX.LoginController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
	
}
