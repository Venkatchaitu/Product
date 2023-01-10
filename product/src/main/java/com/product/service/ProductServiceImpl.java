package com.product.service;

import com.product.repository.ProductRepository;
import com.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProducts(Product product) {
        product.setProductId(sequenceGeneratorService.getSequenceNumber(Product.SEQUENCE_NAME));
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int productId) {
        Optional<Product> product=productRepository.findById(productId);
        return product;
    }

    @Override
    public Optional<Product> getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        List<Product> product = productRepository.findByCategory(category);
        return product;
    }

    @Override
    public List<Product> getProductByType(String productType) {
        return productRepository.findByProductType(productType);
    }

    @Override
    public Product updateProducts(Product product, int productId) {


        Product pro= productRepository.findById(productId).get();
        pro.setProductType(product.getCategory());
        pro.setProductName(product.getProductName());
        pro.setCategory(product.getCategory());
        pro.setPrice(product.getPrice());
        pro.setDescription(product.getDescription());
        return productRepository.save(pro);
    }

    @Override
    public void deleteProductsById(int productId) {
        productRepository.deleteById(productId);
    }
}
