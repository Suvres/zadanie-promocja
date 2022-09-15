package sklep.Entity.Discounts;

import sklep.Entity.ShopItem;
import sklep.Entity.ShoppingCart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DiscountC extends Discount{

    @Override
    public float returnDiscountAmount(ShoppingCart items) {
        if (items.getShopItems().size() < 3) {
            return 0;
        }

        List<ShopItem> tmpList = new ArrayList<>(List.copyOf(items.getShopItems()));

        tmpList.sort(Comparator.comparing(ShopItem::getPrice).reversed());

        ShopItem tmpItem = tmpList.get(2);
        return (int)(this.getDiscountValue() * tmpItem.getCount() * tmpItem.getPrice()) / 100.0f;

    }

    @Override
    public int getDiscountValue() {
        return 10;
    }

    @Override
    public String getName() {
        return "Promocja C";
    }
}
