package io.pivotal.workshop;


import io.pivotal.workshop.domain.StockInfo;
import io.pivotal.workshop.domain.StockRecord;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class StockPresenter {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

    public StockInfo present(StockRecord record) {
        return new StockInfo(
                record.symbol,
                record.price,
                record.volume,
                record.date);
    }
}
