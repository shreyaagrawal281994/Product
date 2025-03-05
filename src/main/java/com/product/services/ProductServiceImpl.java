package com.product.services;

import com.product.entities.Product;
import com.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private Product create(Product product) {
        return productRepository.saveAndFlush(product);
    }

    private void update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        productOptional.ifPresentOrElse(product1 -> productRepository.saveAndFlush(product),
                productOptional::get);
    }

    private List<Product> findAll() {
        return productRepository.findAll();
    }

    private Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
            return productOptional.get();
    }
}
