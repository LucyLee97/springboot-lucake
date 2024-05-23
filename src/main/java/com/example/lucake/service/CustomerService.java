package com.example.lucake.service;

import com.example.lucake.commen.exception.ApiStatusCodeEnum;
import com.example.lucake.commen.exception.LucakeException;
import com.example.lucake.entity.Customer;
import com.example.lucake.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@CacheConfig(cacheNames = "Customer")
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer createCustomer(String name, String phone, LocalDate birthday) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhone(phone);
        customer.setBirthday(birthday);
        return customerRepo.save(customer);
    }

    public List<Customer> findByName(String name) {
        return customerRepo.findByName(name).orElseThrow(() -> new LucakeException(ApiStatusCodeEnum.RESULT_NOT_FOUND));
    }
}
