package com.projectX.ProductService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectX.Admin.AdminAssets;
import com.projectX.Product.Product;
import com.projectX.Product.Request.ProductRequest;
import com.projectX.Product.Response.ProductResponse;
@Service
public interface ProductService {

	ProductResponse getProduct(String id);

	ProductResponse getAllProduct();

	boolean addProduct(ProductRequest product);

	void updateProduct(ProductRequest product);

	ProductResponse deleteProduct(String[] productIdList);

	ProductResponse searchProduct(String itemname);

	List<String> getOwnerIDs();
	
	List<Product> getOwnerProducts(String ownerID);

	boolean addAdminAssets(AdminAssets adminAssets);

	

}
