package com.example.controllers;

import com.example.models.dbmodels.Currencies;
import com.example.repositories.CurrenciesRepo;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrenciesFolderController {

    @Autowired private UsersRepo usersRepo;
    @Autowired private CurrenciesRepo currenciesRepo;

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

    @PostMapping("/currencies_folder/change")
    public String getChangeInView(
            @RequestParam String curr1,
            @RequestParam String curr2,
            Model model) {

        
        return "redirect:/currencies_folder";
    }

}
