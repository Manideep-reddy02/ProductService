package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String imageUrl;
    private Double price;
    private String description;
    @ManyToOne
    private Category category;
}
