package com.example.controllers;

import com.example.models.Currencies;
import com.example.models.Users;
import com.example.repositories.CurrenciesRepo;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrenciesFolderController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private CurrenciesRepo currenciesRepo;

    @GetMapping("/currencies_folder")
    public String index(Model model) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());

        try {
            Iterable<Currencies> currencies = currenciesRepo.findAll();
            model.addAttribute("currencies", currencies);
        } catch (Exception e) {
            System.out.println("шось не так! " + e.getMessage());
        }

        return "currencies_folder";
    }
}
