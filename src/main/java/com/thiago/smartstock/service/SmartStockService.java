package com.thiago.smartstock.service;

import com.thiago.smartstock.domain.CsvStockItem;
import com.thiago.smartstock.entity.PurchaseRequestEntity;
import com.thiago.smartstock.repository.PurchaseRequestRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class SmartStockService {

    private final ReportService reportService;
    private final PurchaseSectorService purchaseSectorService;
    private final PurchaseRequestRepository purchaseRequestRepository;

    public SmartStockService(ReportService reportService,
                             PurchaseSectorService purchaseSectorService,
                             PurchaseRequestRepository purchaseRequestRepository) {
        this.reportService = reportService;
        this.purchaseSectorService = purchaseSectorService;
        this.purchaseRequestRepository = purchaseRequestRepository;
    }

    public void start(String reportPath){

        try {

            var items = reportService.readStockReport(reportPath);

            items.forEach(item -> {

                if(item.getQuantity() < item.getReorderThreshold()){
                    // 1. read csv file
                    var reorderQuantity = calculateReorderQuantity(item);

                    // 2. call purchasing department api for each stock item
                    var purchaseSentWithSuccess = purchaseSectorService.sendPurchaseRequest(item, reorderQuantity);

                    // 3. persist items at mongodb
                    persist(item, reorderQuantity, purchaseSentWithSuccess);

                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Integer calculateReorderQuantity(CsvStockItem item) {

        return  item.getReorderThreshold() + ((int) Math.ceil(item.getReorderThreshold() * 0.2));

    }

    private void persist(CsvStockItem item, Integer reorderQuantity, boolean purchaseSentWithSuccess) {

        var entity = new PurchaseRequestEntity();
        entity.setItemId(item.getItemId());
        entity.setItemName(item.getItemName());
        entity.setQuantityOnStock(item.getQuantity());
        entity.setReorderThreshold(item.getReorderThreshold());
        entity.setSupplierName(item.getSupplierName());
        entity.setSupplierEmail(item.getSupplierEmail());
        entity.setSupplierEmail(item.getSupplierEmail());
        entity.setLastStockUpdateTime(LocalDateTime.parse(item.getLastStockUpdateItem()));
        entity.setPurchaseDateTime(LocalDateTime.now());
        entity.setPurchaseQuantity(reorderQuantity);
        entity.setPurchasedWithSuccess(purchaseSentWithSuccess);

        purchaseRequestRepository.save(entity);

    }
}
