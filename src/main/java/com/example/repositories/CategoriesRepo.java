package com.example.repositories;

import com.example.models.Categories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriesRepo extends CrudRepository<Categories, Integer> {


    @Query(value = "SELECT * FROM Categories WHERE Parent = :id", nativeQuery = true)
    List<Categories> findParent(@Param(value = "id") int id);

    @Query(value = "SELECT * FROM Categories WHERE Id = :id", nativeQuery = true)
    Categories findCategoryById(@Param("id") int id);




}
