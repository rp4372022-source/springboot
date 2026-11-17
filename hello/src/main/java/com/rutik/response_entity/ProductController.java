package com.rutik.response_entity;

import com.rutik.product_management.Product;
import com.rutik.product_management.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addProduct(Product product){
        return new ResponseEntity<>(HttpStatus.OK);
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
    public ResponseEntity<Product> get(@PathVariable int id){
        Product product = productService.getProduct(id);
        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getproducts")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.FOUND);
    }
}
