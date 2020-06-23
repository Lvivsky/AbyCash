package com.example.models.dbmodels;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

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
    private String budgetdate;
    private String executed;
    private String locked;

    private String incomeaccount;
    private String incomeamount;
    private String incomebalance;
    private String expenseaccount;
    private String expenseamount;
    private String expensebalance;

    private String quantity;
    private String comment;
    private String extracomment1;
    private String extracomment2;
    private String extracomment3;
    private String extracomment4;
    private String budgetperiodend;


    // return normal date from milliseconds
    public String getBudgetdate() {
        Date date = new Date(Long.valueOf(budgetdate) * 1000);
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdfDate.format(date);
    }

    public String getSortedByDate() {
        return this.budgetdate;
    }

    public void setBudgetdate(String budgetdate) {
        this.budgetdate = budgetdate;
    }

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

    public String getIncomeaccount() {
        return incomeaccount;
    }

    public void setIncomeaccount(String incomeaccount) {
        this.incomeaccount = incomeaccount;
    }

    public String getIncomeamount() {
        return incomeamount;
    }

    public void setIncomeamount(String incomeamount) {
        this.incomeamount = incomeamount;
    }

    public String getIncomebalance() {
        return incomebalance;
    }

    public void setIncomebalance(String incomebalance) {
        this.incomebalance = incomebalance;
    }

    public String getExpenseaccount() {
        return expenseaccount;
    }

    public void setExpenseaccount(String expenseaccount) {
        this.expenseaccount = expenseaccount;
    }

    public String getExpenseamount() {
        return expenseamount;
    }

    public void setExpenseamount(String expenseamount) {
        this.expenseamount = expenseamount;
    }

    public String getExpensebalance() {
        return expensebalance;
    }

    public void setExpensebalance(String expensebalance) {
        this.expensebalance = expensebalance;
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

    public String getExtracomment1() {
        return extracomment1;
    }

    public void setExtracomment1(String extracomment1) {
        this.extracomment1 = extracomment1;
    }

    public String getExtracomment2() {
        return extracomment2;
    }

    public void setExtracomment2(String extracomment2) {
        this.extracomment2 = extracomment2;
    }

    public String getExtracomment3() {
        return extracomment3;
    }

    public void setExtracomment3(String extracomment3) {
        this.extracomment3 = extracomment3;
    }

    public String getExtracomment4() {
        return extracomment4;
    }

    public void setExtracomment4(String extracomment4) {
        this.extracomment4 = extracomment4;
    }

    public String getBudgetperiodend() {
        return budgetperiodend;
    }

    public void setBudgetperiodend(String budgetperiodend) {
        this.budgetperiodend = budgetperiodend;
    }
}
