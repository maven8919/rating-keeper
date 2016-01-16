package com.maven8919.ratingkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso
public class RatingKeeperApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RatingKeeperApplication.class, args);
	}
}
