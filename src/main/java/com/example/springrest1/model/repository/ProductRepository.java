package com.example.springrest1.model.repository;

import com.example.springrest1.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByName(String name);
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> findProductByPriceLessThan(BigDecimal maxPrice);
    List<Product> findProductByPriceGreaterThan(BigDecimal minPrice);

    Page<Product> findProductsByPriceBetweenAndNameLike(BigDecimal minPrice, BigDecimal maxPrice, String partName, Pageable varPageSort);
}
