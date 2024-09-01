package com.rishi.productservice15aug.repository;

import com.rishi.productservice15aug.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {


    List<Product> findAll();

    Product findProductById(int Id);

    Product findByDescription(String Description);

    Product save(Product product);
}
