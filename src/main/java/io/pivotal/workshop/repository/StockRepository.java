package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.StockInfo;
import io.pivotal.workshop.domain.StockResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.AS;


@Repository
public interface StockRepository extends JpaRepository<StockInfo, Long> {

    String query = "SELECT DISTINCT s.symbol, max(s.price), min(s.price), round(sum(s.volume)) AS totalVolume FROM StockInfo s WHERE s.date= :date GROUP BY s.symbol";
    @Query(query)
    List<StockResponse> queryByDate(@Param("date")Date date);
}