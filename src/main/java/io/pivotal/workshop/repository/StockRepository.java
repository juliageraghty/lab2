package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.StockQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.Month;

@Repository
public interface StockRepository extends JpaRepository<StockQuote, Long> {

    String query = "SELECT NEW io.pivotal.workshop.domain.StockResponse(s.symbol, max(s.price) AS maximum, min(s.price) AS minimum, round(sum(s.volume)) " +
            "AS totalVolume, s.date) FROM StockQuote s WHERE s.symbol = :symbol AND s.date = :date";
//    String query2 = "SELECT NEW io.pivotal.workshop.domain.StockResponse(s.symbol, max(s.price) AS maximum, min(s.price) AS minimum, round(sum(s.volume)) " +
//            "AS totalVolume, s.date) FROM StockQuote s WHERE s.symbol = :symbol AND s.month = :month";
    @Query(value = query)
    Object queryStockInfoBy(@Param("symbol") String symbol, @Param("date")Date date);
}