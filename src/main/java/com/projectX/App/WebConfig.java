package com.projectX.App;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.PropertiesRealm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projectX.CustomerRepository.CustomerRepository;

import java.util.HashMap;
import java.util.Map;

@Configuration	
@ComponentScan({
     	"com.projectX.RegistrationController",
		"com.projectX.LoginController",
		"com.projectX.AdminRepository",
		"com.projectX.CustomerRepository",
		"com.projectX.CustomerService",
		"com.projectX.CustomerServiceImpl",
		"com.projectX.ProductController",
		"com.projectX.ProductRepository",
		"com.projectX.ProductService",
		"com.projectX.ProductServiceImpl",
		"com.projectX.AdminController",
		"com.projectX.AdminService",
		"com.projectX.AdminServiceImpl",
		"com.projectX.AdminRepository"})
public class WebConfig extends AdviceFilter {
	
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("https://localhost:4200","http://localhost:4200").allowCredentials(true);
            }
        };
    }
	
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter() {
		System.out.print("ShiroFilterFactoryBean geared and started");	
		
		FormAuthenticationFilter formAuthFilter = new FormAuthenticationFilter();
		formAuthFilter.setLoginUrl("/login");
	    formAuthFilter.setPasswordParam("password");
	    formAuthFilter.setUsernameParam("username");
	    formAuthFilter.setSuccessUrl("/");
	    
		AnonymousFilter anon = new AnonymousFilter();
		CorsFilter corsFilter = new CorsFilter();
		RolesAuthorizationFilter rolesAuthorizationFilter = new RolesAuthorizationFilter();
		
		Map<String, Filter> filters =new HashMap<String, Filter>();
	    filters.put("corsFilter", corsFilter);
		filters.put("authc", formAuthFilter);
	    filters.put("anon", anon);
	    filters.put("roles", rolesAuthorizationFilter);
		
		Map<String, String> filterChainDefinitionMapping = new HashMap<String, String>();
		filterChainDefinitionMapping.put("/login", "authc");
		filterChainDefinitionMapping.put("/login", "corsFilter");
		filterChainDefinitionMapping.put("/**", "corsFilter");
		filterChainDefinitionMapping.put("/**", "anon");
		filterChainDefinitionMapping.put("/**", "authcBasic[permissive]");
		filterChainDefinitionMapping.put("/**", "roles");
		//
		
		
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
	    shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);
	    shiroFilter.setSecurityManager(securityManager());
        shiroFilter.setFilters(filters);
        
	    return shiroFilter;
	}
	@Bean(name = "securityManager")
	public org.apache.shiro.mgt.SecurityManager securityManager() {
		System.out.print("Security manager geared and started");
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(mongorealm());
		//SecurityUtils.setSecurityManager(securityManager);
		return securityManager;
	}
	@Bean(name = "mongorealm")
	@DependsOn({ "lifecycleBeanPostProcessor" })
    public Realm mongorealm(){
        return new MongoRealm();
    }
	
	@Bean(name = "corsFilter")
	@DependsOn({ "lifecycleBeanPostProcessor" })
    public CorsFilter corsFilter(){
        return new CorsFilter();
    }
	
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	    return new LifecycleBeanPostProcessor();
	}
	 /**
     * Turn on Shiro's annotations (such as @RequiresRoles, @RequiresPermissions), use SpringAOP to scan classes that use Shiro annotations, and perform security logic verification if necessary
     * Configure the following two beans (DefaultAdvisorAutoProxyCreator (optional) and AuthorizationAttributeSourceAdvisor) to achieve this function
     */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator () {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator =  new  DefaultAdvisorAutoProxyCreator ();
        advisorAutoProxyCreator . setProxyTargetClass( true );
        return advisorAutoProxyCreator;
	}
	@Bean
	@ConditionalOnMissingBean
	public AuthorizationAttributeSourceAdvisor  authorizationAttributeSourceAdvisor (DefaultSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =  new  AuthorizationAttributeSourceAdvisor ();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
	}
	
	
}
