package com.example.lucake.controller;

import com.example.lucake.commen.ApiResponse;
import com.example.lucake.commen.ApiResponseHandler;
import com.example.lucake.dto.CustomerDto;
import com.example.lucake.entity.Customer;
import com.example.lucake.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "客戶")
@RequestMapping("/api/customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Operation(summary = "建立客戶資訊")
    @PostMapping("/create")
    public ApiResponse<Customer> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return ApiResponseHandler.success(customerService.createCustomer(
                customerDto.getName(), customerDto.getPhone(), customerDto.getBirthday()));
    }

    @Operation(summary = "查詢客戶資訊")
    @GetMapping("/findByName")
    public ApiResponse<List<Customer>> findByName(@RequestParam String name) {
        return ApiResponseHandler.success(customerService.findByName(name));
    }

}
