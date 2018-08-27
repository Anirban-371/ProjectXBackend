package com.projectX.ProductController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectX.Product.Product;
import com.projectX.Product.Request.ProductRequest;
import com.projectX.Product.Response.ProductResponse;
import com.projectX.ProductService.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method= RequestMethod.GET, value="/product")
	public ProductResponse getProductDetails(@RequestParam("id") String id) {
		return productService.getProduct(id);
	}
	@RequestMapping("/allproducts")
	public ProductResponse getAllProducts() {
		return productService.getAllProduct();
	}
	
	/*Adding Product*/
	@RequestMapping(method= RequestMethod.POST, value="/addproduct") 
	public boolean addProduct(@RequestBody ProductRequest product) {
		System.out.println("Inside addProduct method::"+ product);
		return productService.addProduct(product);
	}
	
	/*Update Particular Product*/
	@RequestMapping(method= RequestMethod.PUT, value="/updateproduct") 
	public void updateProduct(@RequestBody ProductRequest product) {
		System.out.println("Inside updateProduct method");
		productService.updateProduct(product);
	}
	
	/*Delete particular product*/
	@RequestMapping(method= RequestMethod.DELETE, value="/deleteproduct") 
	public ProductResponse deleteProduct(@RequestBody String[] idList) {
		System.out.println("Inside deleteProduct method"+ idList);
		return productService.deleteProduct(idList);
	}
	
	/*Search particular product*/
	// Need to change the search from product name to product tags
	@RequestMapping(method= RequestMethod.POST, value="/productname") 
	public ProductResponse searchProduct(@RequestParam("itemname") String itemname) {
		System.out.println("Inside searchProduct method"+ itemname);
		return productService.searchProduct(itemname);
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/getallowners") 
	public List<String> getAllProductOwners() {
		System.out.println("Inside getAllProductOwners method");
		return productService.getOwnerIDs();
	}
	
	@CrossOrigin
	@RequestMapping(method= RequestMethod.GET, value="/getownerproducts") 
	public List<Product> getOwnerProducts(@RequestParam("ownerID") String ownerID) {
		System.out.println("Inside getOwnerProducts method"+ ownerID);
		if(null==ownerID || ownerID.equals("")) {
			return null;
		}
		return productService.getOwnerProducts(ownerID);
	}
}
