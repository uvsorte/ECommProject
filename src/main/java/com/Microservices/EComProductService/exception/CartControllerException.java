package com.Microservices.EComProductService.exception;

import com.Microservices.EComProductService.dto.ExpectionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CartControllerException {


    public ResponseEntity handleCartNotFoundException(CartNotFoundException ce){
        ExpectionResponseDTO expectionResponseDTO = new ExpectionResponseDTO(
                ce.getMessage(),
                404
        );
        return new ResponseEntity<>(expectionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
