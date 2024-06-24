package com.sisvi.svc_mantenimiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SvcMantenimientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcMantenimientoApplication.class, args);
	}

}
