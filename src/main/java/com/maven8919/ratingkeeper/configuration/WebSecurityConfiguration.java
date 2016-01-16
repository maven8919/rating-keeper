package com.maven8919.ratingkeeper.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/**")
				.authorizeRequests().
					antMatchers("/", "/login**", "/webjars/**")
					.permitAll()
				.anyRequest()
					.authenticated();
	}
}
