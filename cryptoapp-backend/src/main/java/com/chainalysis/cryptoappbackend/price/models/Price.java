package com.chainalysis.cryptoappbackend.price.models;

import java.time.LocalDateTime;

public class Price {

    private String symbol;
    private double buyPrice;
    private double sellPrice;
    private LocalDateTime dateTime;

    public Price() {
    }

    public Price(String symbol, double buyPrice, double sellPrice, LocalDateTime dateTime) {
        this.symbol = symbol;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.dateTime = dateTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Price{" +
                "symbol='" + symbol + '\'' +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", dateTime=" + dateTime +
                '}';
    }
}
