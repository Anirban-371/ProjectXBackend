package com.projectX.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.stereotype.Service;

import com.projectX.ProductRepository.ProductRepository;
import com.projectX.Product.Product;
import com.projectX.Product.QProduct;
import com.projectX.Product.Request.ProductRequest;
import com.projectX.Product.Response.ProductResponse;
import com.projectX.ProductService.ProductService;
import com.querydsl.core.types.dsl.BooleanExpression;

@EnableMongoRepositories(basePackageClasses = ProductRepository.class)
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductResponse getProduct(String id) {
		ProductResponse productResponse=new ProductResponse();
		List<Product> productlist =new ArrayList<>();
		Optional<Product> productdetailslist =  productRepository.findById(id);
		if(productdetailslist.isPresent()) {
			productlist.add(productdetailslist.get());
		}
		productResponse.setProductList(productlist);
		return productResponse;
	}

	@Override
	public ProductResponse getAllProduct() {
		ProductResponse productResponse =new ProductResponse();
		List<Product> productlist =new ArrayList<>();
		productRepository.findAll()
		.forEach(productlist :: add);
		productResponse.setProductList(productlist);
		return productResponse;
	}

	@Override
	public void addProduct(ProductRequest product) {
		productRepository.insert(product.getProduct());		
	}

	@Override
	public void updateProduct(ProductRequest product) {
		productRepository.save(product.getProduct());	
		
	}

	@Override
	public void deleteProduct(ProductRequest product) {
		productRepository.delete(product.getProduct());
		
	}

	@Override
	public ProductResponse searchProduct(String itemname) {
		ProductResponse productResponse=new ProductResponse();
		QProduct qProduct = new QProduct("Product");
		BooleanExpression filterbyname = qProduct.productDisplayName.contains(itemname);
		List<Product> productList = (List<Product>) this.productRepository.findAll(filterbyname);
		productResponse.setProductList(productList);
		return productResponse;
	}
	

}
