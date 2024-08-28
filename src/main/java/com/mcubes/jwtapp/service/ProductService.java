package com.mcubes.jwtapp.service;

import com.mcubes.jwtapp.exceptoion.ProductNotFoundException;
import com.mcubes.jwtapp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "iPhone", 500000));
        products.add(new Product(2, "Samsung", 250000));
    }

    public List<Product> fetchAll() {
        return products;
    }

    public Product save(Product product) {
        Product newProduct = new Product(products.size() + 1, product.name(), product.price());
        products.add(newProduct);
        return newProduct;
    }

    public Product getById(int id) {
        return products.stream()
                .filter(p -> p.id() == id)
                .findAny()
                .orElseThrow(ProductNotFoundException::new);
    }
}
