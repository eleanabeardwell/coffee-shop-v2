package com.eleana.coffeeshop.controller;

import com.eleana.coffeeshop.dto.ProductDto;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest({ProductController.class, ProductService.class, ProductRepository.class})
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ProductService service;

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
    void addProduct() throws Exception {

        //given
        ProductDto productDto =  new ProductDto();
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

}




