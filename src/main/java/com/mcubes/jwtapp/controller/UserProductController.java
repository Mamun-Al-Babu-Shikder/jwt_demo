package com.mcubes.jwtapp.controller;

import com.mcubes.jwtapp.model.Product;
import com.mcubes.jwtapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user/products")
public class UserProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> fetchAllProduct() {
        return productService.fetchAll();
    }

    @GetMapping("{id}")
    public Product fetchById(@PathVariable("id") int id) {
        return productService.getById(id);
    }
}
