package com.product.controllers;

import com.product.entities.Product;
import com.product.services.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/product")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product product1 = productService.create(product);
        return ResponseEntity.ok().body(product1);
    }

    @PutMapping(value = "/product/{id}")
    public void update(@RequestParam(value = "id") Long id, @RequestBody Product product) {
        productService.update(id, product);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> findById(@RequestParam(value = "id") Long id) {
        Product product1 = productService.findById(id);
        return ResponseEntity.ok().body(product1);
    }

    @DeleteMapping(value = "/product/{id}")
    public void deleteById(@RequestParam(value = "id") Long id) {
        productService.delete(id);
    }


}
