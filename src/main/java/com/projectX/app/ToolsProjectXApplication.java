package com.projectX.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"io.projectX.starterAPIController",
		"io.projectX.customer",
		"com.projectX.repository.CustomerRepository"
})
public class ToolsProjectXApplication {

	public static void main(String[] args) {
		//sets up the default configuration: address convention over configuration
		//starts spring application context : creates the application context
		//performs class path scan: marking you class as service ,controller depending on annotation by scanning
		//Starts Tomcat server
		SpringApplication.run(ToolsProjectXApplication.class, args);
	}
}
