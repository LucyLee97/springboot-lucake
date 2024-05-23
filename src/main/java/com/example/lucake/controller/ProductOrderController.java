package com.example.lucake.controller;

import com.example.lucake.commen.ApiResponse;
import com.example.lucake.commen.ApiResponseHandler;
import com.example.lucake.entity.ProductOrder;
import com.example.lucake.service.ProductOrderService;
import com.example.lucake.service.dto.ProductOrderDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "訂單")
@RequestMapping("/api/productOrder")
@RestController
public class ProductOrderController {

    @Autowired
    ProductOrderService productOrderService;

    @Operation(summary = "建立新訂單")
    @PostMapping("/create")
    public ApiResponse<ProductOrder> createProductOrder(@RequestBody ProductOrderDto productOrderDto) {
        return ApiResponseHandler.success(productOrderService.createOrder(productOrderDto));
    }

    @Operation(summary = "查詢訂單")
    @GetMapping("/{id}")
    public ApiResponse<ProductOrder> getCustomerOrder(@PathVariable String id) {
        return ApiResponseHandler.success(productOrderService.getProductOrder(id));
    }

    @Operation(summary = "修改訂單明細")
    @PostMapping("/update")
    public ApiResponse<ProductOrder> getCustomerOrderDetail(@RequestBody ProductOrderDto productOrderDto) {
        return ApiResponseHandler.success(productOrderService.updateOrder(productOrderDto));
    }
}
