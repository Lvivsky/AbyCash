package com.example.services;

import com.example.entities.Users;

public interface UserService {

    public Iterable<Users> findAll();
    public Users find(int id);
    public Users save(Users user);
    public void delete(int id);
}
