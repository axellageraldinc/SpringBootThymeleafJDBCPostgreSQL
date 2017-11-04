package com.example.demo;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceConfig {

    public static DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:1414/BelajarSpring");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("password");
        return driverManagerDataSource;
    }
}
