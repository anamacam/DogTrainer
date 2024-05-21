package com.microservice.dog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceDogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDogApplication.class, args);
	}

}
