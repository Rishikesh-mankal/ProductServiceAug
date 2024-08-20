package com.rishi.productservice15aug.dto;

import com.rishi.productservice15aug.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {


    private long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    private Category category;
}
