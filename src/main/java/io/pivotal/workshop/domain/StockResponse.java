package io.pivotal.workshop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
public class StockResponse {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @JsonProperty("maximum")
    public Integer maximum;
    @JsonProperty("minimum")
    public Integer minimum;
    @JsonProperty("totalVolume")
    public Integer totalVolume;
    @JsonProperty("symbol")

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public long getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Integer totalVolume) {
        this.totalVolume = totalVolume;
    }

    public long getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
