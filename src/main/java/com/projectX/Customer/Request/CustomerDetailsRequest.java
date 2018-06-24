package com.projectX.Customer.Request;

import com.projectX.Customer.CustomerDetails;

public class CustomerDetailsRequest {
	
	CustomerDetails customerDetails;
	String createdTime;
	String createdBy;
	String updatedTime;
	String updatedBy;
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDetailsRequest [customerDetails=");
		builder.append(customerDetails);
		builder.append(", createdTime=");
		builder.append(createdTime);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedTime=");
		builder.append(updatedTime);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append("]");
		return builder.toString();
	}
	
}
