package com.example.controllers;

import com.example.models.dbmodels.Users;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @Autowired
    private UsersRepo usersRepo;

    @GetMapping("/")
    public String greeting(Model model) {
        Iterable<Users> users = usersRepo.findAll();
        try {
            model.addAttribute("users", users);
            Users u = usersRepo.findById(1).get();
            model.addAttribute("loginUser", u.getLogin());
            System.out.println("моделька працює");
        } catch (Exception e) {
            System.out.println("неможливо добавити нову модельку((");
        } finally {
            for (Users e: users) {
                System.out.println(e.toString());
            }
        }
        return "greeting";
    }
}
