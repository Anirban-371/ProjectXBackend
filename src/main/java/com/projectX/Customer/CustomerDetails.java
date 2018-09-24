package com.projectX.Customer;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class CustomerDetails {
	
	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private String pincode;
	private String loginMedium;
	private String contact;
	private Set<Permissions> permissionsList;
	private String createdTime;
	private String createdBy;
	private String updatedTime;
	private String updatedBy;
	private String image;
	
	public CustomerDetails() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public String getLoginMedium() {
		return loginMedium;
	}

	public void setLoginMedium(String loginMedium) {
		this.loginMedium = loginMedium;
	}
	public Set<Permissions> getPermissionsList() {
		return permissionsList;
	}

	public void setPermissionsList(Set<Permissions> permissionsList) {
		this.permissionsList = permissionsList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDetails [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", pincode=");
		builder.append(pincode);
		builder.append(", contact=");
		builder.append(contact);
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
