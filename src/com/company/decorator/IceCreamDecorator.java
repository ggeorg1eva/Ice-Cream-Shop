package com.company.decorator;

import com.company.Constants;
import com.company.icecream.IceCream;

public abstract class IceCreamDecorator extends IceCream {
   private IceCream iceCream;

   protected IceCreamDecorator(IceCream iceCream){
       super(iceCream.getFlavour(), iceCream.getPricePerHundredGrams());
       this.iceCream = iceCream;
   }

    public IceCream getIceCream() {
        return iceCream;
    }

    @Override
    public String getProductType() {
        return Constants.PRODUCT_DECORATOR;
    }
}
