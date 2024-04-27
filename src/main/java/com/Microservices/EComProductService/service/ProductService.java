package com.Microservices.EComProductService.service;

import com.Microservices.EComProductService.dto.CreateProductRequestDTO;
import com.Microservices.EComProductService.dto.ProductResponseDTO;
import com.Microservices.EComProductService.entity.Product;
import com.Microservices.EComProductService.exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllProduct();

    ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException;
    ProductResponseDTO createProduct(CreateProductRequestDTO product);
    ProductResponseDTO updateProduct(CreateProductRequestDTO updateProduct, UUID productId);
    boolean deleteproduct(UUID productId);
    ProductResponseDTO getProduct(String productName);

    List<Product> getProducts(double minPrice, double maxPrice);


}
