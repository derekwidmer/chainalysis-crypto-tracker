package com.chainalysis.cryptoappbackend.price;

import com.chainalysis.cryptoappbackend.price.models.Price;
import com.chainalysis.cryptoappbackend.price.models.PriceFromBinance;
import com.chainalysis.cryptoappbackend.price.models.PriceFromCoinbase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Component
public class ScheduledApiCalls {


    private static PriceService priceService;

    @Autowired
    public ScheduledApiCalls(PriceService priceService) {
        this.priceService = priceService;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    public RestTemplate template = new RestTemplate();

    @Scheduled(fixedRate = 5000)
    public void callApis() throws Exception {
        LocalDateTime dateTime = LocalDateTime.now();
//      Getting price from BINANCE
        Price priceOfBTCBinance = getPriceFromBinance("BTC", dateTime);
        savePrice(priceOfBTCBinance, "Binance");
        Price priceOfETHBinance = getPriceFromBinance("ETH", dateTime);
        savePrice(priceOfETHBinance, "Binance");
//      Getting price from Coinbase
        Price priceOfBTCCoinbase = getPriceFromCoinbase("BTC", dateTime);
        savePrice(priceOfBTCCoinbase, "Coinbase");
        Price priceOfETHCoinbase = getPriceFromCoinbase("ETH", dateTime);
        savePrice(priceOfETHCoinbase, "Coinbase");
    }

    public Price getPriceFromBinance(String symbol, LocalDateTime dateTime) {
        String baseURI = "https://api.binance.com/api/v3/ticker/bookTicker?symbol=";
        String qSymbol = symbol+"USDT";
        String URI = baseURI + qSymbol;
        PriceFromBinance priceFromBinance = template.getForObject(URI, PriceFromBinance.class);
        Price price = new Price(priceFromBinance.getSymbol(),
                Double.parseDouble(priceFromBinance.getBidPrice()),
                Double.parseDouble(priceFromBinance.getAskPrice()),
                dateTime);
        return price;
    }

    public Price getPriceFromCoinbase(String symbol, LocalDateTime dateTime) {
        String baseURI = "https://api.coinbase.com/v2/prices/";
        String qSymbol = symbol+"-USD";
        String URISell = baseURI + qSymbol + "/sell";
        String URIBuy = baseURI + qSymbol + "/buy";
        PriceFromCoinbase priceFromCoinbaseSell = template.getForObject(URISell, PriceFromCoinbase.class);
        PriceFromCoinbase priceFromCoinbaseBuy = template.getForObject(URIBuy, PriceFromCoinbase.class);
        System.out.println("Coinbase amount query:" + priceFromCoinbaseBuy.getData().get("amount"));
        Price price = new Price(symbol,
                Double.parseDouble(priceFromCoinbaseSell.getData().get("amount")),
                Double.parseDouble(priceFromCoinbaseBuy.getData().get("amount")),
                dateTime
                );
        return price;
    }

    public void savePrice(Price price, String exchange) {
        priceService.addPrice(price, exchange);
    }

}
