package io.pivotal.workshop.controller;

import io.pivotal.workshop.domain.StockResponse;
import io.pivotal.workshop.repository.StockRepository;
import io.pivotal.workshop.domain.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @GetMapping("/list")
    public Iterable<StockInfo> list() {
        return stockRepository.findAll();
    }

    @GetMapping("/{symbol}/{date}")
    public StockResponse queryByDate(@PathVariable("symbol") String symbol, @PathVariable("date") Date date) {
        //System.out.println(stockRepository.queryByDate(symbol, date));
        return stockRepository.queryByDate(symbol,date);
    }

}
