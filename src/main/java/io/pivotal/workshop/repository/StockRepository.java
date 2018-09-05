package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.StockQuote;
import io.pivotal.workshop.domain.StockResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;



@Repository
public interface StockRepository extends JpaRepository<StockQuote, Long> {

    String query = "SELECT DISTINCT s.symbol AS symbol, max(s.price) AS maximum, min(s.price) AS minimum, round(sum(s.volume)) AS totalVolume FROM StockQuote s WHERE s.symbol= :symbol AND s.date= :date GROUP BY s.symbol";
    String query2 = "SELECT s.symbol AS symbol, max(s.price) AS StockResponse.maximum, min(s.price) AS StockResponse.minimum, round(sum(s.volume) AS StockResponse.totalVolume FROM StockQuote s WHERE s.symbol = :symbol AND s.date = :date";
    @Query(value = query)
    Object queryStockInfoBy(@Param("symbol") String symbol, @Param("date")Date date);
}