package com.thiago.smartstock.service;

import com.thiago.smartstock.domain.CsvStockItem;
import org.springframework.stereotype.Service;

@Service
public class PurchaseSectorService {

    private final AuthService authService;

    public PurchaseSectorService(AuthService authService) {
        this.authService = authService;
    }

    public boolean sendPurchaseRequest(CsvStockItem item, Integer purchaseQuantity){

        // 1. get token from API
        var token = authService.getToken();

        // 2. send purchase request


        // 3. validate response

        return false;
    }
}
