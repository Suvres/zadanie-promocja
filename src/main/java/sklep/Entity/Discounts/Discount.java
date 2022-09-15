package sklep.Entity.Discounts;

import sklep.Entity.ShoppingCart;

abstract public class Discount {

    abstract public float returnDiscountAmount(ShoppingCart items);

    abstract public int getDiscountValue();
    abstract public String getName();
}
