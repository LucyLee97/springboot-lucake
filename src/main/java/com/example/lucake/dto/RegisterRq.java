package com.example.lucake.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRq {

    private String name;
    private String phone;
    private LocalDate birthday;
    private String email;
    private String password;
}
