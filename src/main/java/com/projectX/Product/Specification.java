package com.projectX.Product;

import java.util.Arrays;

public class Specification {
	String productWeight;
	String productOldPrice;
	String productPrice;
	String productDesc;
	String manfactureYear;
	Review review[];
	String images[];
	
	public String getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(String productWeight) {
		this.productWeight = productWeight;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getManfactureYear() {
		return manfactureYear;
	}
	public void setManfactureYear(String manfactureYear) {
		this.manfactureYear = manfactureYear;
	}
	public String getProductOldPrice() {
		return productOldPrice;
	}
	public void setProductOldPrice(String productOldPrice) {
		this.productOldPrice = productOldPrice;
	}
	public Review[] getReview() {
		return review;
	}
	public void setReview(Review[] review) {
		this.review = review;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Specification [productWeight=");
		builder.append(productWeight);
		builder.append(", productOldPrice=");
		builder.append(productOldPrice);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append(", productDesc=");
		builder.append(productDesc);
		builder.append(", manfactureYear=");
		builder.append(manfactureYear);
		builder.append(", review=");
		builder.append(Arrays.toString(review));
		builder.append(", images=");
		builder.append(Arrays.toString(images));
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
