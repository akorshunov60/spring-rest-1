package com.example.springrest1.controller.rest;

import com.example.springrest1.model.entity.Product;
import com.example.springrest1.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final ProductRepository pr;

    @GetMapping(value = "/{id}")
    public Product getProductById (@PathVariable Long id) {
        return pr.findById(id).orElseThrow(() ->
                new NoResultException("Товар с указанным id (" + id + ") не существует!"));
    }

    @GetMapping(value = "/")
    public List<Product> getAllProducts () {
        return pr.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public Product saveProduct(Product product) {
        return pr.save(product);
    }

    @GetMapping(value = "/delete/{id}")
    public void deleteProductById (@PathVariable Long id) {
        pr.deleteById(id);
    }

}
