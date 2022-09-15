package sklep.Entity;

import org.junit.Assert;
import org.junit.Test;
import sklep.Exceptions.ShopException;

public class ShopItemCartTest {

    @Test
    public void testEntity() {
        ShoppingCart cart = new ShoppingCart();

        try {
            cart.getShopItems().add(new ShopItem("test", 123.12f, 3));
            cart.getShopItems().add(new ShopItem("test", 43.129f, 3));
        } catch (ShopException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(498.72f, cart.getTotalPrice(), 1e-03);
    }

}
