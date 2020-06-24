package com.example.repositories;

import com.example.models.dbmodels.Accounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountsRepo extends CrudRepository<Accounts, Integer> {

    @Query(value = "Select * from Accounts where Locked = 0",
            nativeQuery = true)
    List<Accounts> findAllUnlocked();

    @Query(value = "Select * from Accounts where Name = :name", nativeQuery = true)
    Accounts findByName(@Param(value = "name") String name);

}