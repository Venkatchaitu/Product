package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import com.product.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")

public class ProductController {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Product addProducts(@RequestBody Product product) {
        return productService.addProducts(product);
    }

    @GetMapping("/view")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/update/{id}")
    public Product updateProducts(@RequestBody Product product, @PathVariable("id") int productId) {
        return productService.updateProducts(product, productId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductsById(@PathVariable("id") int productId) {
        productService.deleteProductsById(productId);
    }

}
