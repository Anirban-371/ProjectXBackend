package com.projectX.Customer.Request;

import com.projectX.Customer.CustomerDetails;

public class CustomerDetailsRequest {
	
	CustomerDetails customerDetails;
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDetailsRequest [customerDetails=");
		builder.append(customerDetails);
		builder.append("]");
		return builder.toString();
	}
	
}
