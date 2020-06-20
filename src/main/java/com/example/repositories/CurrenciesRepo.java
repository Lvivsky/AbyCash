package com.example.repositories;

import com.example.models.Currencies;
import org.springframework.data.repository.CrudRepository;

public interface CurrenciesRepo extends CrudRepository<Currencies, Integer> {
}
