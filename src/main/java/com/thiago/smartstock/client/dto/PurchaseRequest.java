package com.thiago.smartstock.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PurchaseRequest(@JsonProperty("item_id") String itemId,
                              @JsonProperty("item_name") String itemName,
                              @JsonProperty("supplier_name") String supplierName,
                              @JsonProperty("supplier_email") String supplierEmail,
                              @JsonProperty("quantity") Integer quantity) {
}
