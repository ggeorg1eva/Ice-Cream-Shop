package com.company.decorator;

import com.company.icecream.IceCream;

public class ChocolateGlaze extends IceCreamDecorator{
    public ChocolateGlaze(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String toString() {
        return String.format("%s with chocolate glaze", super.toString());
    }
}
