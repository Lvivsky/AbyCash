package com.example.repositories;

import com.example.models.dbmodels.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public interface UsersRepo extends CrudRepository<Users, Integer> {
}
