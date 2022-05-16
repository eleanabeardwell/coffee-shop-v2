package com.eleana.coffeeshop;

import com.eleana.coffeeshop.controller.ProductController;
import com.eleana.coffeeshop.dto.ProductDto;
import com.eleana.coffeeshop.product.ProductService;
import com.eleana.coffeeshop.product.Size;
import com.eleana.coffeeshop.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = CoffeeshopApplication.class)
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("add and retrieve a product")
    void addAProductAndThenRetrieve() throws Exception {

        ProductDto productDto =  new ProductDto();
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

    }

}
