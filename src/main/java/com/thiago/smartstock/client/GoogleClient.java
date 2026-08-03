package com.thiago.smartstock.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GoogleClient", url = "https://google.com")
public interface GoogleClient {

    @GetMapping
    ResponseEntity<String> helloGoogle();
}
