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
        prices.put("BTC", new HashMap<>());
        prices.put("ETH", new HashMap<>());
        prices.get("BTC").put("Binance", new LinkedList<>());
        prices.get("BTC").put("Coinbase", new LinkedList<>());
        prices.get("ETH").put("Binance", new LinkedList<>());
        prices.get("ETH").put("Coinbase", new LinkedList<>());
    }

    @Override
    public int addPrice(Price price, String exchange) {
        String symbol = price.getSymbol().substring(0,3);
        Queue<Price> listToAddTo = prices.get(symbol).get(exchange);
        listToAddTo.add(price);
        if (listToAddTo.size() > 20) {
            listToAddTo.remove();
        }
        return 1;
    }

    @Override
    public HashMap<String, HashMap<String, Queue<Price>>> getPrices() {
        return prices;
    }
}
