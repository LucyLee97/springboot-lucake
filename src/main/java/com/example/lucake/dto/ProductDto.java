package com.example.lucake.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDto {

    @NotBlank
    private Long id;

    @NotBlank
    private String name;

    private Integer price;

    private String memo;

    private Boolean active = true;
}
