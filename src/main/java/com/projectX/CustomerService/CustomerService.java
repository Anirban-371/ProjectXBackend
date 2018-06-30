package com.projectX.CustomerService;


import org.springframework.stereotype.Service;

import com.projectX.Customer.Request.CustomerDetailsRequest;
import com.projectX.Customer.Response.CustomerDetailsResponse;

@Service
public interface CustomerService {

	CustomerDetailsResponse getCustomerDetails();

	CustomerDetailsResponse getCustomer(String id);

	void addCustomer(CustomerDetailsRequest customer);

	void updateCustomer(String id, CustomerDetailsRequest customer);

	void deleteCustomer(CustomerDetailsRequest customer);

	boolean loginCustomer(CustomerDetailsRequest customer);

}
