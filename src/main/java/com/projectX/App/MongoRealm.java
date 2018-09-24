package com.projectX.App;

import java.awt.print.Printable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.projectX.Customer.CustomPrincipal;
import com.projectX.Customer.CustomerDetails;
import com.projectX.Customer.Permissions;
import com.projectX.CustomerService.CustomerService;


public class MongoRealm extends AuthorizingRealm{
	
	@Autowired
	protected CustomerService customerService =null;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public MongoRealm() {
		//this.setCustomerRepository(customerRepo);
		/*HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName(Sha512Hash.ALGORITHM_NAME);
        credentialsMatcher.setHashIterations(53);
        setCredentialsMatcher(credentialsMatcher);*/
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("Inside doGetAuthorizationInfo:: ");
		Set<String>	roles  = new HashSet<String>();
		Set<Permission>	permissions = new HashSet<Permission>();
		if (principals == null) {
			throw new AuthorizationException("Principal is not null!");
		}
		try {
			/*String  customer = (String) principals.getPrimaryPrincipal();
			System.out.println(customer);
			CustomerDetails customer = customerService.findByUsername(username);
			if(null!=customer) {
				
				SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
				Set<Principal> permissionList =  customer.getPermissionsList();
				permissionList.stream().forEach(permission ->{
					simpleAuthorizationInfo.addStringPermission(permission);
				});
				return simpleAuthorizationInfo;
			}*/
			//return null;
			Set<Permissions> userRoles	= ((CustomPrincipal) principals.getPrimaryPrincipal()).getRoles();
			for (Permissions permission : userRoles) {
				roles.add(permission.getName());
				if (!permissions.contains(permission)) {
					permissions.add(permission);
				}
			}
			SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
			simpleAuthorizationInfo.setRoles(roles);
			simpleAuthorizationInfo.setObjectPermissions(permissions);
			return simpleAuthorizationInfo;
		}catch(Exception e) {
			e.printStackTrace();
			throw new AuthorizationException("Error in Authourization!");
		}
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("Inside doGetAuthenticationInfo:: ");
		try {
	        CustomerDetails customer = customerService.findByUsername(token.getPrincipal().toString());
	        if(null!=customer)
	            return new SimpleAuthenticationInfo(new CustomPrincipal(customer, customer.getPermissionsList()), customer.getPassword(), getClass().getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
        throw new AuthenticationException("Invalid User/Password!");
    }

}
