package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfigurations {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        String path = "G:/UNIVER/DataBaseOfAbilityCash.db";
        try {
            dataSource.setUrl("jdbc:sqlite:" + path);
            System.out.println("Data Base connection success! Path [ " + path
                    + " ] ..........................................");
        } catch (Exception e) {
            System.out.println("Data Base connection failed! Path [ " + path
                    + " ] ..........................................");
        } finally {
            return dataSource;
        }
    }
}