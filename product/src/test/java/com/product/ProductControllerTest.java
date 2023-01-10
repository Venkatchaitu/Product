package com.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.product.controller.ProductController;
import com.product.model.Product;
import com.product.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    Product PRO_1 = new Product(1,"household","ApplePhone","Electronics",90000,"Its a very gud mobile");
   Product PRO_2 = new Product(2,"office","Table ","Furniture",9000,"Hard wood and good ");
   Product PRO_3 = new Product(3,"skincare","sunscreen","cosmetics",900,"Useful in sun");

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }
    @Test
    public void getAllProducts_success() throws Exception {
        List<Product> records = new ArrayList<>(Arrays.asList(PRO_1 , PRO_2, PRO_3));

        Mockito.when(productService.getAllProducts()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/view")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
    }
}



