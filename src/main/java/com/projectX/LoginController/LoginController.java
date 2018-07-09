package com.projectX.LoginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectX.Customer.CustomerDetails;
import com.projectX.Customer.Request.CustomerDetailsRequest;
import com.projectX.Customer.Response.CustomerDetailsResponse;
import com.projectX.CustomerService.CustomerService;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method= RequestMethod.POST, value="/login",
			 		consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE},
			 		produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	
	public @ResponseBody CustomerDetailsResponse loginUser(@RequestBody CustomerDetailsRequest customer) {
		System.out.println("Inside login for customer ::"+ customer);
		return customerService.loginCustomer(customer);
	}
	
}
