import static org.junit.Assert.*;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void testEnumValues() {
        // Получение массивазначений IngredientType
        IngredientType[] values = IngredientType.values();

        // Проверяю, что в перечислении есть элементы
        assertTrue("Перечисление должно содержать элементы", values.length > 0);

        // Проверяю, что можно получить элемент перечисления по его имени "SAUCE"
        assertNotNull("Перечисление должно содержать элемент SAUCE", IngredientType.valueOf("SAUCE"));

        // Проверю, что можно получить элемент перечисления по его имени "FILLING"
        assertNotNull("Перечисление должно содержать элемент FILLING", IngredientType.valueOf("FILLING"));
    }
}