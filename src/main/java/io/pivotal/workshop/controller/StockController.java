package io.pivotal.workshop.controller;

import io.pivotal.workshop.domain.StockResponse;
import io.pivotal.workshop.repository.StockRepository;
import io.pivotal.workshop.domain.StockInfo;
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
    public Iterable<StockInfo> list() {
        return stockRepository.findAll();
    }


    @GetMapping("/{date}")
    public StockResponse stockInfo(@PathVariable("date") Date date) {
        StockResponse response = new StockResponse();
        response.setDate(Date.valueOf("2018-06-22"));
        response.setPrice(201);
        response.setSymbol("GOOG");
        response.setVolume(123);
        return response;

    }

}
