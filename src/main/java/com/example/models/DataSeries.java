package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "DataSeries")
public class DataSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String guid;
    private String changed;
    private String deleted;

    private String dataSeriesName;
    private String colorHue;
    private String income;
    private String expense;
    private String transfersReceived;
    private String transfersSent;
    private String absolute;
    private String hideBars;
    private String hideLine;

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

    public String getDataSeriesName() {
        return dataSeriesName;
    }

    public void setDataSeriesName(String dataSeriesName) {
        this.dataSeriesName = dataSeriesName;
    }

    public String getColorHue() {
        return colorHue;
    }

    public void setColorHue(String colorHue) {
        this.colorHue = colorHue;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getTransfersReceived() {
        return transfersReceived;
    }

    public void setTransfersReceived(String transfersReceived) {
        this.transfersReceived = transfersReceived;
    }

    public String getTransfersSent() {
        return transfersSent;
    }

    public void setTransfersSent(String transfersSent) {
        this.transfersSent = transfersSent;
    }

    public String getAbsolute() {
        return absolute;
    }

    public void setAbsolute(String absolute) {
        this.absolute = absolute;
    }

    public String getHideBars() {
        return hideBars;
    }

    public void setHideBars(String hideBars) {
        this.hideBars = hideBars;
    }

    public String getHideLine() {
        return hideLine;
    }

    public void setHideLine(String hideLine) {
        this.hideLine = hideLine;
    }
}
