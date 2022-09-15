package sklep.Entity;

import sklep.Exceptions.ShopException;

import java.util.Currency;

public class ShopItem {

    final private String name;
    final private float price;
    final private int count;

    public ShopItem(String name, float price, int count) throws ShopException {
        if (count <= 0) {
            throw new ShopException("Count must not be less or equal 0");
        }

        if (price < 0.0) {
            throw new ShopException("Price must not by less than 0");
        }

        this.name = name;
        this.price = ((int)(price * 100))/100.0f;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
