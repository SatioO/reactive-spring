package com.we3.cricpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class CricpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricpayApplication.class, args);
	}

}
