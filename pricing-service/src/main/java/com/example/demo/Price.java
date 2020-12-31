package com.example.demo;

public class Price {
    private int priceId;
    private int productId;
    private int originalPrice;
    private int discountedPrice;

    public Price(int priceId, int productId, int originalPrice, int discountedPrice){
        this.priceId = priceId;
        this.productId = productId;
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
    }

    public long getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(int discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }
}