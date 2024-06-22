package com.company.decorator;

import com.company.icecream.IceCream;

public class ChocolateChips extends IceCreamDecorator{
    public ChocolateChips(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String toString() {
        return String.format("%s with chocolate chips", super.toString());
    }
}
