package com.sisvi.svcvehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SvcVehiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcVehiculosApplication.class, args);
	}

}
