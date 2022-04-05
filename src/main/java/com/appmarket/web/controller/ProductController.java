package com.appmarket.web.controller;


import com.appmarket.domain.dto.Product;
import com.appmarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){

        return productService.getAll();

    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){

        return productService.getProduct(productId);

    }
    @PostMapping("/save")
    public Product save( @RequestBody  Product product){

        return productService.save(product);

    }

    @DeleteMapping("/delete/{id}")
    public boolean delete  (@PathVariable("id")int productId){

        return productService.delete(productId);

    }
}
