package com.example.controllers;

import com.example.models.dbmodels.Currencies;
import com.example.models.dbmodels.CurrencyRates;
import com.example.repositories.CurrenciesRatesRepo;
import com.example.repositories.CurrenciesRepo;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CurrenciesFolderController {

    @Autowired private UsersRepo usersRepo;
    @Autowired private CurrenciesRepo currenciesRepo;
    @Autowired private CurrenciesRatesRepo currenciesRatesRepo;

    @GetMapping("/currencies_folder")
    public String index(Model model,
                        @RequestParam(required = false) String curr1,
                        @RequestParam(required = false) String curr2) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());

        try {
            // display currencies card
            List<Currencies> currencies = (ArrayList)currenciesRepo.findAll();
            model.addAttribute("currencies", currencies);

            //display currencies rates

            // if currencies not defined - take 2 first in the list
            if (StringUtils.isEmpty(curr1) || StringUtils.isEmpty(curr2)) {
                curr1 = currencies.get(0).getCode();
                curr2 = currencies.get(1).getCode();
            }

            Currencies currency1 = currenciesRepo.findByCode(curr1);
            Currencies currency2 = currenciesRepo.findByCode(curr2);

            Optional<CurrencyRates> currencyRates = currenciesRatesRepo.findByValues(currency1.getId(), currency2.getId());

            String rate1 = currencyRates.map(CurrencyRates::getValue1).orElse(null);
            String rate2 = currencyRates.map(CurrencyRates::getValue2).orElse(null);

            model.addAttribute("curr1", curr1);
            model.addAttribute("curr2", curr2);

            model.addAttribute("rate1", rate1);
            model.addAttribute("rate2", rate2);

        } catch (Exception e) {
            System.out.println("шось не так! " + e.getMessage());
        }

        return "currencies_folder";
    }
}
