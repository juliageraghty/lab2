package io.pivotal.workshop;

import io.pivotal.workshop.domain.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.pivotal.workshop.repository.StockRepository;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Iterable<StockInfo> list() {
        return stockRepository.findAll();
    }

    public StockInfo save(StockInfo stock) {
        return stockRepository.save(stock);
    }

    public void saveAll(List<StockInfo> stockInfos) {
        saveAll(stockRepository.saveAll(stockInfos));
    }

}