package com.example.repositories;

import com.example.models.dbmodels.Accounts;
import com.example.models.dbmodels.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TransactionsRepo extends JpaRepository<Transactions, Integer> {

    @Query(value = "SELECT MAX(Id) FROM Transactions", nativeQuery = true)
    int findLatestId();

    @Query(value = "SELECT * FROM Transactions where IncomeAccount = :id OR ExpenseAccount = :id", nativeQuery = true)
    Transactions findIncomeAccount(@Param(value = "id") int id);

}
