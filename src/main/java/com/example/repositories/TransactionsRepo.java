package com.example.repositories;

import com.example.models.dbmodels.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface TransactionsRepo extends CrudRepository<Transactions, Integer> {

    @Query(value = "SELECT MAX(Id) FROM Transactions", nativeQuery = true)
    int findLatestId();

}
