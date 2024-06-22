package com.company.icecream;

import com.company.Constants;

public abstract class IceCream {
    private String flavour;
    private double pricePerHundredGrams;

    protected IceCream(String flavour, double pricePerHundredGrams) {
        this.flavour = flavour;
        this.pricePerHundredGrams = pricePerHundredGrams;
    }

    public String getProductType(){
        return Constants.PRODUCT_ICE_CREAM;
    }

    public String getFlavour() {
        return flavour;
    }
    public double getPricePerHundredGrams() {
        return pricePerHundredGrams;
    }

    @Override
    public String toString() {
        return String.format("%s ice cream", flavour);
    }
}
