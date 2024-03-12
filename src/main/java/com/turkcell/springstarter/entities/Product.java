package com.turkcell.springstarter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    //model tanımını yönet
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="unit_price")
    private double unitPrice;
    @Column(name="stock")
    private long stock;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;




}
