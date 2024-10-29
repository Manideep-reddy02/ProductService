package com.example.productservice.Services;

import com.example.productservice.Dtos.FakeStoreProductRequestDto;
import com.example.productservice.Dtos.FakeStoreProductResponseDto;
import com.example.productservice.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreApiService implements ProductService{
    private RestTemplate restTemplate;
    //private Product product;

    public FakeStoreApiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product CreateProduct(Product product) {
        FakeStoreProductRequestDto requestDto = new FakeStoreProductRequestDto();
        requestDto.setCategory(product.getCategoryName());
        requestDto.setImage(product.getImageUrl());
        requestDto.setDescription(product.getDescription());
        requestDto.setPrice(product.getPrice());
        requestDto.setTitle(product.getTitle());
        FakeStoreProductResponseDto fakeStoreProductResponseDto =
                restTemplate.postForObject("https://fakestoreapi.com/products",
                requestDto,FakeStoreProductResponseDto.class) ;

        return fakeStoreProductResponseDto.toProduct();

    }

    @Override
    public List<Product> getAllProducts() {


        return null;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductResponseDto fakeStoreProductResponseDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                        FakeStoreProductResponseDto.class) ;
        return fakeStoreProductResponseDto.toProduct();
    }
}
