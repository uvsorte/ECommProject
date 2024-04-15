package com.Microservices.EComProductService.mapper;

import com.Microservices.EComProductService.dto.ProductResponseDTO;
import com.Microservices.EComProductService.entity.Product;

public class ProductEntityDTOMapper {

    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product){

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setProductId(product.getId());
        productResponseDTO.setCategory(product.getCategory());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setImageURL(product.getImageURL());

        return productResponseDTO;
    }
}
