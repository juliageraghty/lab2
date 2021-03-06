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

    private String JSONUrl = "https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json";

    @Autowired
    private StockRepository stockRepository;

    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @PostMapping("/load")
    public Iterable<StockQuote> uploadFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<StockQuote>> typeReference = new TypeReference<List<StockQuote>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stocks.json");
        return getStockQuotes(mapper.readValue(inputStream, typeReference), mapper, typeReference, inputStream);
    }

    @GetMapping("/list")
    public Iterable<StockQuote> list() {
        return stockRepository.findAll();
    }

    @GetMapping("/{symbol}/{date}")
    public Object queryStockInfoByDate(@PathVariable("symbol") String symbol, @PathVariable("date") Date date) {
        return stockRepository.queryStockInfoByDate(symbol,date);
    }

    @PostMapping("/dynamicLoad")
    public Iterable<StockQuote> dynamicLoad() throws IOException {
        URL url = new URL(JSONUrl);
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<StockQuote>> typeReference = new TypeReference<List<StockQuote>>(){};
        return getStockQuotes(mapper.readValue(url, typeReference), mapper, typeReference, null);
    }

    private Iterable<StockQuote> getStockQuotes(List<StockQuote> o, ObjectMapper mapper, TypeReference<List<StockQuote>> typeReference, InputStream inputStream) {
        List<StockQuote> stocks = o;
        stockRepository.deleteAll();
        stockRepository.saveAll(stocks);
        return stockRepository.findAll();
    }

//    @GetMapping("/{symbol}/month/{date}")
//    public Object queryStockInfoByMonth(@PathVariable("symbol") String symbol, @PathVariable("date") Date date) {
//        return stockRepository.queryStockInfoByMonth(symbol, date);
//    }


}
