package com.eleana.coffeeshop.repository;

import com.eleana.coffeeshop.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    //    private final Map<Long, Product> productMap = new HashMap<>();
    //
    //    public Product getProduct(Long id) {
    //        return productMap.get(id);
    //    }
    //
    //    public Collection<Product> getAllProducts() {
    //        return productMap.values();
    //    }
    //
    //    public Product addProduct(Product productInfo) {
    //        productMap.put(productInfo.getProductId(), productInfo);
    //        return productInfo;
    //    }
}
