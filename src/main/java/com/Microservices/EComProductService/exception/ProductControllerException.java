package com.Microservices.EComProductService.exception;

import com.Microservices.EComProductService.controller.ProductController;
import com.Microservices.EComProductService.dto.ExpectionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerException {

    @ExceptionHandler({ProductNotFoundException.class,NoProductPresentException.class})
    public ResponseEntity handleNoProductException(ProductNotFoundException pe){
        ExpectionResponseDTO expectionResponseDTO = new ExpectionResponseDTO(
                pe.getMessage(),
                404
        );
        return new ResponseEntity<>(expectionResponseDTO, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler({InvalidInputException.class})
    public ResponseEntity handleInvalidProductException(InvalidInputException invalidProduct ){
        ExpectionResponseDTO expectionResponseDTO = new ExpectionResponseDTO(
                invalidProduct.getMessage(),
                400
        );
                return new ResponseEntity<>(expectionResponseDTO,HttpStatus.BAD_REQUEST);
    }


}
