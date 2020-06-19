package com.example;

import com.example.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("data base connection success ! ..............");
        jdbcTemplate.execute("SELECT * FROM Users");
        //jdbcTemplate.execute("insert into Users values(10,'f','f','f','fofofo')");

        List<Users> users = jdbcTemplate.query("SELECT * FROM Users",
                (resultSet, rowNum) -> new Users(resultSet.getString("Login")));
        users.forEach(System.out::println);
    }
}
