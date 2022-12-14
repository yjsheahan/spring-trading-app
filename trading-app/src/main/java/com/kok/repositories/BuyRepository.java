package com.kok.repositories;

import com.kok.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyRepository extends JpaRepository<Transaction, Integer> {

    @Query("select t from Transaction t where t.type = :type order by price, dateCreated ASC")
    public List<Transaction> collectByType(@Param("type") String type);

}
