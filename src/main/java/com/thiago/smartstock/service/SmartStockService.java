package com.thiago.smartstock.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SmartStockService {

    private final ReportService reportService;

    public SmartStockService(ReportService reportService) {
        this.reportService = reportService;
    }

    public void start(String reportPath){

        // 1. read csv file
        try {
            var items = reportService.readStockReport(reportPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 2. call purchasing department api for each stock item


        // 3.

    }

}
