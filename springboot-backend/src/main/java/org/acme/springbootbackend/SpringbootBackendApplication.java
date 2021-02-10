package org.acme.springbootbackend;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class SpringbootBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		// return a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.paths(PathSelectors.ant("/items/*"))
			.build()
			.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
			"Inventory Manager API",
			"API for OpenLegacy task",
			"1.0",
			"Free to use",
			new springfox.documentation.service.Contact("Ilya Vogman", "https://www.linkedin.com/in/ilyavog/", "vogman@gmail.com"),
			"API License",
			"https://github.com/ilyav24",
			Collections.emptyList());
		
	}

}
