package com.eleana.coffeeshop.product;

import com.eleana.coffeeshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public class ProductServiceTest {

    private ProductService service;
    private ProductRepository repository;

    @BeforeEach
    public void init() {
        repository = mock(ProductRepository.class);
        service = new ProductService(repository);
    }

    //add tests

}
