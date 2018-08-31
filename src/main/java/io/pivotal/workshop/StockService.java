package io.pivotal.workshop;

import io.pivotal.workshop.domain.StockInfo;
import org.springframework.stereotype.Service;
import io.pivotal.workshop.repository.StockRepository;

import java.util.List;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockInfo save(StockInfo stock) {
        return stockRepository.save(stock);
    }

    public Iterable<StockInfo> list() {
        return stockRepository.findAll();
    }
}
