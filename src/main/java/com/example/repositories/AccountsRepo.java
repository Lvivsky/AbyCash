package com.example.repositories;

import com.example.models.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepo extends CrudRepository<Accounts, Integer> {
}