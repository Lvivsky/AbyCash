package com.example.controllers;

import com.example.models.dbmodels.Accounts;
import com.example.models.dbmodels.Categories;
import com.example.models.dbmodels.Currencies;
import com.example.models.dbmodels.Transactions;
import com.example.models.nmodel.OperationTransaction;
import com.example.repositories.*;
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

    @Autowired private UsersRepo usersRepo;
    @Autowired private TransactionsRepo transactionsRepo;
    @Autowired private CategoriesRepo categoriesRepo;
    @Autowired private TransactionCategoryRepo transactionCategoryRepo;
    @Autowired private AccountsRepo accountsRepo;
    @Autowired private CurrenciesRepo currenciesRepo;

    @GetMapping("/operation_folder")
    public String getMainTable(Model model) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());

        List<Transactions> transactions = (ArrayList)transactionsRepo.findAll();
        transactions.sort(Comparator.comparing(Transactions::getSortedByDate).reversed());
        model.addAttribute("operations", transactions);
        try {

            List<Transactions> list = (ArrayList)transactionsRepo.findAll();
            list.sort(Comparator.comparing(Transactions::getSortedByDate).reversed());
            List<OperationTransaction> operationTransaction = new ArrayList<>();

            for (Transactions e: list) {
                Optional<Accounts> account = accountsRepo.findById(Integer.valueOf(e.getIncomeaccount()));
                Optional<Currencies> currencies = currenciesRepo.findById(Integer.valueOf(e.getIncomeaccount()));
                Optional<Categories> categories = categoriesRepo.findById(
                        Integer.valueOf(transactionCategoryRepo.findByTransaction(String.valueOf(e.getId()))));

                operationTransaction.add(new OperationTransaction(
                        e.getBudgetdate(),
                        account.get().getName(),
                        e.getIncomeamount(),
                        e.getExpenseamount(),
                        currencies.get().getCode(),
                        categories.get().getName(),
                        e.getComment()
                ));
            }


            for (OperationTransaction e: operationTransaction) {
                System.out.println(e.toString());
            }



        } catch (Exception e) {
            System.out.println("шось тут не так!!!  " + e.getMessage());
            e.printStackTrace();
        }



        return "operation_folder";
    }
    private Integer getThisCategory(Transactions t) {



        return 0;
    }
}
