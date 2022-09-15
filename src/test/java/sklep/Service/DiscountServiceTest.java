package sklep.Service;

import org.junit.Assert;
import org.junit.Test;
import sklep.Entity.Discounts.Discount;

import java.util.List;

public class DiscountServiceTest {
    @Test
    public void testService() {
        DiscountService discountService = new DiscountService();
        List<Discount> discounts = discountService.getDiscountClasses();

        Assert.assertEquals(3, discounts.size());
    }
}
