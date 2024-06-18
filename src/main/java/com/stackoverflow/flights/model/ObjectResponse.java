package com.stackoverflow.flights.model;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ObjectResponse {

    private Object responseData;
    private HttpStatus statusCode;
    private String message;
    private String messageType;
}