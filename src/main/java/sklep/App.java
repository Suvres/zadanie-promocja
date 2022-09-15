package sklep;

import sklep.Entity.Discounts.Discount;
import sklep.Entity.ShopItem;
import sklep.Entity.ShoppingCart;
import sklep.Exceptions.ShopException;
import sklep.Service.DiscountService;
import sklep.Service.ShoppingService;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        ShoppingCart cart = new ShoppingCart();
        try {
            cart.getShopItems().add(new ShopItem("Krzesło", 120, 5));
            cart.getShopItems().add(new ShopItem("Stół", 1000, 1));
            cart.getShopItems().add(new ShopItem("Baterie", 2, 5));
            cart.getShopItems().add(new ShopItem("Szafki", 200, 2));
            cart.getShopItems().add(new ShopItem("Klopsiki", 10, 1));
        } catch (ShopException e) {
            throw new RuntimeException(e);
        }

        ShoppingService shoppingService = new ShoppingService();
        shoppingService.computeShoppingCart(cart);
    }
}
