package io.pivotal.workshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.pivotal.workshop.domain.StockResponse;
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
    public String queryStockInfoBy(@PathVariable("symbol") String symbol, @PathVariable("date") Date date) {
        Object response =  stockRepository.queryStockInfoBy(symbol,date);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String mystring = mapper.writeValueAsString(response);
            String[] parseJson = mystring.split(",");
            StockResponse myStock = new StockResponse(parseJson[0].substring(2, parseJson[0].length()-1),
                    Integer.parseInt(parseJson[1]), Integer.parseInt(parseJson[2]),
                    Integer.parseInt(parseJson[3].substring(0,parseJson[3].length() - 1)));
            return mapper.writeValueAsString(myStock);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
