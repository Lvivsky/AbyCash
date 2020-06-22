package com.example.models.dbmodels;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "Accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UUID guid;
    private long changed;
    private boolean deleted;

    private String name;
    private double startingbalance;
    private int currency;
    private String comment;
    private boolean locked;

    public Accounts() {}
    public Accounts(String name, double startingbalance, int currency, String comment, boolean locked) {
        this.guid = UUID.randomUUID();
        this.changed = Instant.now().getEpochSecond();
        this.deleted = false;
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

    public double getStartingbalance() {
        return startingbalance;
    }

    public void setStartingbalance(double startingbalance) {
        this.startingbalance = startingbalance;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
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
