package com.projectX.LoginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectX.Customer.Request.CustomerDetailsRequest;
import com.projectX.CustomerService.CustomerService;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/login")
	public boolean loginUser(@RequestBody CustomerDetailsRequest customer) {
		System.out.println("Inside login for customer ::"+ customer);
		return customerService.loginCustomer(customer);
	}
	
}
