package sklep.Entity.Discounts;

import sklep.Entity.ShoppingCart;

public class DiscountB extends Discount {

    @Override
    public float returnDiscountAmount(ShoppingCart items) {
        if ((items.getTotalPrice() - 10000) < 1e-03) {
            return 0;
        }

        return (int)(this.getDiscountValue() * items.getTotalPrice()) / 100.0f;
    }

    @Override
    public int getDiscountValue() {
        return 7;
    }

    @Override
    public String getName() {
        return "Promocja B";
    }
}
