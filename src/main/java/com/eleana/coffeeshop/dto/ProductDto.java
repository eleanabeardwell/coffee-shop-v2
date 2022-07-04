package com.eleana.coffeeshop.dto;

import com.eleana.coffeeshop.product.Size;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class ProductDto {

    @NotBlank(message = "productName is a required field")
    private String productName;
    @NotNull(message = "productId is a required field") @Min(value = 1, message = "productId should be greater than 1")
    private Integer productId;
    @NotNull(message = "size is a required field")
    private Size size;
    @NotNull(message = "basePrice is a required field")
    private BigDecimal basePrice;
    @NotNull(message = "stockLevel is a required field")
    private int stockLevel;
    @NotEmpty(message = "availableSizes is a required field")
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
