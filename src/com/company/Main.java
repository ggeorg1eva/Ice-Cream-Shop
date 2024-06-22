package com.company;

import com.company.eatingstrategy.EatInPark;
import com.company.eatingstrategy.EatOnBeach;
import com.company.eatingstrategy.EatingStrategy;

public class Main {

    public static void main(String[] args) {
        IceCreamShop shop = IceCreamShop.getInstance();
        shop.prepareIceCream(Constants.VANILLA_FLAVOUR, 1.25);
        shop.prepareIceCream(Constants.CHOCOLATE_FLAVOUR, 1.30);
        //shop.prepareIceCream(Constants.STRAWBERRY_FLAVOUR, 1.50); - commented out because it shouldn't be available at the shop

        String s = shop.orderIceCream(Constants.STRAWBERRY_FLAVOUR, Constants.CHOCOLATE_CHIPS, 250);
        System.out.println(s);

        //total price is 200 * 1.30 / 100 + 0 because no decoration
        String s2 = shop.orderIceCream(Constants.CHOCOLATE_FLAVOUR, Constants.NO_DECORATOR, 200);

        EatingStrategy eatingStrategy = new EatInPark();
        System.out.println(String.format("%s. Enjoy your ice cream %s nearby!", s2, eatingStrategy.eat()));

        //total price is 100 * 1.25 / 100 + 1.50 because there is decoration
        String s3 = shop.orderIceCream(Constants.VANILLA_FLAVOUR, Constants.CHOCOLATE_GLAZE, 100);
        eatingStrategy = new EatOnBeach();
        System.out.println(String.format("%s. Enjoy your ice cream %s nearby!", s3, eatingStrategy.eat()));

        System.out.println("*******************************************");
        //total revenue is 2.60 + 2.75 from the 2 orders placed above
        System.out.println(String.format("You hacked into the shop's base! Oh well, here is the total revenue: %.2f", shop.calculateRevenue()));
    }
}
