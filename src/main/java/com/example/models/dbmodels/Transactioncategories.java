package com.example.models.dbmodels;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "Transactioncategories")
public class Transactioncategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String guid;
    private String changed;
    private String deleted;

    private String category;

    @Column(name = "'transaction'")
    private Integer transaction;

    public Transactioncategories() {}
    public Transactioncategories(Integer categoryId, Integer transactionId){
        this.guid = String.valueOf(UUID.randomUUID());
        this.changed = String.valueOf(Instant.now().getEpochSecond());
        this.deleted = "0";
        this.category = categoryId.toString();
        this.transaction = transactionId;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getTransaction() {
        return transaction;
    }

    public void setTransaction(Integer transaction) {
        this.transaction = transaction;
    }
}
