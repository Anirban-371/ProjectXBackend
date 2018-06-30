package com.projectX.Product.Response;

import java.util.ArrayList;
import java.util.List;

import com.projectX.Product.Product;

public class ProductResponse {
	
	List<Product> productList = new ArrayList<Product>();

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductResponse [productList=");
		builder.append(productList);
		builder.append("]");
		return builder.toString();
	}

}
