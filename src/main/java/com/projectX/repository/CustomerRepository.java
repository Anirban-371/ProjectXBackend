package com.projectX.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.projectX.CustomerDetails.CustomerDetailsRequest;

public interface CustomerRepository extends MongoRepository<CustomerDetailsRequest, String> {

}
