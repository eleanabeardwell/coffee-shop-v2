package com.eleana.coffeeshop.dto;

import com.eleana.coffeeshop.product.Size;

import java.math.BigDecimal;
import java.util.List;

public class ProductDto {

    @NotNull
    private String productName;
    @NotNull
    private Integer productId;
    @NotNull
    private Size size;
    @NotNull
    private BigDecimal basePrice;
    @NotNull
    private int stockLevel;
    @NotNull
    private List<Size> availableSizes;

    public List<Size> getAvailableSizes() {
        return availableSizes;
    }

    public void setAvailableSizes(List<Size> availableSizes) {
        this.availableSizes = availableSizes;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
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
