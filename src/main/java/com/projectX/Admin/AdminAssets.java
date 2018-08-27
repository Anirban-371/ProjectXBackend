package com.projectX.Admin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AdminAssets")
public class AdminAssets {
	
	@Id
	String id;
	String name;
	String imageURL;
	String sellerID;
	String productID;
	String productOldPrice;
	String productNewPrice;
	String productName;
	String html;
	String target;
	String startDate;
	String endDate;
	String category;
	String zoneId;
	int active;
	String createdBy;
	String createdTime;
	
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
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getSellerID() {
		return sellerID;
	}
	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getProductOldPrice() {
		return productOldPrice;
	}
	public void setProductOldPrice(String productOldPrice) {
		this.productOldPrice = productOldPrice;
	}
	public String getProductNewPrice() {
		return productNewPrice;
	}
	public void setProductNewPrice(String productNewPrice) {
		this.productNewPrice = productNewPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminAssets [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", imageURL=");
		builder.append(imageURL);
		builder.append(", sellerID=");
		builder.append(sellerID);
		builder.append(", productID=");
		builder.append(productID);
		builder.append(", productOldPrice=");
		builder.append(productOldPrice);
		builder.append(", productNewPrice=");
		builder.append(productNewPrice);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", html=");
		builder.append(html);
		builder.append(", target=");
		builder.append(target);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", category=");
		builder.append(category);
		builder.append(", zoneId=");
		builder.append(zoneId);
		builder.append(", active=");
		builder.append(active);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdTime=");
		builder.append(createdTime);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
