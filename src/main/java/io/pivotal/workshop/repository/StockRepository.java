package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.StockInfo;
import io.pivotal.workshop.domain.StockResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;



@Repository
public interface StockRepository extends JpaRepository<StockInfo, Long> {

    String query = "SELECT DISTINCT s.symbol, max(s.price) AS maximum, min(s.price) AS minimum, round(sum(s.volume)) AS totalVolume FROM StockInfo s WHERE s.symbol= :symbol AND s.date= :date GROUP BY s.symbol";
    @Query(query)
    StockResponse queryByDate(@Param("symbol") String symbol, @Param("date")Date date);
}