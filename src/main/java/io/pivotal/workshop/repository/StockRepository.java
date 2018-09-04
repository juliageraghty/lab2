package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.StockInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRepository extends JpaRepository<StockInfo, Long> {


}