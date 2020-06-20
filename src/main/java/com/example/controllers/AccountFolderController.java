package com.example.controllers;

import com.example.models.Accounts;
import com.example.models.Users;
import com.example.repositories.AccountsRepo;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountFolderController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private AccountsRepo accountsRepo;

    @GetMapping("/accounts_folder")
    public String index(Model model) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());

        try {
            Iterable<Accounts> accounts = accountsRepo.findAll();
            model.addAttribute("accounts", accounts);
        } catch (Exception e) {
            System.out.println("шось не так! " + e.getMessage());
            e.printStackTrace();
        }


        return "accounts_folder";
    }
}
