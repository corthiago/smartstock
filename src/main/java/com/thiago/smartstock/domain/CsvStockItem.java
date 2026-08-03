package com.thiago.smartstock.domain;

import com.opencsv.bean.CsvBindByName;

public class CsvStockItem {

    @CsvBindByName(column = "item_id")
    private String itemId;

    @CsvBindByName(column = "item_name")
    private String itemName;

    @CsvBindByName(column = "quantity")
    private Integer quantity;

    @CsvBindByName(column = "reorder_threshold")
    private Integer reorderThreshold;

    @CsvBindByName(column = "supplier_name")
    private String supplierName;

    @CsvBindByName(column = "supplier_email")
    private String supplierEmail;

    @CsvBindByName(column = "last_stock_update_time")
    private String lastStockUpdateItem;

    public CsvStockItem() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(Integer reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getLastStockUpdateItem() {
        return lastStockUpdateItem;
    }

    public void setLastStockUpdateItem(String lastStockUpdateItem) {
        this.lastStockUpdateItem = lastStockUpdateItem;
    }
}
