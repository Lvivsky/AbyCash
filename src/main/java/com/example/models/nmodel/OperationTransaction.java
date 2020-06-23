package com.example.models.nmodel;

import com.example.models.dbmodels.Accounts;
import com.example.models.dbmodels.Categories;
import com.example.models.dbmodels.Currencies;
import com.example.models.dbmodels.Transactions;

public class OperationTransaction {

    private String date;
    private String account;
    private String amountIncome;
    private String amountExpanse;
    private String currency;
    private String state;
    private String comment;

    public OperationTransaction() {}
    public OperationTransaction(Transactions transactions,
                                Accounts accounts,
                                Categories categories,
                                Currencies currencies) {
        this.date = transactions.getBudgetdate();
        this.account = accounts.getName();
        this.amountIncome = transactions.getIncomeamount();
        this.amountExpanse = transactions.getExpenseamount();
        this.currency = currencies.getCode();
        this.state = categories.getName();
        this.comment = transactions.getComment();
    }

    public OperationTransaction(String date, String account, String amountIncome, String amountExpanse, String currency, String state, String comment) {
        this.date = date;
        this.account = account;
        this.amountIncome = amountIncome;
        this.amountExpanse = amountExpanse;
        this.currency = currency;
        this.state = state;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Date: = " + this.date +
                "\nAccount = " + this.account +
                "\namount income = " + this.amountIncome +
                "\namount expanse = " + this.amountExpanse +
                "\nCurrency = " + this.currency +
                "\nState = " + this.state +
                "\nComment = " + this.comment +
                "===============================";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAmountIncome() {
        return amountIncome;
    }

    public void setAmountIncome(String amountIncome) {
        this.amountIncome = amountIncome;
    }

    public String getAmountExpanse() {
        return amountExpanse;
    }

    public void setAmountExpanse(String amountExpanse) {
        this.amountExpanse = amountExpanse;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
