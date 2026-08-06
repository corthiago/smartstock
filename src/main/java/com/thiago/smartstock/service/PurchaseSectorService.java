package com.thiago.smartstock.service;

import com.thiago.smartstock.client.PurchaseSectorClient;
import com.thiago.smartstock.client.dto.PurchaseRequest;
import com.thiago.smartstock.domain.CsvStockItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PurchaseSectorService {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseSectorService.class);

    private final AuthService authService;
    private final PurchaseSectorClient purchaseSectorClient;

    public PurchaseSectorService(AuthService authService, PurchaseSectorClient purchaseSectorClient) {
        this.authService = authService;
        this.purchaseSectorClient = purchaseSectorClient;
    }

    public boolean sendPurchaseRequest(CsvStockItem item, Integer purchaseQuantity){

        // 1. get token from API
        var token = authService.getToken();

        // 2. send purchase request
        var request = new PurchaseRequest(item.getItemId(),
                item.getItemName(),
                item.getSupplierName(),
                item.getSupplierEmail(),
                purchaseQuantity
        );
        var response = purchaseSectorClient.sendPurchaseRequest(token, request);

        // 3. validate response
        if(response.getStatusCode().value() != HttpStatus.ACCEPTED.value()){
            logger.error("error while sending purchase request, status: {}, response: {}",
                    response.getStatusCode(), response.getBody());
            return false;
        }

        return true;
    }
}
