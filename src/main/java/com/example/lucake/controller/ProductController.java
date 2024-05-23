package com.example.lucake.controller;

import com.example.lucake.commen.ApiResponse;
import com.example.lucake.commen.ApiResponseHandler;
import com.example.lucake.dto.ProductDto;
import com.example.lucake.entity.Product;
import com.example.lucake.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "商品")
@RequestMapping("/api/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation(summary = "建立商品")
    @PostMapping("/create")
    public ApiResponse<Product> createProduct(@Valid @RequestBody ProductDto productDto) {
        return ApiResponseHandler.success(productService.createProduct(
                productDto.getName(), productDto.getPrice(), productDto.getMemo(), productDto.getActive()));
    }

    @Operation(summary = "查詢商品資訊")
    @GetMapping("/{id}")
    public ApiResponse<Product> findProduct(@PathVariable Long id) {
        return ApiResponseHandler.success(productService.findById(id));
    }

    @Operation(summary = "更新商品")
    @PostMapping("/update")
    public ApiResponse<Product> updatePrice(@Valid @RequestBody ProductDto productDto) {
        return ApiResponseHandler.success(productService.updatePrice(
                productDto.getId(), productDto.getName(), productDto.getPrice(), productDto.getMemo(), productDto.getActive()));
    }

    @Operation(summary = "查詢全部商品資訊")
    @GetMapping("/findAll")
    public ApiResponse<List<Product>> findAllProduct(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return ApiResponseHandler.success(productService.findAllPagition(pageNumber, pageSize));
    }

    @Operation(summary = "刪除商品")
    @PostMapping("/delete/{id}")
    public ApiResponse<Long> deleteProduct(@PathVariable Long id) {
        return ApiResponseHandler.success(productService.deleteProduct(id));
    }
}
