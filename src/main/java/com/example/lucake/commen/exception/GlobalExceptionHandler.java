package com.example.lucake.commen.exception;

import com.example.lucake.commen.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception ex) {
        log.error(ex.toString(), ex.getCause());
        ApiResponse<Object> apiResponse = new ApiResponse<>(ApiStatusCodeEnum.UNKNOWN_ERROR, ex.toString());
        return ResponseEntity.ok(apiResponse);
    }

    @ExceptionHandler(LucakeException.class)
    public ResponseEntity<ApiResponse<Object>> handleLucakeException(LucakeException ex) {
        log.error(ex.toString(), ex.getCause());
        ApiResponse<Object> apiResponse = new ApiResponse<>(ex.getStatusCodeEnum().getCode(), ex.getStatusCodeEnum().getDesc());
        return ResponseEntity.ok(apiResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error(ex.toString(), ex.getCause());
        ApiResponse<Object> apiResponse = new ApiResponse<>(ApiStatusCodeEnum.INPUT_ERROR.getCode(), ApiStatusCodeEnum.INPUT_ERROR.getDesc());
        return ResponseEntity.ok(apiResponse);
    }
}
