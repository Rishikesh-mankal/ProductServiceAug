package com.rishi.productservice15aug.service;

import com.rishi.productservice15aug.model.Product;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreService implements ProductService {


    @Override
    public Product getProductById(Long id) {
        return null;
    }
}
