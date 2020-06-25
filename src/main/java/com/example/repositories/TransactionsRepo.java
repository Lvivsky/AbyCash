package com.example.repositories;

import com.example.models.dbmodels.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface TransactionsRepo extends JpaRepository<Transactions, Integer> {

    @Query(value = "SELECT MAX(Id) FROM Transactions", nativeQuery = true)
    int findLatestId();

}
