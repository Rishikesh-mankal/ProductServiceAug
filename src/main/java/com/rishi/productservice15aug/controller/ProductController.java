package com.rishi.productservice15aug.controller;

import com.rishi.productservice15aug.model.Product;
import com.rishi.productservice15aug.service.FakeStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private FakeStoreService svc;

    public ProductController(FakeStoreService fakeStoreService) {
       this.svc = fakeStoreService;
    }
    @GetMapping("/product/{id}")
    public void getProductById(@PathVariable("id") Long id) {
        if(id == null ){
            //Throw an exception
        }

        //call service layer
        Product prd = svc.getProductById(id);
    }
}
