package io.pivotal.workshop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StockQuote {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String symbol;
    public long price;
    public long volume;
    @Temporal(TemporalType.DATE)
    @Column(name = "date", columnDefinition = "DATETIME")
    public Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public long getPrice() {
        return price;
    }

    public long getVolume() {
        return volume;
    }

    public Date getDate() {
        return date;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StockQuote() { }
}
