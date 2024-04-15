package com.Microservices.EComProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpectionResponseDTO {
    private String message;
    private int code; // error code, http code etc.

    public ExpectionResponseDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
