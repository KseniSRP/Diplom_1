import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"black bun", 100},
                {"white bun", 200}
        });
    }

    @Test
    public void testBunNameAndPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Название булочки должно соответствовать", name, bun.getName());
        assertEquals("Цена булочки должна соответствовать", price, bun.getPrice(), 0.01);
    }
}
