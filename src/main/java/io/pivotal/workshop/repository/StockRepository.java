package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.StockInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRepository extends CrudRepository<StockInfo, Long> {


}