package io.pivotal.workshop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class StockInfo {
    @JsonProperty("symbol")
    public final String symbol;
    @JsonProperty("price")
    public final long price;
    @JsonProperty("volume")
    public final long volume;
    @JsonProperty("date")
    public Date date;

    public StockInfo(String symbol, long price, long volume, Date date) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.date = date;
    }
}
