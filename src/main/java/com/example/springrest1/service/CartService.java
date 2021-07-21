package com.example.springrest1.service;



import com.example.springrest1.model.Cart;
import com.example.springrest1.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    com.example.springrest1.model.Cart getNewCart();

    void addProduct(Cart cart, Product product, Integer quantity);
    void addProduct(Cart cart, Long prodId, Integer quantity);

    BigDecimal getSum(Cart cart);

    Integer getItemsAmount(Cart cart);

    void printCart(Cart cart);

    int getProductQuantity(Cart cart, Product product);
    int getProductQuantity(Cart cart, Long prodId);

    List<Product> getCartListSorted(Cart cart);
}