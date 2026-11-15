package com.rutik.product_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> getProducts(){
        return productRepo.getProducts();
    }

    public void addProduct(Product product) {
        productRepo.addProduct(product);
    }

    public void updateProduct(int id, Product product) {
        productRepo.updateProduct(id, product);
    }

    public void deleteProduct(int id) {
        productRepo.delete(id);
    }

    public Product getProduct(int id) {
        return productRepo.getProduct(id);
    }
}
