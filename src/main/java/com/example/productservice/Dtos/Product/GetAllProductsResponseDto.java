package com.example.productservice.Dtos.Product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class GetAllProductsResponseDto {
    private List<GetProductDto> productDtoList;
}
