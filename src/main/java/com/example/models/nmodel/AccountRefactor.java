package com.example.models.nmodel;

import java.util.UUID;

public class AccountRefactor {

    private int id;
    private UUID guid;
    private long changed;
    private boolean deleted;

    private String name;
    private long startingbalance;
    private String currency;
    private String comment;
    private boolean locked;

    public AccountRefactor(){}
    public AccountRefactor(int id, UUID guid, long changed, boolean deleted, String name, long startingbalance, String currency, String comment, boolean locked) {
        this.id = id;
        this.guid = guid;
        this.changed = changed;
        this.deleted = deleted;
        this.name = name;
        this.startingbalance = startingbalance;
        this.currency = currency;
        this.comment = comment;
        this.locked = locked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public long getChanged() {
        return changed;
    }

    public void setChanged(long changed) {
        this.changed = changed;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartingbalance() {
        return startingbalance;
    }

    public void setStartingbalance(long startingbalance) {
        this.startingbalance = startingbalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
