package com.klu.store.entity;

import javax.persistence.*;

@Entity
@Table(name = "skill_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Try AUTO / SEQUENCE also
    private int id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 100)
    private String description;

    private double price;

    private int quantity;

    // Constructors
    public Product() {}

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
