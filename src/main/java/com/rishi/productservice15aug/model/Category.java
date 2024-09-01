package com.rishi.productservice15aug.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel implements Serializable {
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    List<Product> products = new ArrayList<>();
}
