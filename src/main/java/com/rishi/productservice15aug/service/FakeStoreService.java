package com.rishi.productservice15aug.service;

import com.rishi.productservice15aug.builder.ProductMapper;
import com.rishi.productservice15aug.dto.FakestoreDTO;
import com.rishi.productservice15aug.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreService")
public class FakeStoreService implements ProductService {

    RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Integer id) {

        ResponseEntity<FakestoreDTO> response = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, FakestoreDTO.class);

        if(response.getBody() == null){
            return null;
        }
        FakestoreDTO dto = response.getBody();

        assert dto != null;
        return dto.toProduct(dto);
    }

    @Override
    public Product creteProduct(String title, String description, String category, String price, String image) {
        FakestoreDTO requestBody = new FakestoreDTO();

        requestBody.setTitle(title);
        requestBody.setDescription(description);
        requestBody.setCategory(category);
        requestBody.setPrice(price);

        FakestoreDTO response = restTemplate.postForObject("https://fakestoreapi.com/products", requestBody, FakestoreDTO.class);

        Product product = ProductMapper.getProduct(response);

        return product;


    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        ResponseEntity<FakestoreDTO[]> response =  restTemplate.getForEntity("https://fakestoreapi.com/products",FakestoreDTO[].class);
        FakestoreDTO[] dtos = response.getBody();

        for(FakestoreDTO dto : dtos) {
            Product product = ProductMapper.getProduct(dto);
            products.add(product);
        }

        return products;

    }
}
