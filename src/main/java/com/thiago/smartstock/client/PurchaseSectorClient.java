package com.thiago.smartstock.client;

import com.thiago.smartstock.client.dto.PurchaseRequest;
import com.thiago.smartstock.client.dto.PurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "PurchaseSectorClient", url = "${api.purchase-sector-url}")
public interface PurchaseSectorClient {

    @PostMapping(path = "/api/purchases")
    ResponseEntity<PurchaseResponse> sendPurchaseRequest(@RequestHeader("Authorization") String token,
                                                         @RequestBody PurchaseRequest purchaseRequest);

}
