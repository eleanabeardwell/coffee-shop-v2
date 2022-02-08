package com.eleana.coffeeshop.basket;

import com.eleana.coffeeshop.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> contents = new ArrayList<>();

    public List<Product> getContents() {
        return contents;
    }

    public BigDecimal getTotalBasketPrice() {
        return contents.stream()
                .map(product -> product.getBasePrice().add(product.getAdditionalCost()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addContents(Product p) {
        contents.add(p);
    }

    public void removeContents(Product p) {
        if(contents.isEmpty()) {
            throw new RuntimeException("Basket is empty");
        }
        contents.remove(p);
    }
}
