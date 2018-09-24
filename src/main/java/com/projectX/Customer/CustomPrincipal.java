package com.projectX.Customer;

import java.util.Set;

public class CustomPrincipal {
	private CustomerDetails customerDetails;
	private Set<Permissions> roles;
	
	public CustomPrincipal(CustomerDetails customerDetails, Set<Permissions> roles) {
	    this.customerDetails = customerDetails;
	    this.roles = roles;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public Set<Permissions> getRoles() {
		return roles;
	}

	public void setRoles(Set<Permissions> roles) {
		this.roles = roles;
	}
	
	
}
