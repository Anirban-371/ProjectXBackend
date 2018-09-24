package com.projectX.CustomerRepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projectX.Customer.Permissions;

public interface PermissionsRepository extends MongoRepository<Permissions, String> {
	
	List<Permissions> findByName(String name);
}
