package com.rishi.productservice15aug.builder;

import com.rishi.productservice15aug.dto.FakestoreDTO;
import com.rishi.productservice15aug.dto.ProductResponseDTO;
import com.rishi.productservice15aug.model.Category;
import com.rishi.productservice15aug.model.Product;

public class ProductMapper {

    public static ProductResponseDTO getProductResponseDTO(Product prd) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(prd.getId());
        productResponseDTO.setCategory(prd.getCategory());
        productResponseDTO.setDescription(prd.getDescription());
        productResponseDTO.setPrice(prd.getPrice());
        productResponseDTO.setDescription(prd.getDescription());
        productResponseDTO.setId(prd.getId());
        return productResponseDTO;
    }

    public static Product getProduct(FakestoreDTO productResponseDTO) {
        Product product = new Product();
        Category category = new Category();
        category.setId(productResponseDTO.getId());
        category.setTitle(productResponseDTO.getTitle());
        product.setTitle(productResponseDTO.getTitle());
        product.setCategory(category);
        product.setDescription(productResponseDTO.getDescription());
        product.setPrice(Double.parseDouble(productResponseDTO.getPrice()));
        return product;

    }
}
