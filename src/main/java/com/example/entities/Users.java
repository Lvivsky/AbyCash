package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String guid;
    private String changed;
    private String deleted;
    private String login;

    public Users(String name) {
        this.login=name;
    }

    @Override
    public String toString() {
        return "name = " + login;
    }
}
