package sklep.Entity.Discounts;

import sklep.Entity.ShoppingCart;

public class DiscountA extends Discount{

    @Override
    public float returnDiscountAmount(ShoppingCart shoppingCart) {
        if(shoppingCart.getShopItems().size() > 5) {
            return 0;
        }

        return (int)(this.getDiscountValue() * shoppingCart.getTotalPrice()) / 100.0f;
    }

    @Override
    public int getDiscountValue() {
        return 5;
    }

    @Override
    public String getName() {
        return "Promocja A";
    }
}
