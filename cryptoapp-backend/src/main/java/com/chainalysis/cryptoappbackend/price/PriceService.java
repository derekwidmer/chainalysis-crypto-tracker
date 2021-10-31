package com.chainalysis.cryptoappbackend.price;

import com.chainalysis.cryptoappbackend.price.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Queue;

@Service
public class PriceService {

    private final PriceDataAccessService dataAccessService;

    @Autowired
    public PriceService(PriceDataAccessService dataAccessService) {
        this.dataAccessService = dataAccessService;
    }

    public HashMap<String, HashMap<String, Queue<Price>>> getPrices() {
        return dataAccessService.getPrices();
    }

    public int addPrice(Price newPrice, String exchange) {
        return dataAccessService.addPrice(newPrice, exchange);
    }
}