package com.feign.feign.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@Profile({"!prod && swagger"})
public class swaggerConfig {
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	      .apiInfo(apiInfo())
	      .securitySchemes(Collections.singletonList(apiKey()))
          .securityContexts(Collections.singletonList(securityContext()))
	      .select()
	      .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
	      .paths(PathSelectors.any())
	      .build();
	}

	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(Collections.singletonList(
				SecurityReference.builder().reference("Authorization").scopes(new AuthorizationScope[0]).build()))
				.build();
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Ebin B REST API",
	      "Some custom description of API.",
	      "1.0",
	      "Terms of service",
	      new Contact("Ebin B", "", "ebinb11@gmail.com"),
	      "License of API",
	      "API license URL",
	      Collections.emptyList());
	}
}
