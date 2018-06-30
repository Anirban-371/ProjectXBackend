package com.projectX.ProductService;

import org.springframework.stereotype.Service;

import com.projectX.Product.Request.ProductRequest;
import com.projectX.Product.Response.ProductResponse;
@Service
public interface ProductService {

	ProductResponse getProduct(String id);

	ProductResponse getAllProduct();

	void addProduct(ProductRequest product);

	void updateProduct(ProductRequest product);

	void deleteProduct(ProductRequest product);


}
