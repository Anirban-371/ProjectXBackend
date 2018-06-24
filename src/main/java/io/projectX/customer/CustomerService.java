package io.projectX.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.projectX.repository.CustomerRepository;

import io.projectX.CustomerDetails.CustomerDetailsRequest;

@EnableMongoRepositories(basePackageClasses =CustomerRepository.class)
@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	private List<CustomerDetailsRequest> customerDetails=new ArrayList<CustomerDetailsRequest>(
		Arrays.asList(
		new CustomerDetailsRequest("Anirban", "class 1","greatGUY"),
		new CustomerDetailsRequest("Subhodeep", "class 10","awesomeGUY"),
		new CustomerDetailsRequest("Virat", "class 11","nice GUY")				
	));

	public List<CustomerDetailsRequest> getCustomerDetails() {
		//return customerDetails;
		List<CustomerDetailsRequest> customerDetailsRequestList=new ArrayList<CustomerDetailsRequest>();
		customerRepository.findAll()
		.forEach(customerDetailsRequestList :: add);
		return customerDetailsRequestList;
		
	}

	public void setCustomerDetails(List<CustomerDetailsRequest> customerDetails) {
		this.customerDetails = customerDetails;
	}
	
	public CustomerDetailsRequest getCustomer(String id) {
		return customerDetails.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addCustomer(CustomerDetailsRequest customerDetailsRequest) {
		//customerDetails.add(customerDetailsRequest);
		customerRepository.save(customerDetailsRequest);
	}

	public void  deleteCustomer(String id) {
		customerDetails.removeIf(t -> t.getId().equals(id));
		
	}

	public void updateCustomer(String id, CustomerDetailsRequest customer) {
		for(int i=0;i<customerDetails.size();i++) {
			CustomerDetailsRequest customerDetailsRequest= customerDetails.get(i);
			if(customerDetailsRequest.getId().equals(id)) {
				customerDetails.set(i,customer);
				return;
			}
			
		}
		
	}
	
}
