package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

public class DatabaseConfig {

    @Bean(name= "dataSource")
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost/test");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Nintendo31Abekat ");

        return driverManagerDataSource;
    }
}
