package com.example.lucake.service;

import com.example.lucake.commen.secutity.Role;
import com.example.lucake.dto.AuthenticationRq;
import com.example.lucake.dto.AuthenticationRs;
import com.example.lucake.dto.RegisterRq;
import com.example.lucake.entity.Customer;
import com.example.lucake.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public AuthenticationRs register(RegisterRq registerRq) {
        Customer customer = Customer.builder()
                .name(registerRq.getName())
                .phone(registerRq.getPhone())
                .birthday(registerRq.getBirthday())
                .email(registerRq.getEmail())
                .password(passwordEncoder.encode(registerRq.getPassword()))
                .role(Role.USER)
                .build();

        customerRepo.save(customer);
        String jwtToken = jwtService.generateToken(customer);
        return AuthenticationRs.builder().token(jwtToken).build();
    }

    public AuthenticationRs authentication(AuthenticationRq authenticationRq) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRq.getEmail(),
                        authenticationRq.getPassword()
                )
        );

        Customer customer = customerRepo.findByEmail(authenticationRq.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(customer);
        return AuthenticationRs.builder().token(jwtToken).build();
    }
}
