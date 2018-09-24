package com.projectX.App;

/*import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.PropertiesRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
/*@ComponentScan({
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
		"com.projectX.AdminRepository"})*/
public class ToolsProjectXApplication {

	public static void main(String[] args) {
		//sets up the default configuration: address convention over configuration
		//starts spring application context : creates the application context
		//performs class path scan: marking you class as service ,controller depending on annotation by scanning
		//Starts Tomcat server
		SpringApplication.run(ToolsProjectXApplication.class, args);
	}
	
}
