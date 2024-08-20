package com.rishi.productservice15aug.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    private String message;
    private String code;

    public ErrorDTO(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
