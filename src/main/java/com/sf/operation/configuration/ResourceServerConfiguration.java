package com.sf.operation.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);	
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/api/message").access("#oauth2.hasScope('write')")
		//define check user scope that can access
		.antMatchers("/api/message")
					.access("#oauth2.hasScope('read')")
			.anyRequest().authenticated();
	}
}
