package com.example.productservice.Dtos.FakeStore;

import com.example.productservice.Models.Product;
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

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setPrice(this.price);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setImageUrl(this.image);
        product.setCategoryName(this.category);
        return product;
    }
}
