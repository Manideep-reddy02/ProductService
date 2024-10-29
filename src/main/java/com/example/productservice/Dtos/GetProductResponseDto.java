package com.example.productservice.Dtos;

import com.example.productservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class GetProductResponseDto {
    private Long id;
    private String title;
    private String imageUrl;
    private String Category;
    private double price;
    private String description;
    public static GetProductResponseDto fromProduct(Product product){
        GetProductResponseDto getResponseDto = new GetProductResponseDto();
        getResponseDto.setId(product.getId());
        getResponseDto.setCategory(product.getCategoryName());
        getResponseDto.setDescription(product.getDescription());
        getResponseDto.setTitle(product.getTitle());
        getResponseDto.setPrice(product.getPrice());
        getResponseDto.setImageUrl(product.getImageUrl());
        return getResponseDto;
    }

}
