package com.example.productservice.Dtos;

import com.example.productservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private Long id;
    private String title;
    private String imageurl;
    private double price;
    private String description;
    private String categoryName;

    public Product toProduct(){
        Product product= new Product();
        product.setPrice(this.price);
       product.setImageUrl(this.imageurl);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setCategoryName(this.categoryName);
        product.setId(this.id);
        return product;

    }

}