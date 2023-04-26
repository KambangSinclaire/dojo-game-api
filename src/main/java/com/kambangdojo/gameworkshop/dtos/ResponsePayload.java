package com.kambangdojo.gameworkshop.dtos;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponsePayload {
    private HttpStatus statusCode;
    private String message;

}
