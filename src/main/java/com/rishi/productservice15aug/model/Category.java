package com.rishi.productservice15aug.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Category extends BaseModel implements Serializable {
    private String title;
}
