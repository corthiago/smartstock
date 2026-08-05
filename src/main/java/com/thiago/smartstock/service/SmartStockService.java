package com.thiago.smartstock.service;

import com.thiago.smartstock.domain.CsvStockItem;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SmartStockService {

    private final ReportService reportService;
    private final PurchaseSectorService purchaseSectorService;

    public SmartStockService(ReportService reportService, PurchaseSectorService purchaseSectorService) {
        this.reportService = reportService;
        this.purchaseSectorService = purchaseSectorService;
    }

    public void start(String reportPath){

        try {

            var items = reportService.readStockReport(reportPath);

            items.forEach(item -> {

                if(item.getQuantity() < item.getReorderThreshold()){
                    // 1. read csv file
                    var reorderQuantity = calculateReorderQuantity(item);

                    // 2. call purchasing department api for each stock item
                    purchaseSectorService.sendPurchaseRequest(item, reorderQuantity);

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
