package com.example.lucake.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class ProductOrderDto {

    String id;

    @NotBlank
    String customerId;

    List<ProductOrderDetailDto> productOrderDetailDtoList;
}
