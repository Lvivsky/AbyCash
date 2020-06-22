package com.example.controllers;

import com.example.models.dbmodels.Accounts;
import com.example.models.dbmodels.Categories;
import com.example.models.dbmodels.Currencies;
import com.example.repositories.AccountsRepo;
import com.example.repositories.CurrenciesRepo;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AccountFolderController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private AccountsRepo accountsRepo;

    @Autowired
    private CurrenciesRepo currenciesRepo;

    @GetMapping("/accounts_folder")
    public String index(Model model) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());

        Iterable<Currencies> currencies = currenciesRepo.findAll();
        model.addAttribute("currencies", currencies);

        try {
            Iterable<Accounts> accounts = accountsRepo.findAll();
            model.addAttribute("accounts", accounts);
        } catch (Exception e) {
            System.out.println("шось не так! " + e.getMessage());
            e.printStackTrace();
        }



        return "accounts_folder";
    }

    @PostMapping("/accounts_folder")
    public String addAccount (
            @RequestParam String name,
            @RequestParam Integer startingbalance,
            @RequestParam String currency,
            @RequestParam String comment,
            Model model) {

        if(name.isEmpty() || startingbalance == null)
            return "redirect:/accounts_folder";
        int currId = currenciesRepo.findByCode(currency).getId();
        try {
            Accounts accounts = new Accounts (name, startingbalance, currId, comment, false);
            accountsRepo.save(accounts);
        } catch (Exception e) {
            System.out.println("input bad starting balance!...");
        } finally {
            return "redirect:/accounts_folder";
        }
    }

    @GetMapping("/accounts_folder/{id}/edit")
    public String editAccountGet(@PathVariable(value = "id") int id, Model model) {
        if (!accountsRepo.existsById(id)) return "redirect:/accounts_folder";
        Optional<Accounts> accounts = accountsRepo.findById(id);
        ArrayList<Accounts> res = new ArrayList<Accounts>();
        accounts.ifPresent(res::add);
        model.addAttribute("curr", res);
        return "fragments/editAccount";
    }

    @PostMapping("/accounts_folder/{id}/edit")
    public String editCategoryPost(@PathVariable(value = "id") int id,
                                   @RequestParam String name,
                                   @RequestParam String comment,
                                   @RequestParam boolean locked,
                                   Model model) {
        if (name.isEmpty())
            return "redirect:/accounts_folder";
        Accounts accounts = accountsRepo.findById(id).orElseThrow();
        accounts.setName(name);
        accounts.setComment(comment);
        accounts.setLocked(locked);
        accountsRepo.save(accounts);
        return "redirect:/accounts_folder";
    }


    @PostMapping("/accounts_folder/{id}/delete")
    public String removeAccount(@PathVariable(value = "id") int id, Model model) {
        accountsRepo.deleteById(id);
        return "redirect:/accounts_folder";
    }
}
