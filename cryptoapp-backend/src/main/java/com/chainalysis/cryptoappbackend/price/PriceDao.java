package com.chainalysis.cryptoappbackend.price;

import com.chainalysis.cryptoappbackend.price.models.Price;

import java.util.HashMap;
import java.util.Queue;

public interface PriceDao {

    int addPrice(Price price, String exchange);

    HashMap<String, HashMap<String, Queue<Price>>> getPrices();

}

