package com.example.productservice.Controllers;

import com.example.productservice.Dtos.Product.*;
import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products/")

public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("DBProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("")
    public GetAllProductsResponseDto getAllProducts(){
        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDto getAllProductsResponseDto = new GetAllProductsResponseDto();
        List<GetProductDto> getProductDtoList = new ArrayList<>();
        for(Product product:products){
            getProductDtoList.add(GetProductDto.fromProduct(product));
        }
        getAllProductsResponseDto.setProductDtoList(getProductDtoList);
        return getAllProductsResponseDto;

    }
    @GetMapping("{id}")
    public GetSingleProductResponseDto getSingleProduct(@PathVariable("id") Long id){
        Product product = productService.getSingleProduct(id);
        GetSingleProductResponseDto getSingleProductDto = new GetSingleProductResponseDto();
        getSingleProductDto.setGetProductDto(GetProductDto.fromProduct(product));
       return getSingleProductDto;
    }
    @DeleteMapping("{id}")
    public void deleteProduct(){

    }
    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        Product product = productService.CreateProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);

    }

    @PatchMapping("{id}")
    public UpdateProductResponseDto updateProduct(@PathVariable("id") Long id,
                                                  @RequestBody CreateProductRequestDto createProductRequestDto) throws ProductNotFoundException {
        Product product = productService.updateProduct(id, createProductRequestDto.toProduct());
        UpdateProductResponseDto updateProductResponseDto = new UpdateProductResponseDto();
        updateProductResponseDto.setGetProductDto(GetProductDto.fromProduct(product));
        return updateProductResponseDto;
    }


}
