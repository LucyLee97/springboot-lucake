package com.example.lucake.repository;

import com.example.lucake.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    Optional<List<Customer>> findByName(String name);
}
