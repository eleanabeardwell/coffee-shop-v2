package com.eleana.coffeeshop.product;

import com.eleana.coffeeshop.dto.ProductDto;
import com.eleana.coffeeshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    private ProductService service;
    private ProductRepository repository;

    @BeforeEach
    public void init() {
        repository = mock(ProductRepository.class);
        service = new ProductService(repository);
    }

    @Test
    @DisplayName("getProduct method, given an id returns a productDto")
    void getProduct() throws Exception {

        //given
        Integer productId = 112;

        Product latteProduct = new Product();
        latteProduct.setProductId(112);
        latteProduct.setProductName("Latte");
        latteProduct.setBasePrice(BigDecimal.valueOf(2.55));
        latteProduct.setSize(Size.MEDIUM);
        latteProduct.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        latteProduct.setStockLevel(10);

        ProductDto latteProductDto = new ProductDto();
        latteProductDto.setProductId(112);
        latteProductDto.setProductName("Latte");
        latteProductDto.setBasePrice(BigDecimal.valueOf(2.55));
        latteProductDto.setSize(Size.MEDIUM);
        latteProductDto.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        latteProductDto.setStockLevel(10);

        //when
        when(repository.findById(productId)).thenReturn(Optional.of(latteProduct));

        //then
        ProductDto result = service.getProduct(productId);
        assertEquals(result.getProductId(), latteProductDto.getProductId());
        assertEquals(result.getProductName(), latteProductDto.getProductName());
    }

    @Test
    @DisplayName("getPrice, given a productId returns the product price")
    void getPrice() throws Exception {

        //given
        Integer productId = 112;

        Product latteProduct = new Product();
        latteProduct.setProductId(112);
        latteProduct.setProductName("Latte");
        latteProduct.setBasePrice(BigDecimal.valueOf(2.55));
        latteProduct.setSize(Size.MEDIUM);
        latteProduct.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        latteProduct.setStockLevel(10);

        //when
        when(repository.findById(productId)).thenReturn(Optional.of(latteProduct));

        //then
        BigDecimal result = service.getPrice(productId);
        BigDecimal productPrice = latteProduct.getBasePrice().add(latteProduct.getAdditionalCost());
        assertEquals(result, productPrice);
    }

    @Test
    @DisplayName("getAllProducts should return a list of productDtos")
    void getAllProducts() throws Exception {

        //given
        Product latteProduct = new Product();
        latteProduct.setProductId(113);
        latteProduct.setProductName("Latte");
        latteProduct.setBasePrice(BigDecimal.valueOf(2.55));
        latteProduct.setSize(Size.LARGE);
        latteProduct.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        latteProduct.setStockLevel(10);

        Product espressoProduct = new Product();
        espressoProduct.setProductId(131);
        espressoProduct.setProductName("Espresso");
        espressoProduct.setBasePrice(BigDecimal.valueOf(1.10));
        espressoProduct.setSize(Size.SINGLE);
        espressoProduct.setAvailableSizes(List.of(Size.SINGLE, Size.DOUBLE));
        espressoProduct.setStockLevel(10);

        ProductDto latteProductDto = new ProductDto();
        latteProductDto.setProductId(113);
        latteProductDto.setProductName("Latte");
        latteProductDto.setBasePrice(BigDecimal.valueOf(2.55));
        latteProductDto.setSize(Size.LARGE);
        latteProductDto.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        latteProductDto.setStockLevel(10);

        ProductDto espressoProductDto = new ProductDto();
        espressoProductDto.setProductId(131);
        espressoProductDto.setProductName("Espresso");
        espressoProductDto.setBasePrice(BigDecimal.valueOf(1.10));
        espressoProductDto.setSize(Size.SINGLE);
        espressoProductDto.setAvailableSizes(List.of(Size.SINGLE, Size.DOUBLE));
        espressoProductDto.setStockLevel(10);

        //when
        when(repository.findAll()).thenReturn(List.of(latteProduct, espressoProduct));

        //then
        Collection<ProductDto> result = service.getAllProducts();
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("addProduct returns a productDto")
    void addProduct() throws Exception {

        //given
        ProductDto latteProductDto = new ProductDto();
        latteProductDto.setProductId(113);
        latteProductDto.setProductName("Latte");
        latteProductDto.setBasePrice(BigDecimal.valueOf(2.55));
        latteProductDto.setSize(Size.LARGE);
        latteProductDto.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        latteProductDto.setStockLevel(10);

        Product latteProduct = new Product();
        latteProduct.setProductId(113);
        latteProduct.setProductName("Latte");
        latteProduct.setBasePrice(BigDecimal.valueOf(2.55));
        latteProduct.setSize(Size.LARGE);
        latteProduct.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        latteProduct.setStockLevel(10);

        //when
        when(repository.save(latteProduct)).thenReturn(latteProduct);

        //then
        ProductDto result = service.addProduct(latteProductDto);
        assertEquals(latteProductDto.getProductId(), result.getProductId());
        assertEquals(latteProductDto.getProductName(), result.getProductName());
    }

}
