package com.Microservices.EComProductService.service;

import com.Microservices.EComProductService.client.FakeStoreClient;
import com.Microservices.EComProductService.dto.FakeStoreDTOs.FakeStoreProductResponseDTO;
import com.Microservices.EComProductService.entity.Product;
import com.Microservices.EComProductService.exception.NoProductPresentException;
import com.Microservices.EComProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl{

    @Autowired
      private FakeStoreClient fakeStoreClient;



    public List<FakeStoreProductResponseDTO> getAllProduct() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        if(fakeStoreProducts == null){
            throw new NoProductPresentException("No product are found!!");
        }
        return fakeStoreProducts;
    }





    public FakeStoreProductResponseDTO getProduct(int productId) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductById(productId);
        if(fakeStoreProductResponseDTO == null){
            throw new ProductNotFoundException("Product is not found with id:" + productId);
        }
        return fakeStoreProductResponseDTO;
    }


    public Product createProduct(Product product) {
        return null;
    }


    public Product updateProduct(Product updateProduct, int productId) {
        return null;
    }


    public boolean deleteproduct(int productId) {
        return false;
    }
}
