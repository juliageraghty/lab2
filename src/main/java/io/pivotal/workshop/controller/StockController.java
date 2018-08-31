package io.pivotal.workshop.controller;

import io.pivotal.workshop.StockService;
import io.pivotal.workshop.domain.StockInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/list")
    public Iterable<StockInfo> list() {
        return stockService.list();
    }
}
