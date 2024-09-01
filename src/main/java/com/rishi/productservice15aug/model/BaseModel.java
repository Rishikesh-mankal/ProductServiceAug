package com.rishi.productservice15aug.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date created_at;
    private Date updated_at;
    private boolean isDeleted;
}
