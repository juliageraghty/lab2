package io.pivotal.workshop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StockResponse {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    public long price;
    public long volume;
    public Date date;

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }


}
