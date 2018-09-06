package io.pivotal.workshop.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.pivotal.workshop.domain.StockResponse;
import io.pivotal.workshop.repository.StockRepository;
import io.pivotal.workshop.domain.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
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

    @GetMapping("/save")
    public String uploadFile() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<StockQuote>> typeReference = new TypeReference<List<StockQuote>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stocks.json");
        try {
            List<StockQuote> stocks = mapper.readValue(inputStream,typeReference);
            stockRepository.deleteAll();
            stockRepository.saveAll(stocks);
            return "File successfully saved to database";
        } catch (IOException e){
            return "Unable to save file to database: " + e.getMessage();
        }
    }

    @GetMapping("/load")
    public Iterable<StockQuote> list() {
        return stockRepository.findAll();
    }

    @GetMapping("/{symbol}/{date}")
    public Object queryStockInfoBy(@PathVariable("symbol") String symbol, @PathVariable("date") Date date) {
        return stockRepository.queryStockInfoBy(symbol,date);
    }

}
