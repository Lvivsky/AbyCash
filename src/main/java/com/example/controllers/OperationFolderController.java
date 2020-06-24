package com.example.controllers;

import com.example.models.dbmodels.*;
import com.example.models.nmodel.OperationTransaction;
import com.example.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

                String i = e.getIncomeaccount() != null ? e.getIncomeaccount() : e.getExpenseaccount();

                Optional<Accounts> accounts = accountsRepo.findById(Integer.valueOf(i));
                List<Accounts> res = new ArrayList<Accounts>();
                accounts.ifPresent(res::add);

                operationTransaction.add( new OperationTransaction(
                        e.getBudgetdate(),
                        accounts.get().getName(),
                        e.getIncomeamount() != null ? e.getIncomeamount() : e.getExpenseamount(),
                        currenciesRepo.findById(Integer.valueOf(accounts.get().getCurrency())).get().getCode(),
                        categories != null ? categories.getName() : null,
                        e.getComment()));
            }
            model.addAttribute("operations", operationTransaction);
        } catch (Exception e) {
            System.out.println("шось тут не так!!!  " + e.getMessage());
            e.printStackTrace();
        }

        return "operation_folder";
    }

    @GetMapping("/operation_folder/{id}/add")
    public String addTransaction(
            @PathVariable(value = "id") int id,
            Model model) {
        if (id == 1) model.addAttribute("main_title", "Дохід");
        else model.addAttribute("main_title", "Витрата");
        model.addAttribute("all_accounts", accountsRepo.findAllUnlocked());
        model.addAttribute("all_states", categoriesRepo.findParent(id));
        return "/fragments/addTransaction";
    }


    @PostMapping("/operation_folder/{id}/add")
    public String addTransactionPost(@PathVariable(value = "id") int id,
                                     @RequestParam String account_name,
                                     @RequestParam String amount,
                                     @RequestParam String state_name,
                                     @RequestParam String comment,
                                     Model model) {

        System.out.println(
                        "account name = " + account_name +
                        "\namount = " + amount +
                        "\nstate name = " + state_name +
                        "\ncomment = " + comment
        );
        if (amount.isEmpty() || account_name.isEmpty()) return "redirect:/operation_folder";

        Accounts accounts = accountsRepo.findByName(account_name);

        try {
            Transactions transactions;
            if (id == 1) {
                transactions = new Transactions(
                        String.valueOf(accounts.getId()), String.valueOf(amount),
                        String.valueOf(accounts.getStartingbalance()), null, null, null,
                        comment, "10000"
                );
                transactionsRepo.save(transactions);
                Transactioncategories transactioncategories = new Transactioncategories(
                        categoriesRepo.findByName(state_name).getId(), transactionsRepo.findLatestId()
                );
                transactionCategoriesRepo.save(transactioncategories);
            }
            else if (id == 2) {
                transactions = new Transactions(
                        null,
                        null,
                        null,
                        String.valueOf(accounts.getId()),
                        String.valueOf(amount),
                        String.valueOf(accounts.getStartingbalance()),
                        comment,
                        "10000"
                );
                transactionsRepo.save(transactions);
                Transactioncategories transactioncategories
                        = new Transactioncategories(
                        categoriesRepo.findByName(state_name).getId(),
                        transactionsRepo.findLatestId()
                );
                transactionCategoriesRepo.save(transactioncategories);
            }
        }
        catch (Exception e) {
            System.out.println("Помилка ! " + e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/operation_folder";
    }
}
