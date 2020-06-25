package com.example.repositories;

import com.example.models.dbmodels.CurrencyRates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CurrenciesRatesRepo extends CrudRepository<CurrencyRates, Integer> {


    @Query(value = "select * from CurrencyRates where Currency1 = :c1 AND Currency2 = :c2", nativeQuery = true)
    Optional<CurrencyRates> findByValues(@Param(value = "c1") Integer c1, @Param(value = "c2") Integer c2);

}
