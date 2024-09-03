package com.rishi.productservice15aug.repository;

import com.rishi.productservice15aug.model.Product;
import com.rishi.productservice15aug.repository.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {


    List<Product> findAll();

    Product findProductById(int Id);

    Product findByDescription(String Description);

    Product save(Product product);

//    List<Product> findAllByCategory_name(String category_name);

    @Query("select p from Product p where p.id = :id and p.title = :title")
    Product getProductFromTitle(@Param("id") Integer id, @Param("title") String title);

    /**
     * Projections
     */

    @Query("select p.id, p.title, p.price from Product p where p.id = :id ")
    ProductProjection getTitleAndPriceOfProductFromId(@Param("id") Integer id);

    @Query("select p.id, p.price from Product p where p.title = :title ")
    List<ProductProjection> getPriceOfProductFromTitle(@Param("title") String title);

}
