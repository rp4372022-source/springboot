package com.rutik.product_management;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo {

    private final List<Product> productList = new ArrayList<>(List.of(
            new Product(101,"Vivo T2 pro 5g",23000.00),
            new Product(102,"Acer Aspire 5",60000.00),
            new Product(103,"B2 Bomber",17_14_20_000.00)
    ));
    public List<Product> getProducts(){
        return this.productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void updateProduct(int id, Product product) {
        productList.remove(id);
        productList.add(id,product);
    }

    public void delete(int id) {
        productList.remove(id);
    }

    public Product getProduct(int id) {
            return productList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}
