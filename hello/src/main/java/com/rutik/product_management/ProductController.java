package com.rutik.product_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addProduct(@RequestBody Product product){
            try{
                productService.addProduct(product);
                return ResponseEntity.ok().build();
            } catch (Exception e){
                return ResponseEntity.internalServerError().build();
            }
    }
    @PutMapping(("/update/{id}"))
    public ResponseEntity<HttpStatus>updateProduct(@PathVariable int id, @RequestBody Product product){
        try{
            productService.updateProduct(id, product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        try{
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> get(@PathVariable int id){
        try{
            Product product = productService.getProduct(id);
                return (product == null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getProducts(){
        try{
            List<Product> productList = productService.getProducts();
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}