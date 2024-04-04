import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "cutlet", 100}
        });
    }

    @Test
    public void testIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента должен соответствовать", type, ingredient.getType());
    }

    @Test
    public void testIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Название ингредиента должно соответствовать", name, ingredient.getName());
    }

    @Test
    public void testIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена ингредиента должна соответствовать", price, ingredient.getPrice(), 0.01);
    }
}
