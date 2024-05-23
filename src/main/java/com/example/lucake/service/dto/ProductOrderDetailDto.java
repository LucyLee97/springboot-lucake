package com.example.lucake.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductOrderDetailDto {

    private Long productId;

    private Integer quantity;
}
