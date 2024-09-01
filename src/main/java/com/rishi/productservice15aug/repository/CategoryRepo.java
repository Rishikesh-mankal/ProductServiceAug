package com.rishi.productservice15aug.repository;

import com.rishi.productservice15aug.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findByTitle(String title);

    Category save(Category category);
}
