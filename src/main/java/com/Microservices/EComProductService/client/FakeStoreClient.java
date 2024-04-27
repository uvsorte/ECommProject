package com.Microservices.EComProductService.client;

import com.Microservices.EComProductService.dto.FakeStoreDTOs.FakeStoreCartResponseDTO;
import com.Microservices.EComProductService.dto.FakeStoreDTOs.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class FakeStoreClient {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIUrl;

    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;

    @Value("${fakestore.api.cart.for.user.path}")
    private String fakeStoreAPICartForUser;


    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductURL = fakeStoreAPIUrl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList =
                restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }


    public FakeStoreProductResponseDTO getProductById(int id){
        String fakeStoreGetProductByIdURL = fakeStoreAPIUrl.concat(fakeStoreAPIProductPath).concat("/" + id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productByIdResponse =
                restTemplate.getForEntity(fakeStoreGetProductByIdURL, FakeStoreProductResponseDTO.class);

        return productByIdResponse.getBody();

    }

    public List<FakeStoreCartResponseDTO> getCartByUserId(int userId) {
        if(userId < 1)
            return null;
        String fakeStoreGetCartForUser = fakeStoreAPIUrl.concat(fakeStoreAPICartForUser).concat(String.valueOf(userId));
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartResponse =
                restTemplate.getForEntity(fakeStoreGetCartForUser, FakeStoreCartResponseDTO[].class);
        return List.of(cartResponse.getBody());
    }
}
