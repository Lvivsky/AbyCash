package com.example.controllers;

import com.example.models.dbmodels.Transactions;
import com.example.repositories.TransactionsRepo;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class OperationFolderController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private TransactionsRepo transactionsRepo;

    @GetMapping("/operation_folder")
    public String getMainTable(Model model) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());

        try {
            List<Transactions> transactions = (ArrayList)transactionsRepo.findAll();
            transactions.sort(Comparator.comparing(Transactions::getSortedByDate).reversed());
            model.addAttribute("operations", transactions);

        } catch (Exception e) {
            System.out.println("шось тут не так!!!  " + e.getMessage());
            e.printStackTrace();
        }



        return "operation_folder";
    }
}
