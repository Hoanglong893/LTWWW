package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EcommerceApplication {
    public static void main(String[] args) {
        System.out.println("=== HASH 123456: " +
                new BCryptPasswordEncoder().encode("123456") + " ===");
        SpringApplication.run(EcommerceApplication.class, args);
    }
}