package com.example.models.dbmodels;

import javax.persistence.*;

@Entity
@Table(name = "TransactionGroups" )
public class TransactionGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String guid;
    private String changed;
    private String deleted;

    private String holderdatatime;
    private String position;
    private String recurrence;

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

    public String getHolderdatatime() {
        return holderdatatime;
    }

    public void setHolderdatatime(String holderdatatime) {
        this.holderdatatime = holderdatatime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }
}
