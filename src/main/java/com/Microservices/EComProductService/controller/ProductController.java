package com.Microservices.EComProductService.controller;

import com.Microservices.EComProductService.dto.FakeStoreProductResponseDTO;
import com.Microservices.EComProductService.entity.Product;
import com.Microservices.EComProductService.exception.InvalidInputException;
import com.Microservices.EComProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getAllProduct(){
        List<FakeStoreProductResponseDTO> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id){
        if(id < 1){
            throw new InvalidInputException("Input is incorrect!!");
        }
        FakeStoreProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

}
