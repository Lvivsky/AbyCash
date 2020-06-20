package com.example.repositories;

import com.example.models.Categories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriesRepo extends CrudRepository<Categories, Integer> {

    @Query(value = "SELECT * FROM Categories WHERE Parent = 1", nativeQuery = true)
    List<Categories> findIncome();

    @Query(value = "SELECT * FROM Categories WHERE Parent = 2", nativeQuery = true)
    List<Categories> findOutcome();

    @Query(value = "INSERT INTO Categories VALUES (:id,:guid,:changed,:deleted,:name,:comment,:parent)",
            nativeQuery = true)
    void insertValueOutcome(@Param("id") int id,
                            @Param("guid") String guid,
                            @Param("changed") String changed,
                            @Param("deleted") String deleted,
                            @Param("name") String name,
                            @Param("comment") String comment,
                            @Param("parent") String parent

    );

    @Query(value = "INSERT INTO Categories VALUES (100,'fdsf',34,'0','їсти','шось','2')", nativeQuery = true)
    void i();
}
