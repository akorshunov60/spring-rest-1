package com.example.springrest1.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_products")
public class CartEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn (name = "order_id")
    private Order order;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn (name = "product_id")
    private Product product;

    @Column (name = "quantity")
    private Long quantity;

    @Column (name = "acquire_price")
    private BigDecimal acquirePrice;
}
