package com.example.productservice.Services;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
 Product   CreateProduct(Product product);
 List<Product> getAllProducts();

 Product getSingleProduct(Long id);

 Product updateProduct(Long id,Product product) throws ProductNotFoundException;

}
