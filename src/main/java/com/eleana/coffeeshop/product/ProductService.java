package com.eleana.coffeeshop.product;

import com.eleana.coffeeshop.dto.ProductDto;
import com.eleana.coffeeshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder.In;
import java.math.BigDecimal;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDto getProduct(Integer id) {
        return mapToProductDto(repository.findById(id).get());
    }
    
    public BigDecimal getPrice(Integer id) {
        Product product = repository.findById(id).get();
        return product.getBasePrice().add(product.getAdditionalCost());
    }

    public Collection<ProductDto> getAllProducts() {
        Collection<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products.stream().map(this::mapToProductDto).collect(Collectors.toList());
    }

    public ProductDto addProduct(ProductDto productInfo) {
        repository.save(mapToProduct(productInfo));
        return productInfo;
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
