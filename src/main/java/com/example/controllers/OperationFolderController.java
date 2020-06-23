package com.example.controllers;

import com.example.models.dbmodels.*;
import com.example.models.nmodel.OperationTransaction;
import com.example.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
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
    @Autowired private TransactioncategoriesRepo transactionCategoriesRepo;
    @Autowired private AccountsRepo accountsRepo;
    @Autowired private CurrenciesRepo currenciesRepo;

    @GetMapping("/operation_folder")
    public String getMainTable(Model model) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());

        List<Transactions> transactions = (ArrayList)transactionsRepo.findAll();
        transactions.sort(Comparator.comparing(Transactions::getSortedByDate).reversed());
//        model.addAttribute("operations", transactions);
        try {

            List<Transactions> list = (ArrayList)transactionsRepo.findAll();
            list.sort(Comparator.comparing(Transactions::getSortedByDate).reversed());
            List<OperationTransaction> operationTransaction = new ArrayList<>();


            for (Transactions e: list) {

                List<Transactioncategories> allByTransaction = transactionCategoriesRepo.findAllByTransaction(e.getId());
                Categories categories = null;
                if (!CollectionUtils.isEmpty(allByTransaction)) {
                    categories = categoriesRepo.findById(Integer.valueOf(allByTransaction.get(0).getCategory())).orElse(null);
                }

                Accounts account = null;
                Currencies currencies = null;
                if (e.getIncomeaccount() != null) {
                    account = accountsRepo.findById(Integer.valueOf(e.getIncomeaccount())).orElse(null);
                    currencies = currenciesRepo.findById(Integer.valueOf(e.getIncomeaccount())).orElse(null);
                }

                if (account == null) {
                    continue;
                }

                operationTransaction.add(new OperationTransaction(
                        e.getBudgetdate(),
                        account != null ? account.getName() : null,
                        e.getIncomeamount() != null ? e.getIncomeaccount() : e. getExpenseamount(),
                        currencies != null ? currencies.getCode() : null,
                        categories !=  null ? categories.getName() : null,
                        e.getComment()
                ));
            }


            for (OperationTransaction e: operationTransaction) {
                System.out.println(e.toString());
            }

            model.addAttribute("operations", operationTransaction);


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
