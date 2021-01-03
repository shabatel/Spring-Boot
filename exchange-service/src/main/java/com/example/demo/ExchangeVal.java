package com.example.demo;


public class ExchangeVal {
    private int id;
    private Currencies from;
    private Currencies to;
    private double exchangeVal;

    public ExchangeVal(int id, Currencies from, Currencies to, double exchangeVal){
        this.id = id;
        this.from = from;
        this.to = to;
        this.exchangeVal = exchangeVal;
    }
    public Currencies getFrom() {
        return from;
    }

    public Currencies getTo() {
        return to;
    }

    public double getExchangeVal() {
        return exchangeVal;
    }

    public int getId() {
        return id;
    }

    public void setExchangeVal(int exchangeVal) {
        this.exchangeVal = exchangeVal;
    }

    public void setFrom(Currencies from) {
        this.from = from;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTo(Currencies to) {
        this.to = to;
    }
}
