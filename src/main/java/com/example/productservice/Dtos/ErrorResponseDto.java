package com.example.productservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    String status;
    String message;
}
