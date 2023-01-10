package com.product.service;

import com.product.model.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    public Product addProducts(Product product);
    public List<Product> getAllProducts();
    public Optional<Product> getProductById(int productId);

    public Optional<Product> getProductByName(String productName);

    public List<Product> getProductByCategory(String category);

    public List<Product> getProductByType(String productType);

    public Product updateProducts(Product product, int productId);

    public void deleteProductsById(int productId);
}
