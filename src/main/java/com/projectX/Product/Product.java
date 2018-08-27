package com.projectX.Product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {
	
	@Id
	String productId;
	String productCompany;
	String productName;
	String productOwnerId;
	String productGroupId;
	String productStatus;
	String productCondition;
	String purchaseYear;
	String category;
	int popularity;
	int productQuantity;
	double offpercent;
	Specification specs;
	String createdBy;
	String createdDate;
	String modifiedBy;
	String modifiedDate;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductCompany() {
		return productCompany;
	}
	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductOwnerId() {
		return productOwnerId;
	}
	public void setProductOwnerId(String productOwnerId) {
		this.productOwnerId = productOwnerId;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public String getPurchaseYear() {
		return purchaseYear;
	}
	public void setPurchaseYear(String purchaseYear) {
		this.purchaseYear = purchaseYear;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getProductGroupId() {
		return productGroupId;
	}
	public void setProductGroupId(String productGroupId) {
		this.productGroupId = productGroupId;
	}
	public Specification getSpecs() {
		return specs;
	}
	public void setSpecs(Specification specs) {
		this.specs = specs;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public double getOffpercent() {
		return offpercent;
	}
	public void setOffpercent(double offpercent) {
		this.offpercent = offpercent;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", productCompany=");
		builder.append(productCompany);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productOwnerId=");
		builder.append(productOwnerId);
		builder.append(", productGroupId=");
		builder.append(productGroupId);
		builder.append(", productStatus=");
		builder.append(productStatus);
		builder.append(", productCondition=");
		builder.append(productCondition);
		builder.append(", purchaseYear=");
		builder.append(purchaseYear);
		builder.append(", category=");
		builder.append(category);
		builder.append(", popularity=");
		builder.append(popularity);
		builder.append(", productQuantity=");
		builder.append(productQuantity);
		builder.append(", offpercent=");
		builder.append(offpercent);
		builder.append(", specs=");
		builder.append(specs);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", modifiedBy=");
		builder.append(modifiedBy);
		builder.append(", modifiedDate=");
		builder.append(modifiedDate);
		builder.append("]");
		return builder.toString();
	}	
	
}
