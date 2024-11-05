package com.example.productservice.Dtos.Product;

import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter@Setter
public class GetProductDto {
    private Long id;
    private String title;
    private String imageUrl;
    private String Category;
    private double price;
    private String description;
    public static GetProductDto fromProduct(Product product){
        GetProductDto responseDto = new GetProductDto();
        responseDto.setId(product.getId());
        responseDto.setCategory(product.getCategory().getName());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setTitle(product.getTitle());
        return responseDto;
    }
    public Product toProduct(){
        Product product= new Product();
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        product.setTitle(this.title);
        product.setDescription(this.description);
        Category category = new Category();
        category.setName(this.Category);
        product.setCategory(category);
        product.setId(this.id);
        return product;

    }
}
