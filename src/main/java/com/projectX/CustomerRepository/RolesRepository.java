package com.projectX.CustomerRepository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.projectX.Customer.Roles;

public interface RolesRepository extends MongoRepository<Roles, String> {
	
	List<Roles> findByName(String name);

}
