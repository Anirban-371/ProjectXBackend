package com.projectX.Product.Request;

import com.projectX.Product.Product;

public class ProductRequest {
	Product product;
	String productSearch;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getProductSearch() {
		return productSearch;
	}
	public void setProductSearch(String productSearch) {
		this.productSearch = productSearch;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductRequest [product=");
		builder.append(product);
		builder.append(", productSearch=");
		builder.append(productSearch);
		builder.append("]");
		return builder.toString();
	}	

}
