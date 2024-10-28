package com.example.productservice.Services;

import com.example.productservice.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
 Product   CreateProduct(Product product);
 List<Product> getAllProducts();

 Product getSingleProduct(Long id);

}
