package com.rishi.productservice15aug.model;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Product extends BaseModel implements Serializable {

    private String title;
    private String description;
    private double price;
    private String imageUrl;

    private Category category;
}
