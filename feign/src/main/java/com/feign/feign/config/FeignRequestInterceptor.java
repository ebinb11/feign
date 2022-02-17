package com.feign.feign.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignRequestInterceptor implements RequestInterceptor {

	 private static final String AUTHORIZATION_HEADER = "Authorization";
     private static final String BEARER_TOKEN_TYPE = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlYmluYjExQGdtYWlsLmNvbSIsImV4cCI6MTY0NTExODM5MywiaWF0IjoxNjQ1MDk2NzkzfQ.ylTNU5WTOI57jIhb8Y-Tt40pmqOlMrClZHvMrWD9Ass";
     
	@Override
	public void apply(RequestTemplate template) {
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication != null) {
            template.header(AUTHORIZATION_HEADER, String.format(BEARER_TOKEN_TYPE));
        }
	}

}
