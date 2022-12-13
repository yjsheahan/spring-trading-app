package com.kok.repositories;

import com.kok.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    @Transactional
    @Query("select s from Stock s where s.nasdaq = :nasdaq")
    public Stock getByNasdaq(@Param("nasdaq") String nasdaq);

    @Transactional
    @Query("SELECT s FROM Stock s WHERE s.stockName = :stockName")
    public Stock getByStockName(@Param("stockName") String stockName);
}
