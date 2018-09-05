package io.pivotal.workshop.controller;

import io.pivotal.workshop.repository.StockRepository;
import io.pivotal.workshop.domain.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @GetMapping("/list")
    public Iterable<StockQuote> list() {
        return stockRepository.findAll();
    }

    @GetMapping("/{symbol}/{date}")
    public Object queryStockInfoBy(@PathVariable("symbol") String symbol, @PathVariable("date") Date date) {
        return stockRepository.queryStockInfoBy(symbol,date);
    }

}
