// strategy/DiscountContext.java
package com.example.demo.strategy;

public class DiscountContext {

    private DiscountStrategy strategy;

    public DiscountContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double price) {
        return strategy.applyDiscount(price);
    }

    public static DiscountStrategy resolve(String discountType) {
        if (discountType == null) return new NoDiscountStrategy();
        return switch (discountType) {
            case "MEMBER" -> new MemberDiscountStrategy();
            case "SEASONAL" -> new SeasonalSaleStrategy();
            default -> new NoDiscountStrategy();
        };
    }
}