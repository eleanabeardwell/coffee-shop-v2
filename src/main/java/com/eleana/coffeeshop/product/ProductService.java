package com.eleana.coffeeshop.product;

import com.eleana.coffeeshop.dto.ProductDto;
import com.eleana.coffeeshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;

@Service
public class ProductService {

    private final ProductRepository repository;

    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDto getProduct(Long id) {
        return mapToProductDto(repository.getProduct(id));
    }
    
    public BigDecimal getPrice(Long id) {
        Product product = repository.getProduct(id);
        return product.getBasePrice().add(product.getAdditionalCost());
    }

    public Collection<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    public void addProduct(ProductDto productInfo) {
        repository.addProduct(mapToProduct(productInfo));
    }

    private Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setBasePrice(productDto.getBasePrice());
        product.setSize(productDto.getSize());
        product.setAvailableSizes(productDto.getAvailableSizes());
        product.setStockLevel(productDto.getStockLevel());
        return product;
    }

    private ProductDto mapToProductDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setBasePrice(product.getBasePrice());
        dto.setSize(product.getSize());
        dto.setAvailableSizes(product.getAvailableSizes());
        dto.setStockLevel(product.getStockLevel());
        return dto;
    }
    
}
