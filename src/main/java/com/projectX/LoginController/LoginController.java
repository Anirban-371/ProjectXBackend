package com.projectX.LoginController;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
/*import org.apache.shiro.authz.annotation.RequiresPermissions;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectX.Customer.Request.CustomerDetailsRequest;
import com.projectX.Customer.Response.CustomerDetailsResponse;
import com.projectX.CustomerService.CustomerService;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method= RequestMethod.POST, value="/login",
			 		consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
			 		produces = {MediaType.APPLICATION_JSON_VALUE})
	
	public @ResponseBody boolean loginUser(String username, String password) {
		System.out.println("Inside login for customer ::"+ username);
		Subject currentUser = SecurityUtils.getSubject();
		if(StringUtils.hasText(username) && StringUtils.hasText(password)) {
			try {
				currentUser.login(new UsernamePasswordToken(username,password));
			}catch(Exception e) {
				return false;
			}
			return true; 
		}
		return false;
		//return customerService.loginCustomer(customer);
	}
	
}
