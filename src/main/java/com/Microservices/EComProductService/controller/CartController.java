package com.Microservices.EComProductService.controller;

import com.Microservices.EComProductService.client.FakeStoreClient;
import com.Microservices.EComProductService.dto.FakeStoreCartResponseDTO;
import com.Microservices.EComProductService.exception.CartNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class CartController {

    @Autowired
    private FakeStoreClient fakeStoreClient;


    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId){
        List<FakeStoreCartResponseDTO> cartResponse = fakeStoreClient.getCartByUserId(userId);
        if(cartResponse == null){
            throw new CartNotFoundException("Cart not found for userID " + userId);
        }
        return ResponseEntity.ok(cartResponse);

    }
}
