package sklep.Entity.Discount;

import org.junit.Assert;
import org.junit.Test;
import sklep.Entity.Discounts.DiscountC;
import sklep.Entity.ShopItem;
import sklep.Entity.ShoppingCart;
import sklep.Exceptions.ShopException;

public class DiscountCTest {
    @Test
    public void testObject() {
        ShoppingCart cart = new ShoppingCart();

        DiscountC discountC = new DiscountC();
        Assert.assertEquals("Promocja C", discountC.getName());
        Assert.assertEquals(10, discountC.getDiscountValue());

        try {

            cart.getShopItems().add(new ShopItem("test", 30, 1));
            cart.getShopItems().add(new ShopItem("test", 25, 1));
        } catch (ShopException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(0, discountC.returnDiscountAmount(cart), 1e-03);

        try {

            cart.getShopItems().add(new ShopItem("test", 40, 1));
            cart.getShopItems().add(new ShopItem("test", 27, 1));
        } catch (ShopException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(2.7f, discountC.returnDiscountAmount(cart), 1e-03);
    }
}
