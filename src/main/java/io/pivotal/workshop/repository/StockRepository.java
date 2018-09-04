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

    @Query("SELECT DISTINCT" + "symbol, max(price), min(price), (round(sum(volume)) AS totalVolume) FROM stockdb.stock_info WHERE date=? GROUP BY symbol")
    List<StockResponse> queryByDate(@Param("date")Date date);
}