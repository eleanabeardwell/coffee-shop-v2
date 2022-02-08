package com.eleana.coffeeshop.repository;

import com.eleana.coffeeshop.product.Product;
import com.eleana.coffeeshop.product.Size;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductRepository {
    private final Map<Long, Product> productMap = new HashMap<>();

    ProductRepository() {
        Product product = new Product();
        product.setProductId(111L);
        product.setProductName("Latte");
        product.setBasePrice(BigDecimal.valueOf(2.55));
        product.setSize(Size.SMALL);
        product.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        product.setStockLevel(10);
        productMap.put(111L, product);
    }

    public Product getProduct(Long id) {
        return productMap.get(id);
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    public void addProduct(Product productInfo) {
        productMap.put(productInfo.getProductId(), productInfo);
    }
}
