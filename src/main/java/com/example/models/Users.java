package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String guid;
    private String changed;
    private String deleted;
    private String login;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Users() {}
    public Users(String name) {
        this.login=name;
    }

    @Override
    public String toString() {
        return "name = " + login
                + "\nId = " + id
                + "\nGuid = " + guid
                + "\nChanged = " + changed
                + "\nDeleted = " + deleted
                + "\n=========================";
    }
}
