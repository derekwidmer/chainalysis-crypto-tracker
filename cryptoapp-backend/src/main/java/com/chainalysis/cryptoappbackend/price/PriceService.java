package com.chainalysis.cryptoappbackend.price;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    public List<Price> getPrices() {
        return List.of();
    }

    @Scheduled
    public List<Price> callApis() {

        return List.of()
    }

}
