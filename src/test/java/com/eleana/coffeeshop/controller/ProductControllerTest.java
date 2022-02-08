package com.eleana.coffeeshop.controller;

import com.eleana.coffeeshop.product.Product;
import com.eleana.coffeeshop.product.ProductService;
import com.eleana.coffeeshop.product.Size;
import com.eleana.coffeeshop.repository.ProductRepository;
import com.eleana.coffeeshop.resources.ProductList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest({ProductController.class, ProductService.class, ProductRepository.class})
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    ProductControllerTest() throws JSONException {
    }

    @Test
    void getLatteProduct() throws Exception {

        //when
        //service.getProduct(id) --> return mockData (Product Dto)

        mockMvc.perform(MockMvcRequestBuilders.get("/product/111"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(111))
                .andExpect(jsonPath("$.productName").value("Latte"))
                .andExpect(jsonPath("$.size").value("SMALL"))
                .andExpect(jsonPath("$.basePrice").value(2.55));
    }

    @Test
    void getSmallLattePrice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/111/price"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.55"));
    }

    @Test
    void getProducts() throws Exception {

        ProductList productList = new ProductList();

        mockMvc.perform(MockMvcRequestBuilders.get("/product"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(productList.getProductList()));
    }

    @Test
    void addProduct() throws Exception {

        Product product = new Product();
        product.setProductId(112L);
        product.setProductName("Latte");
        product.setBasePrice(BigDecimal.valueOf(2.55));
        product.setSize(Size.MEDIUM);
        product.setAvailableSizes(List.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
        product.setStockLevel(10);

        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(product)))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/product/112"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(112))
                .andExpect(jsonPath("$.productName").value("Latte"))
                .andExpect(jsonPath("$.size").value("MEDIUM"))
                .andExpect(jsonPath("$.basePrice").value(2.55));
    }

//    private JSONArray sizes = new JSONArray().put("SMALL").put("MEDIUM").put("LARGE");
//
//
//
//    private String americano = new JSONObject()
//            .put("size", "SMALL")
//            .put("basePrice", 1.50)
//            .put("availableSizes", sizes)
//            .put("productId", 141)
//            .put("productName", "Americano")
//            .put("stockLevel", 30)
//            .put("additionalCost", 0)
//            .toString();


}




