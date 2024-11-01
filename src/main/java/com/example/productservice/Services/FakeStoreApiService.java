package com.example.productservice.Services;

import com.example.productservice.Dtos.FakeStore.FakeStoreProductRequestDto;
import com.example.productservice.Dtos.FakeStore.FakeStoreProductResponseDto;
import com.example.productservice.Models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
        FakeStoreProductResponseDto [] fakeStoreProductResponseDto =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductResponseDto[].class);
        List<FakeStoreProductResponseDto> productResponseDtoList = Stream.of(fakeStoreProductResponseDto).toList();
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductResponseDto fakeStoreProductResponseDto1:fakeStoreProductResponseDto){
            products.add(fakeStoreProductResponseDto1.toProduct());
        }
        return products;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductResponseDto fakeStoreProductResponseDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                        FakeStoreProductResponseDto.class) ;
        return fakeStoreProductResponseDto.toProduct();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
//        FakeStoreProductResponseDto fakeStoreProductResponseDto =
//                restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,
//                        FakeStoreProductRequestDto.fromProduct(product),FakeStoreProductResponseDto.class);
//        return fakeStoreProductResponseDto.toProduct();

        HttpEntity<FakeStoreProductRequestDto> requestDtoHttpEntity =
                new HttpEntity<>(FakeStoreProductRequestDto.fromProduct(product));
        ResponseEntity<FakeStoreProductResponseDto> responseEntity = restTemplate.exchange("https://fakestoreapi.com/products/" + id,
                HttpMethod.PATCH,
                requestDtoHttpEntity,
                FakeStoreProductResponseDto.class);
        return responseEntity.getBody().toProduct();

    }
}
