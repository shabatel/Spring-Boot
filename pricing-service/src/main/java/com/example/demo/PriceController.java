package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PriceController {

    List<Price> priceList = new ArrayList<Price>();

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/price/{productId}")
    public Price getPriceDetails(@PathVariable int productId){
        Price price = getPriceInfo(productId);

        //Get Exchange Value
        double exgVal = restTemplate.getForObject("http://localhost:8004/currexg/from/USD/to/YEN",ExchangeVal.class).getExchangeVal();

        return new Price(price.getPriceId() ,price.getProductId(), price.getOriginalPrice(), (int)Math.multiplyExact((long) exgVal, price.getDiscountedPrice()));
    }

    private Price getPriceInfo(int productId) {
        populatePriceList();

        for (Price p : priceList) {
            if (productId == p.getProductId())
                return p;
        }
        return null;
    }

    private void populatePriceList() {
        priceList.add(new Price(101, 101, 1999, 999));
        priceList.add(new Price(102, 102, 199, 19));
        priceList.add(new Price(103, 103, 2500, 600));
    }
}
