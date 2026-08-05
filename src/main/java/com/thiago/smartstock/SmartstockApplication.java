package com.thiago.smartstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SmartstockApplication{

	public static void main(String[] args) {
		SpringApplication.run(SmartstockApplication.class, args);
	}

}
