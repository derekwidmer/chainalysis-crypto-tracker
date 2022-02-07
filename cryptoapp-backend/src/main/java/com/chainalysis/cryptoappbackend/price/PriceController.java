package com.chainalysis.cryptoappbackend.price;

import com.chainalysis.cryptoappbackend.price.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Queue;

@RestController
@RequestMapping(path = "api/price")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @CrossOrigin
    @GetMapping
    public HashMap<String, HashMap<String, Queue<Price>>> getPrices() {
        return priceService.getPrices();
    }
}
