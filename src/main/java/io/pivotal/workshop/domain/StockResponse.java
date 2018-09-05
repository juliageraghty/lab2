package io.pivotal.workshop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class StockResponse {

    private String symbol;
    private Long maximum;
    private Long minimum;
    private Long totalVolume;
    private Date date;

    @JsonCreator
    public StockResponse(@JsonProperty("symbol") String symbol,
    @JsonProperty("maximum")
    Long maximum,
    @JsonProperty("minimum")
    Long minimum,
    @JsonProperty("totalVolume")
    Long totalVolume,
    @JsonProperty("date") java.util.Date date)

    {
        this.maximum = maximum;
        this.minimum = minimum;
        this.totalVolume = totalVolume;
        this.symbol = symbol;
        this.date = date;

    }

    public Long getMaximum() {
        return maximum;
    }

    public void setMaximum(Long maximum) {
        this.maximum = maximum;
    }

    public Long getMinimum() {
        return minimum;
    }

    public void setMinimum(Long minimum) {
        this.minimum = minimum;
    }

    public Long getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Long totalVolume) {
        this.totalVolume = totalVolume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
