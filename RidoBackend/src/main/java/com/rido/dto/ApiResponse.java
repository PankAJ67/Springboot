package com.rido.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    private HttpStatus status;
    private boolean success;
    private String message;
}