package sklep.Entity.Discount;

import org.junit.Assert;
import org.junit.Test;
import sklep.Entity.Discounts.DiscountA;
import sklep.Entity.ShopItem;
import sklep.Entity.ShoppingCart;
import sklep.Exceptions.ShopException;

public class DiscountATest {
    @Test
    public void testObject() {
        ShoppingCart cart = new ShoppingCart();

        try {
            cart.getShopItems().add(new ShopItem("test", 10, 1));
            cart.getShopItems().add(new ShopItem("test", 10, 1));
            cart.getShopItems().add(new ShopItem("test", 10, 1));
            cart.getShopItems().add(new ShopItem("test", 10, 1));
            cart.getShopItems().add(new ShopItem("test", 10, 1));
        } catch (ShopException e) {
            throw new RuntimeException(e);
        }


        DiscountA discountA = new DiscountA();
        Assert.assertEquals("Promocja A", discountA.getName());
        Assert.assertEquals(5, discountA.getDiscountValue());

        Assert.assertEquals(2.5f, discountA.returnDiscountAmount(cart), 1e-03);

        try {
            cart.getShopItems().add(new ShopItem("test", 10, 1));
            cart.getShopItems().add(new ShopItem("test", 10, 1));
        } catch (ShopException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(0, discountA.returnDiscountAmount(cart), 1e-03);
    }

}
