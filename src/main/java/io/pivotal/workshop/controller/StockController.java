package io.pivotal.workshop.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.pivotal.workshop.repository.StockRepository;
import io.pivotal.workshop.domain.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
    public Iterable<StockQuote> uploadFile() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<StockQuote>> typeReference = new TypeReference<List<StockQuote>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stocks.json");
        try {
            List<StockQuote> stocks = mapper.readValue(inputStream,typeReference);
            stockRepository.deleteAll();
            stockRepository.saveAll(stocks);
            return stockRepository.findAll();
        } catch (IOException e){
            System.out.println("Unable to save file to database: " + e.getMessage());
            return null;
        }
    }

    @GetMapping("/list")
    public Iterable<StockQuote> list() {
        return stockRepository.findAll();
    }

    @GetMapping("/{symbol}/{date}")
    public Object queryStockInfoBy(@PathVariable("symbol") String symbol, @PathVariable("date") Date date) {
        return stockRepository.queryStockInfoBy(symbol,date);
    }

    @GetMapping("/load")
    public Iterable<StockQuote> uploadLink() throws IOException {
        URL url = new URL("https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json");
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<StockQuote>> typeReference = new TypeReference<List<StockQuote>>(){};
        try {
            List<StockQuote> stocks = mapper.readValue(url, typeReference);
            stockRepository.deleteAll();
            stockRepository.saveAll(stocks);
            return stockRepository.findAll();
        } catch (IOException e){
            System.out.println("Unable to save file to database: " + e.getMessage());
            return null;
        }
    }

}
