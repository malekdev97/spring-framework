package com.backend.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.backend.backend.dto.ProductDto;
import com.backend.backend.model.Product;
import com.backend.backend.service.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {


    private ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = new ArrayList<>();

        // products.add(new Product(1, "Employee Manager", "ERP"));

        return ResponseEntity.ok(products);
    }

    // @GetMapping("/products/{id}")
    // public Product findById(@PathVariable int id) {
    //     return new Product(id, "Employee Manager", "ERP");
    // } 

    @PostMapping("/products/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto product) {

        
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}/update")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product) {
            
        
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable int id) {

        return ResponseEntity.ok("Product deleted successfully!");
    }
}

