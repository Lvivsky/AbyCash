package com.example.models.nmodel;

public class OperationTransaction {

    private String date;

    private String account;
    private String amount;
    private String balance;

    private String currency;
    private String state;
    private String comment;

    public OperationTransaction() {}

    public OperationTransaction(String date,
                                String accountIncome, String amountIncome, String balance,
                                String currency, String state, String comment) {
        this.date = date;
        this.account = accountIncome;
        this.amount = amountIncome;
        this.balance = balance;
        this.currency = currency;
        this.state = state;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Date: = " + this.date +
                "\nAccountIn = " + this.account +
                "\namountIn = " + this.amount +
                "\nBalance = " + this.balance +
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
