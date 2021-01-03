package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    @GetMapping("/currexg/from/{from}/to/{to}")
    public ExchangeVal getInventoryDetails(@PathVariable("from") Currencies from, @PathVariable("to") Currencies to) {
        ExchangeVal exgVal = null;

        if (Currencies.USD == from && Currencies.ILS == to) {
            exgVal = new ExchangeVal(901, from, to, 6);
        } else if (Currencies.USD == from && Currencies.YEN == to) {
            exgVal = new ExchangeVal(902, from, to, 2);
        }
            return exgVal;
        }
    }
