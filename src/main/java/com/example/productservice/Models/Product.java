package com.example.productservice.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private String imageUrl;
    private double price;
    private String description;
    private String categoryName;
}
