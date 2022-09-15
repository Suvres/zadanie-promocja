package sklep.Entity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    final private List<ShopItem> shopItems;

    public ShoppingCart() {
        this.shopItems = new ArrayList<>();
    }

    public List<ShopItem> getShopItems() {
        return this.shopItems;
    }

    public float getTotalPrice() {
         Float reducePrice = this.shopItems.stream().map(item -> item.getPrice() * item.getCount()).reduce((float) 0, Float::sum);

         return ((int)(reducePrice * 100) / 100.0f);
    }
}
