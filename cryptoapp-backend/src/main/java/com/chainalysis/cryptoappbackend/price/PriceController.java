package com.chainalysis.cryptoappbackend.price;

import com.chainalysis.cryptoappbackend.price.models.Price;
import com.chainalysis.cryptoappbackend.price.models.PriceFromBinance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping(path = "api/price")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public HashMap<String, HashMap<String, Queue<Price>>> getPrices() {
        return priceService.getPrices();
    }



}
