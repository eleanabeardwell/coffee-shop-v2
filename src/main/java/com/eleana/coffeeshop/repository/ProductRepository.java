package com.eleana.coffeeshop.repository;

import com.eleana.coffeeshop.product.Product;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepository {
    private final Map<Long, Product> productMap = new HashMap<>();

    public Product getProduct(Long id) {
        return productMap.get(id);
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    public Product addProduct(Product productInfo) {
        productMap.put(productInfo.getProductId(), productInfo);
        return productInfo;
    }
}
