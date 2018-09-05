package io.pivotal.workshop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

public class StockResponse {

    private Integer maximum;
    private Integer minimum;
    private Integer totalVolume;
    private String symbol;

    @JsonCreator
    public StockResponse(@JsonProperty("symbol") String symbol,
    @JsonProperty("maximum")
    Integer maximum,
    @JsonProperty("minimum")
    Integer minimum,
    @JsonProperty("totalVolume")
    Integer totalVolume)

    {
        this.maximum = maximum;
        this.minimum = minimum;
        this.totalVolume = totalVolume;
        this.symbol = symbol;

    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Integer totalVolume) {
        this.totalVolume = totalVolume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
}
