package com.eleana.coffeeshop.product;

import java.math.BigDecimal;
import java.util.List;

public class Product {

    private String productName;
    private Long productId;
    private Size size;
    private BigDecimal basePrice;
    private int stockLevel;
    private List<Size> availableSizes;

    public List<Size> getAvailableSizes() {
        return availableSizes;
    }

    public void setAvailableSizes(List<Size> availableSizes) {
        this.availableSizes = availableSizes;
    }

    public BigDecimal getAdditionalCost() {
        return size.getAdditionalCost();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

}
