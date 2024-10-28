package com.example.productservice.Controllers;

import com.example.productservice.Dtos.CreateProductRequestDto;
import com.example.productservice.Dtos.CreateProductResponseDto;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")

public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getAllProducts(){
        return null;

    }
    @GetMapping("{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }
    @DeleteMapping("{id}")
    public void deleteProduct(){

    }
    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        Product product = productService.CreateProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);

    }


}
