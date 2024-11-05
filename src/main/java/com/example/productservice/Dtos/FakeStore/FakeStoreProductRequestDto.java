package com.example.productservice.Dtos.FakeStore;

import com.example.productservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDto {
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    public static FakeStoreProductRequestDto fromProduct(Product product){
        FakeStoreProductRequestDto fakeStoreProductRequestDto = new FakeStoreProductRequestDto();
        fakeStoreProductRequestDto.setCategory(product.getCategory().getName());
        fakeStoreProductRequestDto.setTitle(product.getTitle());
        fakeStoreProductRequestDto.setDescription(product.getDescription());
        fakeStoreProductRequestDto.setPrice(product.getPrice());
        fakeStoreProductRequestDto.setImage(product.getImageUrl());
        return fakeStoreProductRequestDto;


    }
}

