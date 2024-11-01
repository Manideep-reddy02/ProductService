package com.example.productservice.Services;

import com.example.productservice.Models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DBProductService")

public class ProductServiceDB implements ProductService{
    @Override
    public Product CreateProduct(Product product) {
        return null;

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }


}
