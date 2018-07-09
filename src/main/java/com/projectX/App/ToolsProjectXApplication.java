package com.projectX.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.projectX.RegistrationController",
		"com.projectX.LoginController",
		"com.projectX.CustomerRepository",
		"com.projectX.CustomerService",
		"com.projectX.CustomerServiceImpl",
		"com.projectX.ProductController",
		"com.projectX.ProductRepository",
		"com.projectX.ProductService",
		"com.projectX.ProductServiceImpl"
})
public class ToolsProjectXApplication {

	public static void main(String[] args) {
		//sets up the default configuration: address convention over configuration
		//starts spring application context : creates the application context
		//performs class path scan: marking you class as service ,controller depending on annotation by scanning
		//Starts Tomcat server
		SpringApplication.run(ToolsProjectXApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("https://localhost:4200").allowCredentials(true);
            }
        };
    }
}
