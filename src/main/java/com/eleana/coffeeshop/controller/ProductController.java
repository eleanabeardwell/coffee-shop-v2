package com.eleana.coffeeshop.controller;

import com.eleana.coffeeshop.dto.ProductDto;
import com.eleana.coffeeshop.product.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collection;

@Validated
@RestController
public class ProductController {

    ProductService service;

    ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable("productId") Integer productId) {
        return service.getProduct(productId);
    }

    @GetMapping("/product/{productId}/price")
    public BigDecimal getPrice(@PathVariable("productId") Integer productId) {
        return service.getPrice(productId);
    }

    @GetMapping("/product")
    public Collection<ProductDto> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/product")
    public ProductDto addProduct(@Valid @RequestBody ProductDto productInfo) {
        service.addProduct(productInfo);
        return productInfo;
    }

}
