package com.projectX.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.projectX.Customer.CustomerDetails;
import com.projectX.Customer.Request.CustomerDetailsRequest;
import com.projectX.Customer.Response.CustomerDetailsResponse;
import com.projectX.CustomerRepository.CustomerRepository;
import com.projectX.CustomerService.CustomerService;

@EnableMongoRepositories(basePackageClasses =CustomerRepository.class)
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
//	private List<CustomerDetailsRequest> customerDetails=new ArrayList<CustomerDetailsRequest>(
//		Arrays.asList(
//		new CustomerDetailsRequest("Anirban", "class 1","greatGUY"),
//		new CustomerDetailsRequest("Subhodeep", "class 10","awesomeGUY"),
//		new CustomerDetailsRequest("Virat", "class 11","nice GUY")				
//	));

	public CustomerDetailsResponse getCustomerDetails() {
		//return customerDetails;
		CustomerDetailsResponse customerDetailsResponse =new CustomerDetailsResponse();
		List<CustomerDetails> customerList=new ArrayList<CustomerDetails>();
		customerRepository.findAll()
		.forEach(customerList :: add);
		customerDetailsResponse.setCustomerDetailsList(customerList);
		return customerDetailsResponse;
		
	}
	
	public CustomerDetailsResponse getCustomer(String id) {
		//CustomerDetails customerDetails=new CustomerDetails();
		//return customerDetails.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return null;
	}

	public void addCustomer(CustomerDetailsRequest customerDetailsRequest) {
		//customerDetails.add(customerDetailsRequest);
		customerRepository.save(customerDetailsRequest.getCustomerDetails());
	}

	public void  deleteCustomer(String id) {
		//customerDetails.removeIf(t -> t.getId().equals(id));
		
	}

	public void updateCustomer(String id, CustomerDetailsRequest customer) {
		/*for(int i=0;i<customerDetails.size();i++) {
			CustomerDetailsRequest customerDetailsRequest= customerDetails.get(i);
			if(customerDetailsRequest.getId().equals(id)) {
				customerDetails.set(i,customer);
				return;
			}
			
		}*/
		
	}

	
}
