package com.Microservices.EComProductService.mapper;

import com.Microservices.EComProductService.dto.CreateProductRequestDTO;
import com.Microservices.EComProductService.dto.ProductResponseDTO;
import com.Microservices.EComProductService.entity.Product;

public class ProductEntityDTOMapper {

    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product){

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setCategory(product.getCategory().getName());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setImageURL(product.getImageURL());

        return productResponseDTO;
    }

    public static Product convertProductRequestDTOToProduct(CreateProductRequestDTO productRequestDTO){
        Product product = new Product();
        //product.setCategory(productRequestDTO.getCategory().getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setTitle(productRequestDTO.getTitle());
        product.setRating(0);
        product.setImageURL(productRequestDTO.getImageURL());
        return product;
    }
}
