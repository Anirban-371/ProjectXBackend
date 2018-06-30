package com.projectX.Customer.Response;

import java.util.List;

import com.projectX.Customer.CustomerDetails;

public class CustomerDetailsResponse {
	
	List<CustomerDetails> customerDetailsList;
	
	public List<CustomerDetails> getCustomerDetailsList() {
		return customerDetailsList;
	}

	public void setCustomerDetailsList(List<CustomerDetails> customerDetailsList) {
		this.customerDetailsList = customerDetailsList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDetailsResponse [customerDetailsList=");
		builder.append(customerDetailsList);
		builder.append("]");
		return builder.toString();
	}


	
	
}
