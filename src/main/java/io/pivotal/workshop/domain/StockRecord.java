package io.pivotal.workshop.domain;

import java.util.Date;

public class StockRecord {

    public final String symbol;
    public final long price;
    public final long volume;
    public Date date;

    public StockRecord(String symbol, long price, long volume, Date date) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.date = date;
    }
}
