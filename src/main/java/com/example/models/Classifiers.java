package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "Classifiers")
public class Classifiers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String guid;
    private String changed;
    private String deleted;

    private String singularName;
    private String pluralName;

    private String incomeTreeRoot;
    private String expenseTreeRoot;
    private String transferTreeRoot;

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

    public String getSingularName() {
        return singularName;
    }

    public void setSingularName(String singularName) {
        this.singularName = singularName;
    }

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public String getIncomeTreeRoot() {
        return incomeTreeRoot;
    }

    public void setIncomeTreeRoot(String incomeTreeRoot) {
        this.incomeTreeRoot = incomeTreeRoot;
    }

    public String getExpenseTreeRoot() {
        return expenseTreeRoot;
    }

    public void setExpenseTreeRoot(String expenseTreeRoot) {
        this.expenseTreeRoot = expenseTreeRoot;
    }

    public String getTransferTreeRoot() {
        return transferTreeRoot;
    }

    public void setTransferTreeRoot(String transferTreeRoot) {
        this.transferTreeRoot = transferTreeRoot;
    }
}
