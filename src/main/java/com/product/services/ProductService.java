package com.product.services;

import com.product.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    public Product create(Product product);

    public void update(Long id, Product product);

    public List<Product> findAll();

    public Product findById(Long id);

    public void delete(Long id);
}
