package sklep.Entity.Discount;

import org.junit.Assert;
import org.junit.Test;
import sklep.Entity.Discounts.DiscountB;
import sklep.Entity.ShopItem;
import sklep.Entity.ShoppingCart;
import sklep.Exceptions.ShopException;

public class DiscountBTest {
    @Test
    public void testObject() {
        ShoppingCart cart = new ShoppingCart();

        try {
            cart.getShopItems().add(new ShopItem("test", 9000, 1));
        } catch (ShopException e) {
            throw new RuntimeException(e);
        }


        DiscountB discountB = new DiscountB();
        Assert.assertEquals("Promocja B", discountB.getName());
        Assert.assertEquals(7, discountB.getDiscountValue());

        Assert.assertEquals(0, discountB.returnDiscountAmount(cart), 1e-03);

        try {

            cart.getShopItems().add(new ShopItem("test", 11000, 1));
        } catch (ShopException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(1400, discountB.returnDiscountAmount(cart), 1e-03);
    }
}
