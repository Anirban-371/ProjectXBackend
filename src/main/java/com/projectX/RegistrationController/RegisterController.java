package com.projectX.RegistrationController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectX.Customer.Request.CustomerDetailsRequest;
import com.projectX.Customer.Response.CustomerDetailsResponse;
import com.projectX.CustomerService.CustomerService;


@RestController
public class RegisterController {
	
	@Autowired
	private CustomerService customerService; //Injecting CustomerService service into the variable customerService
	
	@RequestMapping("/allCustomers")
	public CustomerDetailsResponse getAllCustomers() {
		//@RestController will automatically convert to JSON
		return customerService.getCustomerDetails();
	}
	
	/*Individual Customer Retrieval*/
	@RequestMapping("/customer/{id}")
	public CustomerDetailsResponse getCustomer(@PathVariable String id) {
		return customerService.getCustomer(id);
	}
	
	/*Adding Customer*/
	@RequestMapping(method= RequestMethod.POST, value="/customer") 
	public void addCustomer(@RequestBody CustomerDetailsRequest customer) {
		System.out.println("Inside addCustomer method::"+ customer);
		customerService.addCustomer(customer);
	}
	
	/*Update Particular Customer*/
	@RequestMapping(method= RequestMethod.PUT, value="/customer/{id}") 
	public void updateCustomer(@RequestBody CustomerDetailsRequest customer,@PathVariable String id) {
		System.out.println("Inside addCustomer method");
		customerService.updateCustomer(id, customer);
	}
	
	/*Delete particular customer*/
	@RequestMapping(method= RequestMethod.DELETE, value="/deletecustomer") 
	public void deleteCustomer(@RequestBody CustomerDetailsRequest customer) {
		System.out.println("Inside deleteCustomer method");
		customerService.deleteCustomer(customer);
	}
}
