package com.example.models;

import javax.persistence.*;

@Entity
@Table(name="Transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String guid;
    private String changed;
    private String deleted;

    private String position;
    private String budgetDate;
    private String executed;
    private String locked;

    private String incomeAccount;
    private String incomeAmount;
    private String incomeBalance;
    private String expenseAccount;
    private String expenseAmount;
    private String expenseBalance;

    private String quantity;
    private String comment;
    private String extraComment1;
    private String extraComment2;
    private String extraComment3;
    private String extraComment4;
    private String budgetPeriodEnd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBudgetDate() {
        return budgetDate;
    }

    public void setBudgetDate(String budgetDate) {
        this.budgetDate = budgetDate;
    }

    public String getExecuted() {
        return executed;
    }

    public void setExecuted(String executed) {
        this.executed = executed;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getIncomeAccount() {
        return incomeAccount;
    }

    public void setIncomeAccount(String incomeAccount) {
        this.incomeAccount = incomeAccount;
    }

    public String getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(String incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getIncomeBalance() {
        return incomeBalance;
    }

    public void setIncomeBalance(String incomeBalance) {
        this.incomeBalance = incomeBalance;
    }

    public String getExpenseAccount() {
        return expenseAccount;
    }

    public void setExpenseAccount(String expenseAccount) {
        this.expenseAccount = expenseAccount;
    }

    public String getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(String expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseBalance() {
        return expenseBalance;
    }

    public void setExpenseBalance(String expenseBalance) {
        this.expenseBalance = expenseBalance;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getExtraComment1() {
        return extraComment1;
    }

    public void setExtraComment1(String extraComment1) {
        this.extraComment1 = extraComment1;
    }

    public String getExtraComment2() {
        return extraComment2;
    }

    public void setExtraComment2(String extraComment2) {
        this.extraComment2 = extraComment2;
    }

    public String getExtraComment3() {
        return extraComment3;
    }

    public void setExtraComment3(String extraComment3) {
        this.extraComment3 = extraComment3;
    }

    public String getExtraComment4() {
        return extraComment4;
    }

    public void setExtraComment4(String extraComment4) {
        this.extraComment4 = extraComment4;
    }

    public String getBudgetPeriodEnd() {
        return budgetPeriodEnd;
    }

    public void setBudgetPeriodEnd(String budgetPeriodEnd) {
        this.budgetPeriodEnd = budgetPeriodEnd;
    }
}
