package com.projectX.Product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {
	
	@Id
	String productId;
	String productDisplayName;
	String productOwnerId;
	String productListId;
	String quantity;
	String productWeight;
	String productSize;
	String productArea;
	String productExpiryDate;
	String productCategory;
	String productType;
	String productDesc;
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
	public String getProductDisplayName() {
		return productDisplayName;
	}
	public void setProductDisplayName(String productDisplayName) {
		this.productDisplayName = productDisplayName;
	}
	public String getProductOwnerId() {
		return productOwnerId;
	}
	public void setProductOwnerId(String productOwnerId) {
		this.productOwnerId = productOwnerId;
	}
	public String getProductListId() {
		return productListId;
	}
	public void setProductListId(String productListId) {
		this.productListId = productListId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(String productWeight) {
		this.productWeight = productWeight;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductArea() {
		return productArea;
	}
	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}
	public String getProductExpiryDate() {
		return productExpiryDate;
	}
	public void setProductExpiryDate(String productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", productDisplayName=");
		builder.append(productDisplayName);
		builder.append(", productOwnerId=");
		builder.append(productOwnerId);
		builder.append(", productListId=");
		builder.append(productListId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", productWeight=");
		builder.append(productWeight);
		builder.append(", productSize=");
		builder.append(productSize);
		builder.append(", productArea=");
		builder.append(productArea);
		builder.append(", productExpiryDate=");
		builder.append(productExpiryDate);
		builder.append(", productCategory=");
		builder.append(productCategory);
		builder.append(", productType=");
		builder.append(productType);
		builder.append(", productDesc=");
		builder.append(productDesc);
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
