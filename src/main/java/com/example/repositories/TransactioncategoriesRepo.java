package com.example.repositories;

import java.util.List;
import com.example.models.dbmodels.Transactioncategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactioncategoriesRepo extends JpaRepository<Transactioncategories, Integer> {

   List<Transactioncategories> findAllByTransaction(int transaction);

}
