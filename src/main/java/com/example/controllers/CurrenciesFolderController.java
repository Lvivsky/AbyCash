package com.example.controllers;

import com.example.models.dbmodels.Currencies;
import com.example.models.dbmodels.CurrencyRates;
import com.example.repositories.CurrenciesRatesRepo;
import com.example.repositories.CurrenciesRepo;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CurrenciesFolderController {

    @Autowired private UsersRepo usersRepo;
    @Autowired private CurrenciesRepo currenciesRepo;
    @Autowired private CurrenciesRatesRepo currenciesRatesRepo;

    @GetMapping("/currencies_folder")
    public String index(Model model) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());

        try {
            Iterable<Currencies> currencies = currenciesRepo.findAll();
            model.addAttribute("currencies", currencies);
            model.addAttribute("curr1", null);
            model.addAttribute("curr2", null);
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

        System.out.println(curr1 + "      " + curr2);

        Currencies currency1 = currenciesRepo.findByCode(curr1);
        Currencies currency2 = currenciesRepo.findByCode(curr2);

        Optional<CurrencyRates> currencyRates = currenciesRatesRepo.findByValues(currency1.getId(), currency2.getId());
        if (!currencyRates.isPresent())
        {
            model.addAttribute("curr1", "NONE");
            model.addAttribute("curr2", "NONE");
        } else {
            model.addAttribute("curr1", currencyRates.get().getValue1());
            model.addAttribute("curr2", currencyRates.get().getValue2());
        }

        return "redirect:/currencies_folder";
    }

}
