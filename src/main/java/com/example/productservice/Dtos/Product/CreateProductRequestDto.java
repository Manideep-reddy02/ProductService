package com.example.productservice.Dtos.Product;

import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private Long id;
    private String title;
    private String imageurl;
    private Double price;
    private String description;
    private String categoryName;

    public Product toProduct(){
        Product product= new Product();
        product.setPrice(this.price);
       product.setImageUrl(this.imageurl);
        product.setTitle(this.title);
        product.setDescription(this.description);
        Category category = new Category();
        category.setName(this.categoryName);
        product.setCategory(category);
        product.setId(this.id);
        return product;

    }

}
