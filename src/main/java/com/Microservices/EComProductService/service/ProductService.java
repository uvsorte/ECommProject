package com.Microservices.EComProductService.service;

import com.Microservices.EComProductService.dto.FakeStoreProductResponseDTO;
import com.Microservices.EComProductService.dto.ProductResponseDTO;
import com.Microservices.EComProductService.entity.Product;
import com.Microservices.EComProductService.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProduct();

    FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product updateProduct, int productId);
    boolean deleteproduct(int productId);


}
