package com.eleana.coffeeshop;

import com.eleana.coffeeshop.dto.ProductDto;
import com.eleana.coffeeshop.product.Size;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = CoffeeshopApplication.class)
class ProductControllerIntegrationTest {

    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("add and retrieve a product")
    void addAProductAndThenRetrieve() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setProductId(112);
        productDto.setProductName("Latte");
        productDto.setBasePrice(BigDecimal.valueOf(2.55));
        productDto.setSize(Size.MEDIUM);
        productDto.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        productDto.setStockLevel(10);

        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(productDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(112))
                .andExpect(jsonPath("$.productName").value("Latte"))
                .andExpect(jsonPath("$.size").value("MEDIUM"))
                .andExpect(jsonPath("$.basePrice").value(2.55));

        mockMvc.perform(MockMvcRequestBuilders.get("/product/112"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(112))
                .andExpect(jsonPath("$.productName").value("Latte"))
                .andExpect(jsonPath("$.size").value("MEDIUM"))
                .andExpect(jsonPath("$.basePrice").value(2.55));

        mockMvc.perform(MockMvcRequestBuilders.get("/product/112/price"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.85"));

        mockMvc.perform(MockMvcRequestBuilders.get("/product"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));

        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(productDto)))
                .andExpect(status().isConflict())
                .andExpect(content().string("A product with that id already exists, please try again."));
    }

    @Test
    @DisplayName("get product returns 404 when product id not found")
    void getProductReturnsProductNotFoundException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/116"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product not found"));

    }

    @Test
    @DisplayName("get price returns 404 when product id not found")
    void getProductPriceReturnsProductNotFoundException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/116/price"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product not found"));

    }
}
