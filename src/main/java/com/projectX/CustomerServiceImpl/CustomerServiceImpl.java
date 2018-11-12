package com.projectX.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.projectX.Customer.CustomerDetails;
import com.projectX.Customer.Permissions;
import com.projectX.Customer.Request.CustomerDetailsRequest;
import com.projectX.Customer.Response.CustomerDetailsResponse;
import com.projectX.CustomerRepository.CustomerRepository;
import com.projectX.CustomerRepository.PermissionsRepository;
import com.projectX.CustomerRepository.RolesRepository;
import com.projectX.CustomerService.CustomerService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@EnableMongoRepositories(basePackageClasses =CustomerRepository.class)
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
/*	@Autowired
	private RolesRepository rolesRepository;*/
	
	@Autowired
	private PermissionsRepository permissionsRepository;
	
	CustomerServiceImpl(){
		loadPermissions();
	}

	public CustomerDetailsResponse getAllCustomer() {
		//return customerDetails;
		CustomerDetailsResponse customerDetailsResponse =new CustomerDetailsResponse();
		List<CustomerDetails> customerDetailsList=new ArrayList<CustomerDetails>();
		customerRepository.findAll()
		.forEach(customerDetailsList :: add);
		customerDetailsResponse.setCustomerDetailsList(customerDetailsList);
		return customerDetailsResponse;
		
	}
	
	public CustomerDetailsResponse getCustomer(String id) {
		CustomerDetailsResponse customerDetailsResponse=new CustomerDetailsResponse();
		List<CustomerDetails> customerlist =new ArrayList<>();
		//return customerDetails.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Optional<CustomerDetails> customerDetailsList =  customerRepository.findById(id);
		if(customerDetailsList.isPresent()) {
			customerlist.add(customerDetailsList.get());
		}
		customerDetailsResponse.setCustomerDetailsList(customerlist);
		return customerDetailsResponse;
	}

	public void addCustomer(CustomerDetailsRequest customerDetailsRequest) {
		CustomerDetails customerDetails= new CustomerDetails ();
		customerDetails = customerDetailsRequest.getCustomerDetails();
		Set<Permissions> permissionsSet = new HashSet<Permissions>();
		Permissions permissions = new Permissions();
		permissions.setName(Permissions.permissionList.CREATE.toString());
		permissionsSet.add(permissions);
		Permissions permissions1 = new Permissions();
		permissions1.setName(Permissions.permissionList.UPDATE.toString());
		permissionsSet.add(permissions1);
		customerDetails.setPermissionsList(permissionsSet);
		customerRepository.insert(customerDetailsRequest.getCustomerDetails());
	}

	public void  deleteCustomer(CustomerDetailsRequest customer) {
		customerRepository.delete(customer.getCustomerDetails());
		//customerDetails.removeIf(t -> t.getId().equals(id));		
	}

	public void updateCustomer(String id, CustomerDetailsRequest customer) {
		customerRepository.save(customer.getCustomerDetails());		
	}

	@Override
	public CustomerDetailsResponse loginCustomer(CustomerDetailsRequest customer) {
		CustomerDetailsResponse customerDetailsResponse=new CustomerDetailsResponse();
		CustomerDetails customerDet =customer.getCustomerDetails();
		switch(customerDet.getLoginMedium().toLowerCase()) {
			case "facebook":
				 CustomerDetails customer_Login = fbLogin(customer);
				 if(customer_Login==null)
					 return getCustomer(customerDet.getId());
				 customerDetailsResponse.setCustomerDetailsList(new ArrayList<CustomerDetails>(Arrays.asList(customer_Login)));
				 return customerDetailsResponse;
			default:
				List<CustomerDetails> customerDetailsList =  customerRepository.findByEmail(customerDet.getEmail());		
				if(customerDetailsList.size()> 0 && customerDetailsList.get(0).getPassword().equals(customerDet.getPassword())) {	
					customerDetailsResponse.setCustomerDetailsList(customerDetailsList);
					return customerDetailsResponse;
				}				
		}		
		return null;
	}
	
	public CustomerDetails fbLogin(CustomerDetailsRequest customerDet) {
		Optional<CustomerDetails> customerDetailsList =  customerRepository.findById(customerDet.getCustomerDetails().getId());
		if(customerDetailsList.isPresent()) {
			return customerDetailsList.get();
		}else {
			addCustomer(customerDet);
			return null;
		}
		
	}
	
	@Override
    public CustomerDetails findByUsername(String username) {
		List<CustomerDetails> customerDetailsList = this.customerRepository.findByEmail(username);
		if(customerDetailsList.size() > 0) {
			return customerDetailsList.get(0);
		}
        return null;
    }
	
	public void loadPermissions() {
		/*Permissions permissionObject = new Permissions();
		Stream.of(Permissions.permission.values()).forEach(permission ->{
			permissionObject.setName(permission.toString());
			permissionsRepository.save(permissionObject);	
		});*/
	}
	
	@Override
	public CustomerDetails getCustomerDetails(String username, String password) {
		return findByUsername(username);
	}

	
}
