package com.company.icecream;

import com.company.Constants;
import com.company.decorator.ChocolateChips;
import com.company.decorator.ChocolateGlaze;

public class IceCreamFactory {
    public static IceCream createIceCream(String flavour, double pricePerHundredGrams) {
        switch (flavour.toLowerCase()) {
            case Constants.VANILLA_FLAVOUR -> {
                return new VanillaIceCream(pricePerHundredGrams);
            }
            case Constants.CHOCOLATE_FLAVOUR -> {
                return new ChocolateIceCream(pricePerHundredGrams);
            }
            case Constants.STRAWBERRY_FLAVOUR -> {
                return new StrawberryIceCream(pricePerHundredGrams);
            }
            default -> throw new IllegalArgumentException("Unknown ice cream flavour: " + flavour);
        }
    }

    public static IceCream createDecoratedIceCream(String decorator, IceCream iceCream) {
        switch (decorator) {
            case Constants.CHOCOLATE_CHIPS -> {
                return new ChocolateChips(iceCream);
            }
            case Constants.CHOCOLATE_GLAZE -> {
                return new ChocolateGlaze(iceCream);
            }
            default -> throw new IllegalArgumentException("Unknown decoration");
        }
    }
}
