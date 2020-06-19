package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "BudgetLimits")
public class BudgetLimits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String guid;
    private String changed;
    private String deleted;

    private String limitType;
    private String limitYear;
    private String budgetItem;
    private String currency;
    private String averageLimitValue;
    private String MonthLimit1;
    private String MonthLimit2;
    private String MonthLimit3;
    private String MonthLimit4;
    private String MonthLimit5;
    private String MonthLimit6;
    private String MonthLimit7;
    private String MonthLimit8;
    private String MonthLimit9;
    private String MonthLimit10;
    private String MonthLimit11;
    private String MonthLimit12;

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

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public String getLimitYear() {
        return limitYear;
    }

    public void setLimitYear(String limitYear) {
        this.limitYear = limitYear;
    }

    public String getBudgetItem() {
        return budgetItem;
    }

    public void setBudgetItem(String budgetItem) {
        this.budgetItem = budgetItem;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAverageLimitValue() {
        return averageLimitValue;
    }

    public void setAverageLimitValue(String averageLimitValue) {
        this.averageLimitValue = averageLimitValue;
    }

    public String getMonthLimit1() {
        return MonthLimit1;
    }

    public void setMonthLimit1(String monthLimit1) {
        MonthLimit1 = monthLimit1;
    }

    public String getMonthLimit2() {
        return MonthLimit2;
    }

    public void setMonthLimit2(String monthLimit2) {
        MonthLimit2 = monthLimit2;
    }

    public String getMonthLimit3() {
        return MonthLimit3;
    }

    public void setMonthLimit3(String monthLimit3) {
        MonthLimit3 = monthLimit3;
    }

    public String getMonthLimit4() {
        return MonthLimit4;
    }

    public void setMonthLimit4(String monthLimit4) {
        MonthLimit4 = monthLimit4;
    }

    public String getMonthLimit5() {
        return MonthLimit5;
    }

    public void setMonthLimit5(String monthLimit5) {
        MonthLimit5 = monthLimit5;
    }

    public String getMonthLimit6() {
        return MonthLimit6;
    }

    public void setMonthLimit6(String monthLimit6) {
        MonthLimit6 = monthLimit6;
    }

    public String getMonthLimit7() {
        return MonthLimit7;
    }

    public void setMonthLimit7(String monthLimit7) {
        MonthLimit7 = monthLimit7;
    }

    public String getMonthLimit8() {
        return MonthLimit8;
    }

    public void setMonthLimit8(String monthLimit8) {
        MonthLimit8 = monthLimit8;
    }

    public String getMonthLimit9() {
        return MonthLimit9;
    }

    public void setMonthLimit9(String monthLimit9) {
        MonthLimit9 = monthLimit9;
    }

    public String getMonthLimit10() {
        return MonthLimit10;
    }

    public void setMonthLimit10(String monthLimit10) {
        MonthLimit10 = monthLimit10;
    }

    public String getMonthLimit11() {
        return MonthLimit11;
    }

    public void setMonthLimit11(String monthLimit11) {
        MonthLimit11 = monthLimit11;
    }

    public String getMonthLimit12() {
        return MonthLimit12;
    }

    public void setMonthLimit12(String monthLimit12) {
        MonthLimit12 = monthLimit12;
    }
}
