package com.rishi.productservice15aug.service;

import com.rishi.productservice15aug.model.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(Integer id);

    public Product creteProduct(String title,
                                String description,
                                String category,
                                String price,
                                String image);

    public List<Product> getAllProducts();
}
