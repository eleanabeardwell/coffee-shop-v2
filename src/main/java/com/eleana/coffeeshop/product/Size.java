package com.eleana.coffeeshop.product;

import java.math.BigDecimal;

public enum Size {
    SMALL (new BigDecimal("0")),
    MEDIUM (new BigDecimal("0.3")),
    LARGE (new BigDecimal("0.6")),
    SINGLE (new BigDecimal("0")),
    DOUBLE (new BigDecimal("1.1"));

    private BigDecimal additionalCost;

    Size(BigDecimal additionalCost) {
        this.additionalCost = additionalCost;
    }

    public BigDecimal getAdditionalCost() {
        return additionalCost;
    }
}
