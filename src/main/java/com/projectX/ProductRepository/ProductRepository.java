package com.projectX.ProductRepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.projectX.Product.Product;


public interface ProductRepository extends MongoRepository<Product, String>,QuerydslPredicateExecutor<Product> {
	

	List<Product> findByProductName(String searchName);
	
	@Query(value = "{productOwnerId : ?0 }") //,fields = "{productOwnerId : 1, productName : 1 }"
    public List<Product> findAllProductOfOwners(String ownerId); 
}
