package io.projectX.starterAPIController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.projectX.CustomerDetails.CustomerDetailsRequest;
import io.projectX.customer.CustomerService;

@RestController
public class RegisterController {
	
	@Autowired
	private CustomerService customerService; //Injecting CustomerService service into the variable customerService
	
	@RequestMapping("/topics")
	public List<CustomerDetailsRequest> getAllTopics() {
		//@RestController will automatically convert to JSON
		return customerService.getCustomerDetails();
	}
	
	@RequestMapping("/customer/{id}")
	public CustomerDetailsRequest getCustomer(@PathVariable String id) {
		return customerService.getCustomer(id);
	}
	
	@RequestMapping(method= RequestMethod.POST, value="/customer") 
	public void addCustomer(CustomerDetailsRequest customer) {
		System.out.println("Inside addCustomer method");
		customerService.addCustomer(customer);
	}
	
	@RequestMapping(method= RequestMethod.PUT, value="/customer/{id}") 
	public void updateCustomer(@RequestBody CustomerDetailsRequest customer,@PathVariable String id) {
		System.out.println("Inside addCustomer method");
		customerService.updateCustomer(id, customer);
	}
	@RequestMapping(method= RequestMethod.DELETE, value="/customer/{id}") 
	public void deleteCustomer(@PathVariable String id) {
		System.out.println("Inside deleteCustomer method");
		customerService.deleteCustomer(id);
	}
}
