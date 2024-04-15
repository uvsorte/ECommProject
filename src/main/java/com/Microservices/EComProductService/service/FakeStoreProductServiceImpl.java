package com.Microservices.EComProductService.service;

import com.Microservices.EComProductService.client.FakeStoreClient;
import com.Microservices.EComProductService.dto.FakeStoreProductResponseDTO;
import com.Microservices.EComProductService.entity.Product;
import com.Microservices.EComProductService.exception.NoProductPresentException;
import com.Microservices.EComProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    @Autowired
      private FakeStoreClient fakeStoreClient;


    @Override
    public List<FakeStoreProductResponseDTO> getAllProduct() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        if(fakeStoreProducts == null){
            throw new NoProductPresentException("No product are found!!");
        }
        return fakeStoreProducts;
    }




    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductById(productId);
        if(fakeStoreProductResponseDTO == null){
            throw new ProductNotFoundException("Product is not found with id:" + productId);
        }
        return fakeStoreProductResponseDTO;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product updateProduct, int productId) {
        return null;
    }

    @Override
    public boolean deleteproduct(int productId) {
        return false;
    }
}
