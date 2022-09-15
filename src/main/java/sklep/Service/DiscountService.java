package sklep.Service;

import sklep.Entity.Discounts.Discount;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Class.forName;

public class DiscountService {
    public List<Discount> getDiscountClasses() {
        String discountClass = Discount.class.getPackageName();
        String className = Discount.class.getSimpleName();

        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(discountClass.replace('.', '/'));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        List<String> classList = reader.lines().filter(i -> !i.equals(className + ".class")).collect(Collectors.toList());
        List<Discount> discounts = new ArrayList<>();

        try {
            for (String newClass: classList) {
                Class<Discount> cls = (Class<Discount>) Class.forName(discountClass + "." + newClass.replace(".class", ""));
                Constructor construct = cls.getConstructor();
                Object aa = construct.newInstance();

                discounts.add((Discount) construct.newInstance());
            }
        } catch (ClassNotFoundException|NoSuchMethodException|InvocationTargetException|InstantiationException|IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return discounts;
    }

}
