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
    private Product product;
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
        Product product1 = new Product();
        product1.setId(fakeStoreProductResponseDto.getId());
        product1.setImageUrl(fakeStoreProductResponseDto.getImage());
        product1.setPrice(fakeStoreProductResponseDto.getPrice());
        product1.setTitle(fakeStoreProductResponseDto.getTitle());
        product1.setDescription(fakeStoreProductResponseDto.getDescription());
        product1.setCategoryName(fakeStoreProductResponseDto.getCategory());

        return product1;

    }

    @Override
    public List<Product> getAllProducts() {

        return null;
    }

    @Override
    public Product getSingleProduct(Long id
    ) {
        return restTemplate.getForObject("https://fakestoreapi.com/products/id",Product.class);

    }
}
