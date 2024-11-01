package com.example.productservice.Dtos.Product;

import com.example.productservice.Dtos.Product.GetProductDto;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class GetSingleProductResponseDto {
    private GetProductDto getProductDto;
}
