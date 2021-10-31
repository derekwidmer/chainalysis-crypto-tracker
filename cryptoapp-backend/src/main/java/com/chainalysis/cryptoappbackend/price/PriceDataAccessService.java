package com.chainalysis.cryptoappbackend.price;

import com.chainalysis.cryptoappbackend.price.models.Price;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@Repository
public class PriceDataAccessService implements PriceDao {

    private static HashMap<String, HashMap<String, Queue<Price>>> prices;

    public PriceDataAccessService() {
        prices = new HashMap<>();
        prices.put("BTC", new HashMap<String, Queue<Price>>());
        prices.put("ETH", new HashMap<String, Queue<Price>>());
        prices.get("BTC").put("Binance", new LinkedList<Price>());
        prices.get("BTC").put("Coinbase", new LinkedList<Price>());
        prices.get("ETH").put("Binance", new LinkedList<Price>());
        prices.get("ETH").put("Coinbase", new LinkedList<Price>());
    }

    @Override
    public int addPrice(Price price, String exchange) {
        prices.get(price.getSymbol().substring(0,3)).get(exchange).add(price);
        return 1;
    }

    @Override
    public HashMap<String, HashMap<String, Queue<Price>>> getPrices() {
        return prices;
    }
}
