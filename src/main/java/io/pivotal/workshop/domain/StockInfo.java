package io.pivotal.workshop.domain;

import java.util.Date;

public class StockInfo {

    public final String symbol;
    public final long price;
    public final long volume;
    public Date date;

    public StockInfo(String symbol, long price, long volume, Date date) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.date = date;
    }
}
