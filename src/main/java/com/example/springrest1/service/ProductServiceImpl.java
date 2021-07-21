package com.example.springrest1.service;

import com.example.springrest1.model.entity.Product;
import com.example.springrest1.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository pr;

    @Override
    public List<Product> getProductList() {
        return pr.findAll();
    }

    public Page<Product> getProductsFiltered(BigDecimal minPrice, BigDecimal maxPrice, String partName, Integer pageNum, Integer productsPerPage) {
        Pageable pageRequest = PageRequest.of(pageNum - 1, productsPerPage);
        return pr.findProductsByPriceBetweenAndNameLike(minPrice, maxPrice, "%"+partName+"%", pageRequest);
    }

    @Override
    public Product getProductById(Long id) {
        return pr.findById(id).orElseThrow(() ->
                new NoResultException("Товар с указанным id не существует!"));
    }

    @Override
    public void saveOrUpdate(Product product) {
        pr.save(product);
    }

    @Override
    public void deleteById(Long id) {
        pr.deleteById(id);
    }

}
