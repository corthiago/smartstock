package com.thiago.smartstock.service;

import com.thiago.smartstock.domain.CsvStockItem;
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

            items.forEach(item -> {

                if(item.getQuantity() < item.getReorderThreshold()){
                    // 2. call purchasing department api for each stock item
                    var reorderQuantity = calculateReorderQuantity(item);

                    // 3. persist items at mongodb


                }
            });




        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private Integer calculateReorderQuantity(CsvStockItem item) {

        return  item.getReorderThreshold() + ((int) Math.ceil(item.getReorderThreshold() * 0.2));

    }

}
