package com.projectX.CustomerRepository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectX.Customer.CustomerDetails;

public interface CustomerRepository extends MongoRepository<CustomerDetails, String> {
	
	List<CustomerDetails> findByEmail(String email);
}
