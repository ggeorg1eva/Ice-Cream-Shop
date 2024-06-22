package com.company.order;

import com.company.Constants;
import com.company.icecream.IceCream;

public class Order {
    private IceCream iceCream;
    private double quantityInGrams;

    public Order(IceCream iceCream, double quantityInGrams) {
        this.iceCream = iceCream;
        this.quantityInGrams = quantityInGrams;
    }

    public double totalPrice() {
        double total = iceCream.getPricePerHundredGrams() * quantityInGrams / 100;
        //If the ice cream has decorations, additional charge is added to the total price
        if (iceCream.getProductType().equals(Constants.PRODUCT_DECORATOR)) {
            total += Constants.DECORATION_CHARGE;
        }
        return total;
    }
}
