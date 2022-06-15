package com.eleana.coffeeshop.controller;

import com.eleana.coffeeshop.dto.ProductDto;
import com.eleana.coffeeshop.exception.ProductIdAlreadyExistsException;
import com.eleana.coffeeshop.exception.ProductNotFoundException;
import com.eleana.coffeeshop.product.ProductService;
import com.eleana.coffeeshop.product.Size;
import com.eleana.coffeeshop.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest({ProductController.class, ProductService.class, ProductRepository.class, ProductNotFoundException.class})
class ProductControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService service;
    private ProductNotFoundException exception;

    @Test
    @DisplayName("get product with product id returns a product")
    void getLatteProduct() throws Exception {

        //given
        ProductDto latteProduct = new ProductDto();
        latteProduct.setProductId(112);
        latteProduct.setProductName("Latte");
        latteProduct.setBasePrice(BigDecimal.valueOf(2.55));
        latteProduct.setSize(Size.MEDIUM);
        latteProduct.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        latteProduct.setStockLevel(10);

        //when
        when(service.getProduct(112)).thenReturn(latteProduct);

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/product/112"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(112))
                .andExpect(jsonPath("$.productName").value("Latte"))
                .andExpect(jsonPath("$.size").value("MEDIUM"))
                .andExpect(jsonPath("$.basePrice").value(2.55));
    }

    @Test
    @DisplayName("get product price with product id returns correct price")
    void getLargeLattePrice() throws Exception {

        //given
        ProductDto latteProduct = new ProductDto();
        latteProduct.setProductId(113);
        latteProduct.setProductName("Latte");
        latteProduct.setBasePrice(BigDecimal.valueOf(2.55));
        latteProduct.setSize(Size.LARGE);
        latteProduct.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        latteProduct.setStockLevel(10);

        //when
        when(service.getPrice(113)).thenReturn(BigDecimal.valueOf(3.15));

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/product/113/price"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.15"));
    }

    @Test
    @DisplayName("get products returns a list of products")
    void getProducts() throws Exception {

        //given
        ProductDto latteProduct = new ProductDto();
        latteProduct.setProductId(113);
        latteProduct.setProductName("Latte");
        latteProduct.setBasePrice(BigDecimal.valueOf(2.55));
        latteProduct.setSize(Size.LARGE);
        latteProduct.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        latteProduct.setStockLevel(10);

        ProductDto espressoProduct = new ProductDto();
        espressoProduct.setProductId(131);
        espressoProduct.setProductName("Espresso");
        espressoProduct.setBasePrice(BigDecimal.valueOf(1.10));
        espressoProduct.setSize(Size.SINGLE);
        espressoProduct.setAvailableSizes(List.of(Size.SINGLE, Size.DOUBLE));
        espressoProduct.setStockLevel(10);

        //when
        when(service.getAllProducts()).thenReturn(List.of(latteProduct, espressoProduct));

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/product"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @DisplayName("add product returns product")
    void addProduct() throws Exception {

        //given
        ProductDto productDto = new ProductDto();
        productDto.setProductId(112);
        productDto.setProductName("Latte");
        productDto.setBasePrice(BigDecimal.valueOf(2.55));
        productDto.setSize(Size.MEDIUM);
        productDto.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        productDto.setStockLevel(10);

        //when
        when(service.addProduct(productDto)).thenReturn(productDto);

        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(productDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(112))
                .andExpect(jsonPath("$.productName").value("Latte"))
                .andExpect(jsonPath("$.size").value("MEDIUM"))
                .andExpect(jsonPath("$.basePrice").value(2.55));
    }

    @Test
    @DisplayName("get product with product id not found returns a ProductNotFoundException")
    void getLatteProductReturnsProductNotFoundException() throws Exception {

        //when
        doThrow(ProductNotFoundException.class).when(service).getProduct(112);

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/product/112"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product not found"));
    }

    @Test
    @DisplayName("get product price with product id not found returns a ProductNotFoundException")
    void getLatteProductPriceReturnsProductNotFoundException() throws Exception {

        //when
        doThrow(ProductNotFoundException.class).when(service).getPrice(112);

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/product/112/price"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product not found"));
    }
}




