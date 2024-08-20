package com.rishi.productservice15aug.controller;

import com.rishi.productservice15aug.builder.ProductMapper;
import com.rishi.productservice15aug.dto.CreateProductRequestDTO;
import com.rishi.productservice15aug.dto.ErrorDTO;
import com.rishi.productservice15aug.dto.FakestoreDTO;
import com.rishi.productservice15aug.dto.ProductResponseDTO;
import com.rishi.productservice15aug.exceptions.InvalidProductIdException;
import com.rishi.productservice15aug.exceptions.ProductNotFoundException;
import com.rishi.productservice15aug.model.Product;
import com.rishi.productservice15aug.service.FakeStoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private final FakeStoreService svc;

    public ProductController(FakeStoreService fakeStoreService) {
       this.svc = fakeStoreService;
    }

    @PostMapping("/product")
    public ProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO dto) {

       Product product =  svc.creteProduct(dto.getTitle(),
                dto.getDescription(),
                dto.getCategory(),
                dto.getPrice(),
                dto.getImage());


        return ProductMapper.getProductResponseDTO(product);

    }
    @GetMapping("/product/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") Long id) throws InvalidProductIdException, ProductNotFoundException {
        if(id == null ){
            System.out.println("ID does not exist");
            throw new InvalidProductIdException("Id does not exists");
        }

        //call service layer
        Product prd = svc.getProductById(id);

        if(prd == null){
            throw new ProductNotFoundException("Product not found");
        }

        //Map to DTO and return
        return ProductMapper.getProductResponseDTO(prd);
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getProduct(){
      List<Product> products = svc.getAllProducts();
      List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
      for(Product product : products){
          ProductResponseDTO productResponseDTO = ProductMapper.getProductResponseDTO(product);
          productResponseDTOS.add(productResponseDTO);
      }

      return productResponseDTOS;
    }




}
