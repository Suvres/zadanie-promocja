package sklep.Entity;

import org.junit.Assert;
import org.junit.Test;
import sklep.Exceptions.ShopException;

public class ShopItemTest {

    @Test
    public void testEntity() {
        try {
            ShopItem item = new ShopItem("nazwaTestowa", 123.123f, 2);
            Assert.assertEquals("nazwaTestowa", item.getName());
            Assert.assertEquals(123.12f, item.getPrice(), 1e-03);
            Assert.assertEquals(2, item.getCount());
        } catch (ShopException e) {

        }

        try {
            ShopItem item2 = new ShopItem("nazwaTestowa", 10f, 0);
        } catch (ShopException e) {
            Assert.assertEquals("Count must not be less or equal 0", e.getMessage());
        }

        try {
            ShopItem item2 = new ShopItem("nazwaTestowa", -10f, 10);
        } catch (ShopException e) {
            Assert.assertEquals("Price must not by less than 0", e.getMessage());
        }
    }
}
