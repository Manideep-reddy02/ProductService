package com.example.productservice.Dtos.Product;

import com.example.productservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    private Long id;
    private String title;
    private String imageUrl;
    private String Category;
    private double price;
    private String description;
    public static CreateProductResponseDto fromProduct(Product product){
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setCategory(product.getCategoryName());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setTitle(product.getTitle());
        return responseDto;
    }
}
