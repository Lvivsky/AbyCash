package com.example.repositories;

import com.example.models.dbmodels.Currencies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CurrenciesRepo extends CrudRepository<Currencies, Integer> {

    @Query(value = "SELECT * FROM Currencies WHERE Code = :code", nativeQuery = true)
    Currencies findByCode(@Param(value = "code") String code);
}
