package com.example.controllers;

import com.example.models.dbmodels.Accounts;
import com.example.models.dbmodels.Currencies;
import com.example.models.dbmodels.Transactions;
import com.example.models.nmodel.AccountRefactor;
import com.example.repositories.AccountsRepo;
import com.example.repositories.CurrenciesRepo;
import com.example.repositories.TransactionsRepo;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class AccountFolderController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private AccountsRepo accountsRepo;

    @Autowired
    private CurrenciesRepo currenciesRepo;

    @Autowired
    private TransactionsRepo transactionsRepo;

    @GetMapping("/accounts_folder")
    public String index(Model model) {
        model.addAttribute("loginUser", usersRepo.findById(1).get().getLogin());

        Iterable<Currencies> currencies = currenciesRepo.findAll();
        model.addAttribute("currencies", currencies);
        try {
            List<Transactions> transactions = transactionsRepo.findAll();
            Map<String, List<Transactions>> incomeAccountMap = transactions.stream()
                .filter(t -> !StringUtils.isEmpty(t.getIncomeaccount()))
                .filter(t -> !StringUtils.isEmpty(t.getIncomeamount()))
                .collect(Collectors.groupingBy(Transactions::getIncomeaccount));

            Map<String, List<Transactions>> expenseAccountMap = transactions.stream()
                .filter(t -> !StringUtils.isEmpty(t.getExpenseaccount()))
                .filter(t -> !StringUtils.isEmpty(t.getExpenseamount()))
                .collect(Collectors.groupingBy(Transactions::getExpenseaccount));

            List<Accounts> accounts = accountsRepo.findAll();
            accounts.forEach(account -> {
                Long expenseTotal = 0l;
                if (!CollectionUtils.isEmpty(expenseAccountMap.get(String.valueOf(account.getId())))) {
                    expenseTotal = expenseAccountMap.get(String.valueOf(account.getId())).stream()
                        .map(expenseAccount -> {
                            Long expense = new Long(expenseAccount.getExpenseamount());
                            if (expense > 0) {
                                expense = 0 - expense;
                            }
                            return expense;
                        })
                        .reduce(0l, (a, b) -> a + b);
                }

                Long incomeTotal = 0l;
                if (!CollectionUtils.isEmpty(incomeAccountMap.get(String.valueOf(account.getId())))) {
                    incomeTotal = incomeAccountMap.get(String.valueOf(account.getId())).stream()
                        .map(incomeAccount -> {
                            Long income = new Long(incomeAccount.getIncomeamount());
                            if (income < 0) {
                                income = 0 - income;
                            }
                            return income;
                        })
                        .reduce(0l, (a, b) -> a + b);
                }

                account.setStartingbalance(account.getStartingbalance() + incomeTotal + expenseTotal);
            });

            List <AccountRefactor> accountRefactors = new ArrayList<>();

            for (Accounts a: accounts) {
                accountRefactors.add(new AccountRefactor(

                        a.getId(),
                        a.getGuid(),
                        a.getChanged(),
                        a.isDeleted(),
                        a.getName(),
                        a.getStartingbalance(),
                        currenciesRepo.findById(a.getCurrency()).get().getCode(),
                        a.getComment(),
                        a.isLocked()
                ));
            }

            model.addAttribute("accounts", accountRefactors);
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
                                   @RequestParam(required=false) boolean locked,
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
