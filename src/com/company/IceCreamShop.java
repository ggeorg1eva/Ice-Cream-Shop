package com.company;

import com.company.icecream.IceCream;
import com.company.icecream.IceCreamFactory;
import com.company.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IceCreamShop {
    private static IceCreamShop instance;
    private List<IceCream> iceCreams;
    private List<Order> orders;

    private IceCreamShop() {
        this.iceCreams = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public static IceCreamShop getInstance() {
        if (instance == null) {
            instance = new IceCreamShop();
        }
        return instance;
    }

    /**
     * This method creates the ice creams which will be available at the store. Ordes can be placed ONLY with available ice creams.
     * Decorations are considered always available.
     * @param flavour - the flavour that is prepared - chocolate, vanilla or strawberry
     * @param pricePerHundredGrams - the cost of the ice cream for 100 grams
     */
    public void prepareIceCream(String flavour, double pricePerHundredGrams) {
        IceCream iceCream = IceCreamFactory.createIceCream(flavour, pricePerHundredGrams);
        iceCreams.add(iceCream);
    }

    /**
     * This method allows the user to place an order in the shop. One order can consist of one ice cream flavour.
     * Optionally it can have a decoration.
     * @param flavour - the flavour of the ice cream which is to be ordered.
     * @param decorator - the decoration - chocolate glaze, chocolate chips or none
     * @param quantityInGrams - quantity of the ordered ice cream
     * @return - returns a message based on the result of the order: if the ice cream is not available at the shop, it will return a message about it and about the available flavours.
     * If it is available - the order will be created and saved in the list of orders, and a message with details about the order will be returned.
     */
    public String orderIceCream(String flavour, String decorator, double quantityInGrams) {
        boolean isAvailable = checkIceCreamAvailability(flavour);

        if (!isAvailable) {
            return String.format("Sorry! The %s ice cream is not available right now! You can choose from our available ice creams: %s",
                    flavour, getAvailableIceCreamFlavoursAsString());
        }

        IceCream iceCream = getAvailableIceCreamByFlavour(flavour);

        if (!decorator.equalsIgnoreCase(Constants.NO_DECORATOR)) {
            iceCream = IceCreamFactory.createDecoratedIceCream(decorator, iceCream);
        }
        Order order = new Order(iceCream, quantityInGrams);

        orders.add(order);
        return String.format("You successfully placed an order for %s. The total price is: %.2f",
                iceCream.toString(), order.totalPrice());
    }

    /**
     * A method to calculate the total revenue from the placed orders
     */
    public double calculateRevenue() {
        return orders.stream()
                .mapToDouble(Order::totalPrice)
                .sum();
    }

    public List<IceCream> getIceCreams() {
        return iceCreams;
    }

    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Helper method which returns the available flavours of the ice creams in the shop as a string.
     * Example: vanilla, chocolate
     */
    private String getAvailableIceCreamFlavoursAsString() {
        return iceCreams.stream()
                .map(IceCream::getFlavour)
                .collect(Collectors.joining(", "));
    }

    /**
     * Checks if the flavour is available in the shop (if it is in the list of ice creams)
     * @param flavour - the flavour to check
     * @return -  true if it is found and false if it isn't
     */
    private boolean checkIceCreamAvailability(String flavour) {
        return getAvailableIceCreamByFlavour(flavour) != null;
    }

    /**
     * A method which returns the IceCream instance from the list of ice creams based on the flavour
     * @param flavour - the flavour to check
     * @return IceCream instance
     */
    private IceCream getAvailableIceCreamByFlavour(String flavour) {
        return iceCreams.stream().filter(ic -> ic.getFlavour().equalsIgnoreCase(flavour)).findFirst().orElse(null);
    }
}
