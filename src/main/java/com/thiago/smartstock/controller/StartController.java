package com.thiago.smartstock.controller;

import com.thiago.smartstock.controller.dto.StartDto;
import com.thiago.smartstock.service.SmartStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class StartController {

    private final SmartStockService smartStockService;

    public StartController(SmartStockService smartStockService) {
        this.smartStockService = smartStockService;
    }

    @PostMapping(path = "/start")
    public ResponseEntity<Void> start(@RequestBody StartDto dto){

        CompletableFuture.runAsync(() -> {
            smartStockService.start(dto.reportPath());
        });

        return ResponseEntity.accepted().build();
    }
}
