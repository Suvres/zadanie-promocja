package sklep.Service;

import sklep.Entity.Discounts.Discount;
import sklep.Entity.ShoppingCart;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShoppingService {

    private final DiscountService discountService;
    private final Logger logger;

    public ShoppingService(){
        this.discountService = new DiscountService();
        this.logger = Logger.getLogger(ShoppingService.class.getName());
    }

    public void computeShoppingCart(ShoppingCart shoppingCart) {
        List<Discount> discounts = this.discountService.getDiscountClasses();
        float totalAmount = shoppingCart.getTotalPrice();
        StringBuilder builder = new StringBuilder();

        String totalText = String.format("Kwota całkowita: %.2f zł", shoppingCart.getTotalPrice());

        System.out.println(totalText);
        builder.append(totalText)
                .append("; ");

        totalAmount -= this.calcDiscount(shoppingCart, discounts, builder);

        String text = String.format("Kwota do zapłaty: %.2f zł", totalAmount);
        System.out.println(text);
        builder.append(text);

        this.logger.log(Level.INFO, builder.toString());
    }

    private float calcDiscount(ShoppingCart shoppingCart, List<Discount> discounts, StringBuilder builder) {
        float discountAmount = 0.0f;

        for (Discount d : discounts) {
            float amount = d.returnDiscountAmount(shoppingCart);
            if (amount < 1e-03) {
                continue;
            }

            String text = String.format("%s: %.2f zł", d.getName(), amount);

            System.out.println(text);
            builder.append(text)
                    .append("; ");

            discountAmount += amount;
        }

        return discountAmount;
    }
}
