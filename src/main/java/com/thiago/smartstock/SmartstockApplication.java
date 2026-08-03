package com.thiago.smartstock;

import com.thiago.smartstock.client.GoogleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SmartstockApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SmartstockApplication.class, args);
	}

    @Autowired
    private GoogleClient googleClient;

    @Override
    public void run(String... args) throws Exception {
        googleClient.helloGoogle();
    }
}
