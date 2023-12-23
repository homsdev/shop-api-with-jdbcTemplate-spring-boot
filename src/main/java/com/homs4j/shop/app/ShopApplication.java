package com.homs4j.shop.app;

import com.homs4j.shop.app.dto.requests.PostUserDTO;
import com.homs4j.shop.app.repositories.impl.MySQLProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

    @Autowired
    private MySQLProductRepositoryImpl repository;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

}
