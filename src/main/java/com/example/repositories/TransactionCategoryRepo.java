package com.example.repositories;

import com.example.models.dbmodels.Transactioncategories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionCategoryRepo extends CrudRepository<Transactioncategories, Integer> {


    String findByTransaction(String transaction);

}
