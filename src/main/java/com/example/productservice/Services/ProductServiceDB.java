package com.example.productservice.Services;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Repositories.CategoryRepository;
import com.example.productservice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("DBProductService")

public class ProductServiceDB implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public  ProductServiceDB(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }
    @Override
    public Product CreateProduct(Product product) {
        Category toSaveInProduct = getToSaveInProduct(product);
        product.setCategory(toSaveInProduct);
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    private Category getToSaveInProduct(Product product) {
        String categoryName  = product.getCategory().getName();
        Optional<Category> category = categoryRepository.findByName(categoryName);
        Category toSaveInProduct = null;
        if(category.isEmpty()){
            Category categoryToSave = new Category();
            categoryToSave.setName(categoryName);
          toSaveInProduct = categoryRepository.save(categoryToSave);
        }else{
            toSaveInProduct = category.get();
        }
        return toSaveInProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product getSingleProduct(Long id) {
        Product product = productRepository.getProductsById(id);
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found in DB");
        }
        Product productToUpdate = optionalProduct.get();
        if(product.getDescription()!=null){
            productToUpdate.setDescription(product.getDescription());
        }
        if(product.getPrice()!=null){
            productToUpdate.setPrice(product.getPrice());
        }
        if(product.getTitle()!=null){
            productToUpdate.setTitle(product.getTitle());
        }
        if(product.getImageUrl()!=null){
            productToUpdate.setImageUrl(product.getImageUrl());
        }
        if(product.getCategory()!=null){
            Category category = getToSaveInProduct(product);
            productToUpdate.setCategory(category);
        }

        return productRepository.save(productToUpdate);
    }


}
