package com.example.repositories;

import com.example.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public interface UserRepo extends CrudRepository<Users, Integer> {
}
