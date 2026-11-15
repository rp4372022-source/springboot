package com.rutik.product_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan

@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public void addProduct(Product product){
        productService.addProduct(product);
    }
    @PutMapping(("/update/{id}"))
    public void updateProduct(@PathVariable int id, @RequestBody Product product){
        productService.updateProduct(id, product);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        productService.deleteProduct(id);
    }
    @GetMapping("/get/{id}")
    public Product get(@PathVariable int id){
        return productService.getProduct(id);
    }
    @GetMapping("/getproducts")
    List<Product> getProducts(){
        return productService.getProducts();
    }
}
