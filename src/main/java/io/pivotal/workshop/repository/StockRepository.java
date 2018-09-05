package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.StockQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface StockRepository extends JpaRepository<StockQuote, Long> {

    String query = "SELECT DISTINCT s.symbol AS symbol, max(s.price) AS maximum, min(s.price) AS minimum, " +
            "round(sum(s.volume)) AS totalVolume, s.date AS date FROM StockQuote s WHERE s.symbol= :symbol AND s.date= :date GROUP BY s.symbol";
    String query2 = "SELECT NEW io.pivotal.workshop.domain.StockResponse(s.symbol, max(s.price) AS maximum, min(s.price) AS minimum, round(sum(s.volume)) " +
            "AS totalVolume, s.date) FROM StockQuote s WHERE s.symbol = :symbol AND s.date = :date";
    @Query(value = query2)
    Object queryStockInfoBy(@Param("symbol") String symbol, @Param("date")Date date);
}