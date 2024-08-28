package com.mcubes.jwtapp.controller;

import com.mcubes.jwtapp.model.Product;
import com.mcubes.jwtapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/products")
public class AdminProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> fetchAllProduct() {
        return productService.fetchAll();
    }

    @PostMapping(value = "/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

}
