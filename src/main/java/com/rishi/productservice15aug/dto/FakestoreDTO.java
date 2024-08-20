package com.rishi.productservice15aug.dto;

import com.rishi.productservice15aug.model.Category;
import com.rishi.productservice15aug.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreDTO {

    /**
     * { "id": 1, "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", "price": 109.95, "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday", "category": "men's clothing", "image": "https://fakestoreapi.com/img/81fPKd-2AYL.AC_SL1500.jpg", "rating": { "rate": 3.9, "count": 120 } }
     */

    private int id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;

    public Product toProduct(FakestoreDTO dto){
        Product product = new Product();
        Category category = new Category();
        category.setTitle(dto.getTitle());
        product.setCategory(category);
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(Double.parseDouble(dto.getPrice()));


        return product;



    }
}
