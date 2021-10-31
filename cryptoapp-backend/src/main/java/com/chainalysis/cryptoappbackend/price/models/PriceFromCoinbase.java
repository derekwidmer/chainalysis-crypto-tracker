package com.chainalysis.cryptoappbackend.price.models;

import java.util.HashMap;

public class PriceFromCoinbase {

    private String symbol;
    private HashMap<String, String> data;

    public PriceFromCoinbase() {
    }

    public PriceFromCoinbase(String symbol, HashMap<String, String> data) {
        this.symbol = symbol;
        this.data = data;
    }

    public PriceFromCoinbase(HashMap<String, String> data) {
        this.data = data;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PriceFromCoinbase{" +
                "symbol='" + symbol + '\'' +
                ", data=" + data +
                '}';
    }
}
