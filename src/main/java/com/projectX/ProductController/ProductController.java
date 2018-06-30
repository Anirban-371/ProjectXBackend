package com.projectX.ProductController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectX.Customer.Request.CustomerDetailsRequest;
import com.projectX.Customer.Response.CustomerDetailsResponse;
import com.projectX.Product.Request.ProductRequest;
import com.projectX.Product.Response.ProductResponse;
import com.projectX.ProductService.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product/{id}")
	public ProductResponse getProductDetails(@PathVariable String id) {
		return productService.getProduct(id);
	}
	@RequestMapping("/allproducts")
	public ProductResponse getAllProducts() {
		return productService.getAllProduct();
	}
	
	/*Adding Product*/
	@RequestMapping(method= RequestMethod.POST, value="/addproduct") 
	public void addProduct(@RequestBody ProductRequest product) {
		System.out.println("Inside addProduct method::"+ product);
		productService.addProduct(product);
	}
	
	/*Update Particular Product*/
	@RequestMapping(method= RequestMethod.PUT, value="/updateproduct") 
	public void updateProduct(@RequestBody ProductRequest product) {
		System.out.println("Inside updateProduct method");
		productService.updateProduct(product);
	}
	
	/*Delete particular product*/
	@RequestMapping(method= RequestMethod.DELETE, value="/deleteproduct") 
	public void deleteProduct(@RequestBody ProductRequest product) {
		System.out.println("Inside deleteProduct method");
		productService.deleteProduct(product);
	}

}
