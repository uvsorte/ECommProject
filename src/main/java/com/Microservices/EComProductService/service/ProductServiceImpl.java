package com.Microservices.EComProductService.service;

import com.Microservices.EComProductService.dto.CreateProductRequestDTO;
import com.Microservices.EComProductService.dto.ProductResponseDTO;
import com.Microservices.EComProductService.entity.Category;
import com.Microservices.EComProductService.entity.Product;
import com.Microservices.EComProductService.exception.CategoryNotFoundException;
import com.Microservices.EComProductService.exception.ProductNotFoundException;
import com.Microservices.EComProductService.mapper.ProductEntityDTOMapper;
import com.Microservices.EComProductService.repository.CategoryRepository;
import com.Microservices.EComProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProduct() {

        List<Product> savedProducts = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product product : savedProducts){
            productResponseDTOS.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }

        return productResponseDTOS;
    }
    @Override
    public ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException {

        //basic code to implement null check
//        Product savedProduct  = productRepository.findById(productId).get();
//        if(savedProduct == null){
//            throw new ProductNotFoundException("Product not found for id:" + productId);
//        }
//        return savedProduct;


        //Optional Impl - 1
//        Product savedProduct = productRepository.findById(productId).orElseThrow(
//                () -> new ProductNotFoundException("Product not found for id:" +productId)
//        );
//        return savedProduct;

        //optional impl - 2

        Product product =  productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product not found for id:" +productId)
        );
            return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);

    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productRequestDTO) {
        Product product = ProductEntityDTOMapper.convertProductRequestDTOToProduct(productRequestDTO);
        Category savedCategory = categoryRepository.findById(productRequestDTO.getCategoryId().orElseThrow(
                () -> new CategoryNotFoundException("Category not found for id : " + productRequestDTO.getCategoryId()));
        product.setCategory(savedCategory);
        product = productRepository.save(product);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO createProductRequestDTO, UUID productId) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product not found for id : " + productId));
        savedProduct.setTitle(createProductRequestDTO.getTitle());
        savedProduct.setImageURL(createProductRequestDTO.getImageURL());
        savedProduct.setPrice(createProductRequestDTO.getPrice());
        savedProduct.setDescription(createProductRequestDTO.getDescription());
        savedProduct = productRepository.save(savedProduct); // save works as upsert, which is insert and update
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public boolean deleteproduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO getProduct(String productName) {
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(
                productRepository.findProductByTitle(productName)
        );
    }

    @Override
    public List<Product> getProducts(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
