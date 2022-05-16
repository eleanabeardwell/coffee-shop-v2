package com.eleana.coffeeshop.product;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table
public class Product {

    @Id
    @Column
    private Integer productId;
    @Column
    private String productName;
    @Column
    private Size size;
    @Column
    private BigDecimal basePrice;
    @Column
    private int stockLevel;
    @Column
    @ElementCollection(targetClass=Size.class)
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
