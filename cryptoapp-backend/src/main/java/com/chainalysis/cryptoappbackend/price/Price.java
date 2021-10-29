package com.chainalysis.cryptoappbackend.price;


import java.time.LocalDateTime;

public class Price {

    private double price;
    private String exchange;
    private LocalDateTime dateTime;

    public Price(double price, String exchange, LocalDateTime dateTime) {
        this.price = price;
        this.exchange = exchange;
        this.dateTime = dateTime;
    }
}
