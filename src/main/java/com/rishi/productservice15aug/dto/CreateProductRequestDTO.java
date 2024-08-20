package com.rishi.productservice15aug.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private int id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;


}
