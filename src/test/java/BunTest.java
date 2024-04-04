import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    // дельта вынесена в константу, проверки разделены по принципу 1 проверка = 1 тест, добавлена параметризация

    private static final float DELTA = 0.01f;

    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"black bun", 100f},
                {"white bun", 200f}
        });
    }

    @Test
    public void testName() {
        Bun bun = new Bun(name, price);
        assertEquals("Название булочки должно соответствовать", name, bun.getName());
    }

    @Test
    public void testPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Цена булочки должна соответствовать", price, bun.getPrice(), DELTA);
    }
}
