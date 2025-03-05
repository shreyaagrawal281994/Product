package com.product.services;

import com.product.entities.Product;
import com.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public void update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        productOptional.ifPresentOrElse(product1 -> productRepository.saveAndFlush(product),
                productOptional::get);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
            return productOptional.get();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
