package com.rishi.productservice15aug.service;

import com.rishi.productservice15aug.model.Category;
import com.rishi.productservice15aug.model.Product;
import com.rishi.productservice15aug.repository.CategoryRepo;
import com.rishi.productservice15aug.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }
    @Override
    public Product getProductById(Integer id) {
        Product product = productRepo.getReferenceById(id);

        return product;
    }

    @Override
    public Product creteProduct(String title, String description, String category, String price, String image) {
        Category existingCategory = categoryRepo.findByTitle(category);

        if(existingCategory == null) {
            existingCategory = new Category();
            existingCategory.setTitle(category);
            existingCategory.setDeleted(false);
            existingCategory.setCreated_at(new Date());
            existingCategory.setUpdated_at(new Date());
            existingCategory =  categoryRepo.save(existingCategory);

            System.out.println("Category created: " + existingCategory.getTitle());
        }

        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setCategory(existingCategory);
        product.setPrice(Double.parseDouble(price));
        product.setDeleted(false);
        product.setCreated_at(new Date());
        product.setUpdated_at(new Date());
        product.setImageUrl(image);
        product = productRepo.save(product);

        System.out.println("Product is created: " + product.getTitle());

        return product;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products = productRepo.findAll();
        return products;
    }

    public Product getProductByIdAndTitle(Integer id, String title) {
        Product product = productRepo.getProductFromTitle(id, title);

        return product;
    }
}
