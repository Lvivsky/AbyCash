package com.example.repositories;

import com.example.models.dbmodels.Accounts;
import com.example.models.dbmodels.Categories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriesRepo extends CrudRepository<Categories, Integer> {

    @Query(value = "SELECT * FROM Categories WHERE Parent = :id", nativeQuery = true)
    List<Categories> findParent(@Param(value = "id") int id);

    @Query(value = "Select * from Categories where Name = :name", nativeQuery = true)
    Categories findByName(@Param(value = "name") String name);
}
