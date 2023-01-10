package com.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 import java.util.List;
 import java.util.Map;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ProductInfo")
public class Product {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private int productId;
    @NotNull(message = "Product cannot be null")
    @Size(min = 3, message = "ProductType should be valid")
    private String productType;

    @NotNull(message = "ProductName cannot be null")
    @Size(min = 3, message = "ProductName should be valid")
    private String productName;

    @NotNull(message = "ProductCategory cannot be null")
    @Size(min = 3, message = "ProductCategory should be valid")
    private String category;

    @NotNull(message = "Price cannot be null")
    private double price;

    @NotNull(message = "Description cannot be null")
    private String description;

}
