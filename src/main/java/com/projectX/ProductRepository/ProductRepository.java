package com.projectX.ProductRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectX.Product.Product;


public interface ProductRepository extends MongoRepository<Product, String> {

}
