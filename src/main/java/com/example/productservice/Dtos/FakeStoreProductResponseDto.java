package com.example.productservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class FakeStoreProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
