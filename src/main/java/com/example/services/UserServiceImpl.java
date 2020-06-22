package com.example.services;

import com.example.models.dbmodels.Users;
import com.example.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepo userRepo;

    @Override
    public Iterable<Users> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Users find(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public Users save(Users user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
